import contextlib
import os
import sys

from py4j.java_gateway import JavaGateway, java_import, CallbackServerParameters, GatewayParameters, launch_gateway, \
    JVMView


class Context(contextlib.AbstractContextManager):
    """
    A Spellsource Context is a proxy for the Java game engine code.

    A proxy means that calling methods on this object sends messages to a running Java Virtual Machine (JVM) to execute
    identically-named Java methods. Once the Java code is done running, a message is passed back with return values.
    The underlying system is networked. This proxy is managed by the package py4j, and is performant enough for many
    tasks.

    Because a JVM is an executable process and network sockets are used, the lifecycle of a Context instance must be
    managed carefully. Like opening a file, there's a great pattern for using a context, called the 'contextlib'
    pattern:
    >>> with Context() as context:
    >>>     ...
    When a context is initialized this way, you're guaranteed to close it correctly in the event of an error in your
    program or the Context class itself.

    The most common Java Spellsource packages are exported in an instance of this class as attributes. For example,
    to access the Java class GameContext, which is located in the Java net.demilich.metastone.game package,
    the "game" package is available as an attribute:
    >>> with Context() as context:
    >>>     game_context = context.game.GameContext()
    Observe that the subpackages of net.demilich.metastone.game are all available this way. Alternatively,
    access the "root" package using root_namespace():
    >>> with Context() as context:
    >>>     game_context = context.root_namespace().net.demilich.metastone.game.GameContext()
    """
    STATUS_READY = 1
    STATUS_FAILED = 2
    _LINE_BUFFERED = 1

    def __init__(self):
        self._is_closed = False
        try:
            self._gateway = Context._start_gateway()
        except FileNotFoundError:
            self.status = Context.STATUS_FAILED
            raise FileNotFoundError('Could not find the JAR file that stores the Spellsource Engine. Did you run gradle net:shadowJar?')
        except Exception as ex:
            self.status = Context.STATUS_FAILED
            raise ex

        for name, package in (('game', 'net.demilich.metastone.game.*'),
                              ('entities', 'net.demilich.metastone.game.entities.*'),
                              ('decks', 'net.demilich.metastone.game.decks.*'),
                              ('events', 'net.demilich.metastone.game.events.*'),
                              ('actions', 'net.demilich.metastone.game.actions.*'),
                              ('logic', 'net.demilich.metastone.game.logic.*'),
                              ('cards', 'net.demilich.metastone.game.cards.*'),
                              ('spells', 'net.demilich.metastone.game.spells.*'),
                              ('targeting', 'net.demilich.metastone.game.targeting.*'),
                              ('utils', 'net.demilich.metastone.game.utils.*'),
                              ('behaviour', 'net.demilich.metastone.game.behaviour.*'),
                              ('spellsource', 'com.hiddenswitch.spellsource.*')):
            view = self._gateway.new_jvm_view(name)
            java_import(view, package)
            setattr(self, name, view)

        # Include the important classes and enums
        self.GameAction = self.actions.GameAction
        self.GameContext = self.game.GameContext
        self.Card = self.cards.CardCatalogue
        self.Deck = self.decks.Deck
        self.Entity = self.entities.Entity
        self.Actor = self.entities.Actor
        self.GameEvent = self.events.GameEvent
        self.GameEventType = self.game.events.GameEventType
        self.EntityType = self.entities.EntityType
        self.Weapon = self.entities.Weapons.Weapon
        self.Minion = self.entities.minions.Minion
        self.Hero = self.entities.heroes.Hero
        self.Attribute = self.utils.Attribute
        self.ActionType = self.actions
        self.Rarity = self.cards.Rarity
        self.CardType = self.cards.CardType
        self.CardSet = self.cards.CardSet
        self.GameLogic = self.logic.GameLogic
        self.Zones = self.targeting.Zones
        self.HeroClass = self.entities.heroes.HeroClass
        self.CardCatalogue = self.cards.CardCatalogue
        self.PythonBridge = self._gateway.jvm.com.hiddenswitch.spellsource.applications.PythonBridge
        self.ArrayList = self._gateway.jvm.java.util.ArrayList
        self.Spellsource = self.spellsource.Spellsource

        self.CardCatalogue.loadCardsFromPackage()
        self.status = Context.STATUS_READY

    def root_namespace(self) -> JVMView:
        """
        Returns a reference to the "root" namespace of the Java code. This lets you access Java classes by package
        name. For example, to access the GameContext Java class, use:
        >>> root_namespace().net.demilich.metastone.game.GameContext()
        :return: A JVM gateway from py4j
        """
        return self._gateway.jvm

    def close(self):
        """
        Closes the context by terminating the JVM and closing the sockets used by the proxy system in py4j.
        :return:
        """
        if not hasattr(self, '_gateway'):
            return
        # self.process.send_signal(signal=signal.SIGINT)
        self._gateway.close()
        self._is_closed = True

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.close()

    def __del__(self):
        if self._is_closed:
            return

        self.close()

    @staticmethod
    def find_resource_path(filename='net-0.7.6-all.jar'):
        """
        Tries to find the path where the Spellsource jar is located.
        """
        paths = []
        paths.append(filename)
        # local
        paths.append(os.path.join(os.path.dirname(
            os.path.realpath(__file__)), "../net/build/libs/" + filename))
        paths.append(os.path.join(os.path.dirname(
            os.path.realpath(__file__)), "../docs/" + filename))
        paths.append(os.path.join(os.path.dirname(
            os.path.realpath(__file__)), "../net/lib/" + filename))
        paths.append(os.path.join(os.path.dirname(
            os.path.realpath(__file__)), '../share/spellsource/' + filename))
        paths.append(os.path.join(sys.prefix, 'share/spellsource/' + filename))
        # pip install py4j # On Ubuntu 16.04, where virtualenvpath=/usr/local
        #   this file is here:
        #     virtualenvpath/lib/pythonX/dist-packages/spellsource/java_gateway.py
        #   the jar file is here: virtualenvpath/share/spellsource/py4j.jar
        # pip install --user py4j # On Ubuntu 16.04, where virtualenvepath=~/.local
        #   this file is here:
        #     virtualenvpath/lib/pythonX/site-packages/spellsource/java_gateway.py
        #   the jar file is here: virtualenvpath/share/spellsource/py4j.jar
        paths.append(os.path.join(os.path.dirname(
            os.path.realpath(__file__)), "../../../../share/spellsource/" + filename))

        for path in paths:
            if os.path.exists(path):
                return path
        raise FileNotFoundError()

    @staticmethod
    def _start_gateway() -> JavaGateway:
        # launch Java side with dynamic port and get back the port on which the
        # server was bound to.
        port = launch_gateway(port=0,
                              classpath=Context.find_resource_path('net-0.7.6-all.jar'),
                              javaopts=["--add-modules", "java.se",
                                        "--add-exports", "java.base/jdk.internal.ref=ALL-UNNAMED",
                                        "--add-opens", "java.base/java.lang=ALL-UNNAMED",
                                        "--add-opens", "java.base/java.nio=ALL-UNNAMED",
                                        "--add-opens", "java.base/sun.nio.ch=ALL-UNNAMED",
                                        "--add-opens", "java.management/sun.management=ALL-UNNAMED",
                                        "--add-opens", "jdk.management/com.sun.management.internal=ALL-UNNAMED"],
                              die_on_exit=True)

        # connect python side to Java side with Java dynamic port and start python
        # callback server with a dynamic port
        gateway = JavaGateway(
            gateway_parameters=GatewayParameters(port=port, auto_convert=True),
            callback_server_parameters=CallbackServerParameters(port=0))

        # retrieve the port on which the python callback server was bound to.
        python_port = gateway.get_callback_server().get_listening_port()

        # tell the Java side to connect to the python callback server with the new
        # python port. Note that we use the java_gateway_server attribute that
        # retrieves the GatewayServer instance.
        gateway.java_gateway_server.resetCallbackClient(
            gateway.java_gateway_server.getCallbackClient().getAddress(),
            python_port)
        return gateway

    def is_open(self):
        return self._gateway._gateway_client.is_connected

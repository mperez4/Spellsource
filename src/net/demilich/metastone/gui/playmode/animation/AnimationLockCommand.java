package net.demilich.metastone.gui.playmode.animation;

import de.pferdimanzug.nittygrittymvc.SimpleCommand;
import de.pferdimanzug.nittygrittymvc.interfaces.INotification;
import net.demilich.metastone.GameNotification;
import net.demilich.metastone.gui.playmode.GameContextVisualizable;

public class AnimationLockCommand extends SimpleCommand<GameNotification> {

	@Override
	public void execute(INotification<GameNotification> notification) {
		AnimationProxy animationProxy = (AnimationProxy) getFacade().retrieveProxy(AnimationProxy.NAME);
		
		GameContextVisualizable contextVisualizable = (GameContextVisualizable) notification.getBody();
		animationProxy.setContext(contextVisualizable);
	}

}

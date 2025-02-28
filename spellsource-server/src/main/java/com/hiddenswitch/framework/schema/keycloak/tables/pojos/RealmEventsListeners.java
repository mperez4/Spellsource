/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.pojos;


import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IRealmEventsListeners;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RealmEventsListeners implements VertxPojo, IRealmEventsListeners {

    private static final long serialVersionUID = 1L;

    private String realmId;
    private String value;

    public RealmEventsListeners() {}

    public RealmEventsListeners(IRealmEventsListeners value) {
        this.realmId = value.getRealmId();
        this.value = value.getValue();
    }

    public RealmEventsListeners(
        String realmId,
        String value
    ) {
        this.realmId = realmId;
        this.value = value;
    }

        public RealmEventsListeners(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>keycloak.realm_events_listeners.realm_id</code>.
     */
    @Override
    public String getRealmId() {
        return this.realmId;
    }

    /**
     * Setter for <code>keycloak.realm_events_listeners.realm_id</code>.
     */
    @Override
    public RealmEventsListeners setRealmId(String realmId) {
        this.realmId = realmId;
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_events_listeners.value</code>.
     */
    @Override
    public String getValue() {
        return this.value;
    }

    /**
     * Setter for <code>keycloak.realm_events_listeners.value</code>.
     */
    @Override
    public RealmEventsListeners setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RealmEventsListeners (");

        sb.append(realmId);
        sb.append(", ").append(value);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IRealmEventsListeners from) {
        setRealmId(from.getRealmId());
        setValue(from.getValue());
    }

    @Override
    public <E extends IRealmEventsListeners> E into(E into) {
        into.from(this);
        return into;
    }
}

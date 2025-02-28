/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.records;


import com.hiddenswitch.framework.schema.keycloak.tables.RealmEventsListeners;
import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IRealmEventsListeners;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RealmEventsListenersRecord extends TableRecordImpl<RealmEventsListenersRecord> implements VertxPojo, Record2<String, String>, IRealmEventsListeners {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>keycloak.realm_events_listeners.realm_id</code>.
     */
    @Override
    public RealmEventsListenersRecord setRealmId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_events_listeners.realm_id</code>.
     */
    @Override
    public String getRealmId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>keycloak.realm_events_listeners.value</code>.
     */
    @Override
    public RealmEventsListenersRecord setValue(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_events_listeners.value</code>.
     */
    @Override
    public String getValue() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return RealmEventsListeners.REALM_EVENTS_LISTENERS.REALM_ID;
    }

    @Override
    public Field<String> field2() {
        return RealmEventsListeners.REALM_EVENTS_LISTENERS.VALUE;
    }

    @Override
    public String component1() {
        return getRealmId();
    }

    @Override
    public String component2() {
        return getValue();
    }

    @Override
    public String value1() {
        return getRealmId();
    }

    @Override
    public String value2() {
        return getValue();
    }

    @Override
    public RealmEventsListenersRecord value1(String value) {
        setRealmId(value);
        return this;
    }

    @Override
    public RealmEventsListenersRecord value2(String value) {
        setValue(value);
        return this;
    }

    @Override
    public RealmEventsListenersRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
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

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RealmEventsListenersRecord
     */
    public RealmEventsListenersRecord() {
        super(RealmEventsListeners.REALM_EVENTS_LISTENERS);
    }

    /**
     * Create a detached, initialised RealmEventsListenersRecord
     */
    public RealmEventsListenersRecord(String realmId, String value) {
        super(RealmEventsListeners.REALM_EVENTS_LISTENERS);

        setRealmId(realmId);
        setValue(value);
    }

    /**
     * Create a detached, initialised RealmEventsListenersRecord
     */
    public RealmEventsListenersRecord(com.hiddenswitch.framework.schema.keycloak.tables.pojos.RealmEventsListeners value) {
        super(RealmEventsListeners.REALM_EVENTS_LISTENERS);

        if (value != null) {
            setRealmId(value.getRealmId());
            setValue(value.getValue());
        }
    }

        public RealmEventsListenersRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}

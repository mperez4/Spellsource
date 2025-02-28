/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.records;


import com.hiddenswitch.framework.schema.keycloak.tables.RealmSupportedLocales;
import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IRealmSupportedLocales;

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
public class RealmSupportedLocalesRecord extends TableRecordImpl<RealmSupportedLocalesRecord> implements VertxPojo, Record2<String, String>, IRealmSupportedLocales {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>keycloak.realm_supported_locales.realm_id</code>.
     */
    @Override
    public RealmSupportedLocalesRecord setRealmId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_supported_locales.realm_id</code>.
     */
    @Override
    public String getRealmId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>keycloak.realm_supported_locales.value</code>.
     */
    @Override
    public RealmSupportedLocalesRecord setValue(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_supported_locales.value</code>.
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
        return RealmSupportedLocales.REALM_SUPPORTED_LOCALES.REALM_ID;
    }

    @Override
    public Field<String> field2() {
        return RealmSupportedLocales.REALM_SUPPORTED_LOCALES.VALUE;
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
    public RealmSupportedLocalesRecord value1(String value) {
        setRealmId(value);
        return this;
    }

    @Override
    public RealmSupportedLocalesRecord value2(String value) {
        setValue(value);
        return this;
    }

    @Override
    public RealmSupportedLocalesRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IRealmSupportedLocales from) {
        setRealmId(from.getRealmId());
        setValue(from.getValue());
    }

    @Override
    public <E extends IRealmSupportedLocales> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RealmSupportedLocalesRecord
     */
    public RealmSupportedLocalesRecord() {
        super(RealmSupportedLocales.REALM_SUPPORTED_LOCALES);
    }

    /**
     * Create a detached, initialised RealmSupportedLocalesRecord
     */
    public RealmSupportedLocalesRecord(String realmId, String value) {
        super(RealmSupportedLocales.REALM_SUPPORTED_LOCALES);

        setRealmId(realmId);
        setValue(value);
    }

    /**
     * Create a detached, initialised RealmSupportedLocalesRecord
     */
    public RealmSupportedLocalesRecord(com.hiddenswitch.framework.schema.keycloak.tables.pojos.RealmSupportedLocales value) {
        super(RealmSupportedLocales.REALM_SUPPORTED_LOCALES);

        if (value != null) {
            setRealmId(value.getRealmId());
            setValue(value.getValue());
        }
    }

        public RealmSupportedLocalesRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}

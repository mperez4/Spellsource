/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.records;


import com.hiddenswitch.framework.schema.keycloak.tables.RealmDefaultGroups;
import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IRealmDefaultGroups;

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
public class RealmDefaultGroupsRecord extends TableRecordImpl<RealmDefaultGroupsRecord> implements VertxPojo, Record2<String, String>, IRealmDefaultGroups {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>keycloak.realm_default_groups.realm_id</code>.
     */
    @Override
    public RealmDefaultGroupsRecord setRealmId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_default_groups.realm_id</code>.
     */
    @Override
    public String getRealmId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>keycloak.realm_default_groups.group_id</code>.
     */
    @Override
    public RealmDefaultGroupsRecord setGroupId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_default_groups.group_id</code>.
     */
    @Override
    public String getGroupId() {
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
        return RealmDefaultGroups.REALM_DEFAULT_GROUPS.REALM_ID;
    }

    @Override
    public Field<String> field2() {
        return RealmDefaultGroups.REALM_DEFAULT_GROUPS.GROUP_ID;
    }

    @Override
    public String component1() {
        return getRealmId();
    }

    @Override
    public String component2() {
        return getGroupId();
    }

    @Override
    public String value1() {
        return getRealmId();
    }

    @Override
    public String value2() {
        return getGroupId();
    }

    @Override
    public RealmDefaultGroupsRecord value1(String value) {
        setRealmId(value);
        return this;
    }

    @Override
    public RealmDefaultGroupsRecord value2(String value) {
        setGroupId(value);
        return this;
    }

    @Override
    public RealmDefaultGroupsRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IRealmDefaultGroups from) {
        setRealmId(from.getRealmId());
        setGroupId(from.getGroupId());
    }

    @Override
    public <E extends IRealmDefaultGroups> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RealmDefaultGroupsRecord
     */
    public RealmDefaultGroupsRecord() {
        super(RealmDefaultGroups.REALM_DEFAULT_GROUPS);
    }

    /**
     * Create a detached, initialised RealmDefaultGroupsRecord
     */
    public RealmDefaultGroupsRecord(String realmId, String groupId) {
        super(RealmDefaultGroups.REALM_DEFAULT_GROUPS);

        setRealmId(realmId);
        setGroupId(groupId);
    }

    /**
     * Create a detached, initialised RealmDefaultGroupsRecord
     */
    public RealmDefaultGroupsRecord(com.hiddenswitch.framework.schema.keycloak.tables.pojos.RealmDefaultGroups value) {
        super(RealmDefaultGroups.REALM_DEFAULT_GROUPS);

        if (value != null) {
            setRealmId(value.getRealmId());
            setGroupId(value.getGroupId());
        }
    }

        public RealmDefaultGroupsRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}

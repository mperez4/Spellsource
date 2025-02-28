/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.spellsource.tables.records;


import com.hiddenswitch.framework.schema.spellsource.tables.UserEntityAddons;
import com.hiddenswitch.framework.schema.spellsource.tables.interfaces.IUserEntityAddons;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserEntityAddonsRecord extends UpdatableRecordImpl<UserEntityAddonsRecord> implements VertxPojo, Record3<String, String, Boolean>, IUserEntityAddons {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>spellsource.user_entity_addons.id</code>.
     */
    @Override
    public UserEntityAddonsRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>spellsource.user_entity_addons.id</code>.
     */
    @Override
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>spellsource.user_entity_addons.privacy_token</code>.
     */
    @Override
    public UserEntityAddonsRecord setPrivacyToken(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>spellsource.user_entity_addons.privacy_token</code>.
     */
    @Override
    public String getPrivacyToken() {
        return (String) get(1);
    }

    /**
     * Setter for <code>spellsource.user_entity_addons.migrated</code>.
     */
    @Override
    public UserEntityAddonsRecord setMigrated(Boolean value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>spellsource.user_entity_addons.migrated</code>.
     */
    @Override
    public Boolean getMigrated() {
        return (Boolean) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, Boolean> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, Boolean> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return UserEntityAddons.USER_ENTITY_ADDONS.ID;
    }

    @Override
    public Field<String> field2() {
        return UserEntityAddons.USER_ENTITY_ADDONS.PRIVACY_TOKEN;
    }

    @Override
    public Field<Boolean> field3() {
        return UserEntityAddons.USER_ENTITY_ADDONS.MIGRATED;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getPrivacyToken();
    }

    @Override
    public Boolean component3() {
        return getMigrated();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getPrivacyToken();
    }

    @Override
    public Boolean value3() {
        return getMigrated();
    }

    @Override
    public UserEntityAddonsRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public UserEntityAddonsRecord value2(String value) {
        setPrivacyToken(value);
        return this;
    }

    @Override
    public UserEntityAddonsRecord value3(Boolean value) {
        setMigrated(value);
        return this;
    }

    @Override
    public UserEntityAddonsRecord values(String value1, String value2, Boolean value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUserEntityAddons from) {
        setId(from.getId());
        setPrivacyToken(from.getPrivacyToken());
        setMigrated(from.getMigrated());
    }

    @Override
    public <E extends IUserEntityAddons> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserEntityAddonsRecord
     */
    public UserEntityAddonsRecord() {
        super(UserEntityAddons.USER_ENTITY_ADDONS);
    }

    /**
     * Create a detached, initialised UserEntityAddonsRecord
     */
    public UserEntityAddonsRecord(String id, String privacyToken, Boolean migrated) {
        super(UserEntityAddons.USER_ENTITY_ADDONS);

        setId(id);
        setPrivacyToken(privacyToken);
        setMigrated(migrated);
    }

    /**
     * Create a detached, initialised UserEntityAddonsRecord
     */
    public UserEntityAddonsRecord(com.hiddenswitch.framework.schema.spellsource.tables.pojos.UserEntityAddons value) {
        super(UserEntityAddons.USER_ENTITY_ADDONS);

        if (value != null) {
            setId(value.getId());
            setPrivacyToken(value.getPrivacyToken());
            setMigrated(value.getMigrated());
        }
    }

        public UserEntityAddonsRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}

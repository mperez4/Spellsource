/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.RequiredActionConfigRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RequiredActionConfig extends TableImpl<RequiredActionConfigRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.required_action_config</code>
     */
    public static final RequiredActionConfig REQUIRED_ACTION_CONFIG = new RequiredActionConfig();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RequiredActionConfigRecord> getRecordType() {
        return RequiredActionConfigRecord.class;
    }

    /**
     * The column
     * <code>keycloak.required_action_config.required_action_id</code>.
     */
    public final TableField<RequiredActionConfigRecord, String> REQUIRED_ACTION_ID = createField(DSL.name("required_action_id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>keycloak.required_action_config.value</code>.
     */
    public final TableField<RequiredActionConfigRecord, String> VALUE = createField(DSL.name("value"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>keycloak.required_action_config.name</code>.
     */
    public final TableField<RequiredActionConfigRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    private RequiredActionConfig(Name alias, Table<RequiredActionConfigRecord> aliased) {
        this(alias, aliased, null);
    }

    private RequiredActionConfig(Name alias, Table<RequiredActionConfigRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.required_action_config</code> table
     * reference
     */
    public RequiredActionConfig(String alias) {
        this(DSL.name(alias), REQUIRED_ACTION_CONFIG);
    }

    /**
     * Create an aliased <code>keycloak.required_action_config</code> table
     * reference
     */
    public RequiredActionConfig(Name alias) {
        this(alias, REQUIRED_ACTION_CONFIG);
    }

    /**
     * Create a <code>keycloak.required_action_config</code> table reference
     */
    public RequiredActionConfig() {
        this(DSL.name("required_action_config"), null);
    }

    public <O extends Record> RequiredActionConfig(Table<O> child, ForeignKey<O, RequiredActionConfigRecord> key) {
        super(child, key, REQUIRED_ACTION_CONFIG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public UniqueKey<RequiredActionConfigRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_REQ_ACT_CFG_PK;
    }

    @Override
    public RequiredActionConfig as(String alias) {
        return new RequiredActionConfig(DSL.name(alias), this);
    }

    @Override
    public RequiredActionConfig as(Name alias) {
        return new RequiredActionConfig(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RequiredActionConfig rename(String name) {
        return new RequiredActionConfig(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RequiredActionConfig rename(Name name) {
        return new RequiredActionConfig(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}

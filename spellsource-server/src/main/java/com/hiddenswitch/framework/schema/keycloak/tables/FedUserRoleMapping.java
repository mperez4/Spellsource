/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.FedUserRoleMappingRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class FedUserRoleMapping extends TableImpl<FedUserRoleMappingRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.fed_user_role_mapping</code>
     */
    public static final FedUserRoleMapping FED_USER_ROLE_MAPPING = new FedUserRoleMapping();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FedUserRoleMappingRecord> getRecordType() {
        return FedUserRoleMappingRecord.class;
    }

    /**
     * The column <code>keycloak.fed_user_role_mapping.role_id</code>.
     */
    public final TableField<FedUserRoleMappingRecord, String> ROLE_ID = createField(DSL.name("role_id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>keycloak.fed_user_role_mapping.user_id</code>.
     */
    public final TableField<FedUserRoleMappingRecord, String> USER_ID = createField(DSL.name("user_id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>keycloak.fed_user_role_mapping.realm_id</code>.
     */
    public final TableField<FedUserRoleMappingRecord, String> REALM_ID = createField(DSL.name("realm_id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column
     * <code>keycloak.fed_user_role_mapping.storage_provider_id</code>.
     */
    public final TableField<FedUserRoleMappingRecord, String> STORAGE_PROVIDER_ID = createField(DSL.name("storage_provider_id"), SQLDataType.VARCHAR(36), this, "");

    private FedUserRoleMapping(Name alias, Table<FedUserRoleMappingRecord> aliased) {
        this(alias, aliased, null);
    }

    private FedUserRoleMapping(Name alias, Table<FedUserRoleMappingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.fed_user_role_mapping</code> table
     * reference
     */
    public FedUserRoleMapping(String alias) {
        this(DSL.name(alias), FED_USER_ROLE_MAPPING);
    }

    /**
     * Create an aliased <code>keycloak.fed_user_role_mapping</code> table
     * reference
     */
    public FedUserRoleMapping(Name alias) {
        this(alias, FED_USER_ROLE_MAPPING);
    }

    /**
     * Create a <code>keycloak.fed_user_role_mapping</code> table reference
     */
    public FedUserRoleMapping() {
        this(DSL.name("fed_user_role_mapping"), null);
    }

    public <O extends Record> FedUserRoleMapping(Table<O> child, ForeignKey<O, FedUserRoleMappingRecord> key) {
        super(child, key, FED_USER_ROLE_MAPPING);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public UniqueKey<FedUserRoleMappingRecord> getPrimaryKey() {
        return Keys.CONSTR_FED_USER_ROLE;
    }

    @Override
    public FedUserRoleMapping as(String alias) {
        return new FedUserRoleMapping(DSL.name(alias), this);
    }

    @Override
    public FedUserRoleMapping as(Name alias) {
        return new FedUserRoleMapping(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FedUserRoleMapping rename(String name) {
        return new FedUserRoleMapping(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FedUserRoleMapping rename(Name name) {
        return new FedUserRoleMapping(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}

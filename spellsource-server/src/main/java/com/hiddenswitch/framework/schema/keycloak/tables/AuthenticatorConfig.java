/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Indexes;
import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.AuthenticatorConfigRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
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
public class AuthenticatorConfig extends TableImpl<AuthenticatorConfigRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.authenticator_config</code>
     */
    public static final AuthenticatorConfig AUTHENTICATOR_CONFIG = new AuthenticatorConfig();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthenticatorConfigRecord> getRecordType() {
        return AuthenticatorConfigRecord.class;
    }

    /**
     * The column <code>keycloak.authenticator_config.id</code>.
     */
    public final TableField<AuthenticatorConfigRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>keycloak.authenticator_config.alias</code>.
     */
    public final TableField<AuthenticatorConfigRecord, String> ALIAS = createField(DSL.name("alias"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.authenticator_config.realm_id</code>.
     */
    public final TableField<AuthenticatorConfigRecord, String> REALM_ID = createField(DSL.name("realm_id"), SQLDataType.VARCHAR(36), this, "");

    private AuthenticatorConfig(Name alias, Table<AuthenticatorConfigRecord> aliased) {
        this(alias, aliased, null);
    }

    private AuthenticatorConfig(Name alias, Table<AuthenticatorConfigRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.authenticator_config</code> table
     * reference
     */
    public AuthenticatorConfig(String alias) {
        this(DSL.name(alias), AUTHENTICATOR_CONFIG);
    }

    /**
     * Create an aliased <code>keycloak.authenticator_config</code> table
     * reference
     */
    public AuthenticatorConfig(Name alias) {
        this(alias, AUTHENTICATOR_CONFIG);
    }

    /**
     * Create a <code>keycloak.authenticator_config</code> table reference
     */
    public AuthenticatorConfig() {
        this(DSL.name("authenticator_config"), null);
    }

    public <O extends Record> AuthenticatorConfig(Table<O> child, ForeignKey<O, AuthenticatorConfigRecord> key) {
        super(child, key, AUTHENTICATOR_CONFIG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_AUTH_CONFIG_REALM);
    }

    @Override
    public UniqueKey<AuthenticatorConfigRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_AUTH_PK;
    }

    @Override
    public List<ForeignKey<AuthenticatorConfigRecord, ?>> getReferences() {
        return Arrays.asList(Keys.AUTHENTICATOR_CONFIG__FK_AUTH_REALM);
    }

    private transient Realm _realm;

    /**
     * Get the implicit join path to the <code>keycloak.realm</code> table.
     */
    public Realm realm() {
        if (_realm == null)
            _realm = new Realm(this, Keys.AUTHENTICATOR_CONFIG__FK_AUTH_REALM);

        return _realm;
    }

    @Override
    public AuthenticatorConfig as(String alias) {
        return new AuthenticatorConfig(DSL.name(alias), this);
    }

    @Override
    public AuthenticatorConfig as(Name alias) {
        return new AuthenticatorConfig(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthenticatorConfig rename(String name) {
        return new AuthenticatorConfig(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthenticatorConfig rename(Name name) {
        return new AuthenticatorConfig(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}

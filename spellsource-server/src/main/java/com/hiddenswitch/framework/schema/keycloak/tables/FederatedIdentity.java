/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Indexes;
import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.FederatedIdentityRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
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
public class FederatedIdentity extends TableImpl<FederatedIdentityRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.federated_identity</code>
     */
    public static final FederatedIdentity FEDERATED_IDENTITY = new FederatedIdentity();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FederatedIdentityRecord> getRecordType() {
        return FederatedIdentityRecord.class;
    }

    /**
     * The column <code>keycloak.federated_identity.identity_provider</code>.
     */
    public final TableField<FederatedIdentityRecord, String> IDENTITY_PROVIDER = createField(DSL.name("identity_provider"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>keycloak.federated_identity.realm_id</code>.
     */
    public final TableField<FederatedIdentityRecord, String> REALM_ID = createField(DSL.name("realm_id"), SQLDataType.VARCHAR(36), this, "");

    /**
     * The column <code>keycloak.federated_identity.federated_user_id</code>.
     */
    public final TableField<FederatedIdentityRecord, String> FEDERATED_USER_ID = createField(DSL.name("federated_user_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.federated_identity.federated_username</code>.
     */
    public final TableField<FederatedIdentityRecord, String> FEDERATED_USERNAME = createField(DSL.name("federated_username"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.federated_identity.token</code>.
     */
    public final TableField<FederatedIdentityRecord, String> TOKEN = createField(DSL.name("token"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>keycloak.federated_identity.user_id</code>.
     */
    public final TableField<FederatedIdentityRecord, String> USER_ID = createField(DSL.name("user_id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    private FederatedIdentity(Name alias, Table<FederatedIdentityRecord> aliased) {
        this(alias, aliased, null);
    }

    private FederatedIdentity(Name alias, Table<FederatedIdentityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.federated_identity</code> table
     * reference
     */
    public FederatedIdentity(String alias) {
        this(DSL.name(alias), FEDERATED_IDENTITY);
    }

    /**
     * Create an aliased <code>keycloak.federated_identity</code> table
     * reference
     */
    public FederatedIdentity(Name alias) {
        this(alias, FEDERATED_IDENTITY);
    }

    /**
     * Create a <code>keycloak.federated_identity</code> table reference
     */
    public FederatedIdentity() {
        this(DSL.name("federated_identity"), null);
    }

    public <O extends Record> FederatedIdentity(Table<O> child, ForeignKey<O, FederatedIdentityRecord> key) {
        super(child, key, FEDERATED_IDENTITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_FEDIDENTITY_FEDUSER, Indexes.IDX_FEDIDENTITY_USER);
    }

    @Override
    public UniqueKey<FederatedIdentityRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_40;
    }

    @Override
    public List<ForeignKey<FederatedIdentityRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FEDERATED_IDENTITY__FK404288B92EF007A6);
    }

    private transient UserEntity _userEntity;

    /**
     * Get the implicit join path to the <code>keycloak.user_entity</code>
     * table.
     */
    public UserEntity userEntity() {
        if (_userEntity == null)
            _userEntity = new UserEntity(this, Keys.FEDERATED_IDENTITY__FK404288B92EF007A6);

        return _userEntity;
    }

    @Override
    public FederatedIdentity as(String alias) {
        return new FederatedIdentity(DSL.name(alias), this);
    }

    @Override
    public FederatedIdentity as(Name alias) {
        return new FederatedIdentity(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FederatedIdentity rename(String name) {
        return new FederatedIdentity(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FederatedIdentity rename(Name name) {
        return new FederatedIdentity(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}

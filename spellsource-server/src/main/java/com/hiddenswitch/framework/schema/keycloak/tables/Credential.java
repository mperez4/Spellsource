/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Indexes;
import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.CredentialRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row12;
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
public class Credential extends TableImpl<CredentialRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.credential</code>
     */
    public static final Credential CREDENTIAL = new Credential();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CredentialRecord> getRecordType() {
        return CredentialRecord.class;
    }

    /**
     * The column <code>keycloak.credential.id</code>.
     */
    public final TableField<CredentialRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>keycloak.credential.device</code>.
     */
    public final TableField<CredentialRecord, String> DEVICE = createField(DSL.name("device"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.credential.hash_iterations</code>.
     */
    public final TableField<CredentialRecord, Integer> HASH_ITERATIONS = createField(DSL.name("hash_iterations"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>keycloak.credential.salt</code>.
     */
    public final TableField<CredentialRecord, byte[]> SALT = createField(DSL.name("salt"), SQLDataType.BLOB, this, "");

    /**
     * The column <code>keycloak.credential.type</code>.
     */
    public final TableField<CredentialRecord, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.credential.value</code>.
     */
    public final TableField<CredentialRecord, String> VALUE = createField(DSL.name("value"), SQLDataType.VARCHAR(4000), this, "");

    /**
     * The column <code>keycloak.credential.user_id</code>.
     */
    public final TableField<CredentialRecord, String> USER_ID = createField(DSL.name("user_id"), SQLDataType.VARCHAR(36), this, "");

    /**
     * The column <code>keycloak.credential.created_date</code>.
     */
    public final TableField<CredentialRecord, Long> CREATED_DATE = createField(DSL.name("created_date"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>keycloak.credential.counter</code>.
     */
    public final TableField<CredentialRecord, Integer> COUNTER = createField(DSL.name("counter"), SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>keycloak.credential.digits</code>.
     */
    public final TableField<CredentialRecord, Integer> DIGITS = createField(DSL.name("digits"), SQLDataType.INTEGER.defaultValue(DSL.field("6", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>keycloak.credential.period</code>.
     */
    public final TableField<CredentialRecord, Integer> PERIOD = createField(DSL.name("period"), SQLDataType.INTEGER.defaultValue(DSL.field("30", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>keycloak.credential.algorithm</code>.
     */
    public final TableField<CredentialRecord, String> ALGORITHM = createField(DSL.name("algorithm"), SQLDataType.VARCHAR(36).defaultValue(DSL.field("NULL::character varying", SQLDataType.VARCHAR)), this, "");

    private Credential(Name alias, Table<CredentialRecord> aliased) {
        this(alias, aliased, null);
    }

    private Credential(Name alias, Table<CredentialRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.credential</code> table reference
     */
    public Credential(String alias) {
        this(DSL.name(alias), CREDENTIAL);
    }

    /**
     * Create an aliased <code>keycloak.credential</code> table reference
     */
    public Credential(Name alias) {
        this(alias, CREDENTIAL);
    }

    /**
     * Create a <code>keycloak.credential</code> table reference
     */
    public Credential() {
        this(DSL.name("credential"), null);
    }

    public <O extends Record> Credential(Table<O> child, ForeignKey<O, CredentialRecord> key) {
        super(child, key, CREDENTIAL);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_USER_CREDENTIAL);
    }

    @Override
    public UniqueKey<CredentialRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_F;
    }

    @Override
    public List<ForeignKey<CredentialRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CREDENTIAL__FK_PFYR0GLASQYL0DEI3KL69R6V0);
    }

    private transient UserEntity _userEntity;

    /**
     * Get the implicit join path to the <code>keycloak.user_entity</code>
     * table.
     */
    public UserEntity userEntity() {
        if (_userEntity == null)
            _userEntity = new UserEntity(this, Keys.CREDENTIAL__FK_PFYR0GLASQYL0DEI3KL69R6V0);

        return _userEntity;
    }

    @Override
    public Credential as(String alias) {
        return new Credential(DSL.name(alias), this);
    }

    @Override
    public Credential as(Name alias) {
        return new Credential(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Credential rename(String name) {
        return new Credential(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Credential rename(Name name) {
        return new Credential(name, null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<String, String, Integer, byte[], String, String, String, Long, Integer, Integer, Integer, String> fieldsRow() {
        return (Row12) super.fieldsRow();
    }
}

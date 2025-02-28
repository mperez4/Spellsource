/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.KeycloakGroupRecord;

import java.util.Arrays;
import java.util.List;

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
public class KeycloakGroup extends TableImpl<KeycloakGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.keycloak_group</code>
     */
    public static final KeycloakGroup KEYCLOAK_GROUP = new KeycloakGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<KeycloakGroupRecord> getRecordType() {
        return KeycloakGroupRecord.class;
    }

    /**
     * The column <code>keycloak.keycloak_group.id</code>.
     */
    public final TableField<KeycloakGroupRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>keycloak.keycloak_group.name</code>.
     */
    public final TableField<KeycloakGroupRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.keycloak_group.parent_group</code>.
     */
    public final TableField<KeycloakGroupRecord, String> PARENT_GROUP = createField(DSL.name("parent_group"), SQLDataType.VARCHAR(36), this, "");

    /**
     * The column <code>keycloak.keycloak_group.realm_id</code>.
     */
    public final TableField<KeycloakGroupRecord, String> REALM_ID = createField(DSL.name("realm_id"), SQLDataType.VARCHAR(36), this, "");

    private KeycloakGroup(Name alias, Table<KeycloakGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private KeycloakGroup(Name alias, Table<KeycloakGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.keycloak_group</code> table reference
     */
    public KeycloakGroup(String alias) {
        this(DSL.name(alias), KEYCLOAK_GROUP);
    }

    /**
     * Create an aliased <code>keycloak.keycloak_group</code> table reference
     */
    public KeycloakGroup(Name alias) {
        this(alias, KEYCLOAK_GROUP);
    }

    /**
     * Create a <code>keycloak.keycloak_group</code> table reference
     */
    public KeycloakGroup() {
        this(DSL.name("keycloak_group"), null);
    }

    public <O extends Record> KeycloakGroup(Table<O> child, ForeignKey<O, KeycloakGroupRecord> key) {
        super(child, key, KEYCLOAK_GROUP);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public UniqueKey<KeycloakGroupRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_GROUP;
    }

    @Override
    public List<UniqueKey<KeycloakGroupRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.SIBLING_NAMES);
    }

    @Override
    public List<ForeignKey<KeycloakGroupRecord, ?>> getReferences() {
        return Arrays.asList(Keys.KEYCLOAK_GROUP__FK_GROUP_REALM);
    }

    private transient Realm _realm;

    /**
     * Get the implicit join path to the <code>keycloak.realm</code> table.
     */
    public Realm realm() {
        if (_realm == null)
            _realm = new Realm(this, Keys.KEYCLOAK_GROUP__FK_GROUP_REALM);

        return _realm;
    }

    @Override
    public KeycloakGroup as(String alias) {
        return new KeycloakGroup(DSL.name(alias), this);
    }

    @Override
    public KeycloakGroup as(Name alias) {
        return new KeycloakGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public KeycloakGroup rename(String name) {
        return new KeycloakGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public KeycloakGroup rename(Name name) {
        return new KeycloakGroup(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}

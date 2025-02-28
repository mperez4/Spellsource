/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Indexes;
import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.GroupAttributeRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
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
public class GroupAttribute extends TableImpl<GroupAttributeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.group_attribute</code>
     */
    public static final GroupAttribute GROUP_ATTRIBUTE = new GroupAttribute();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GroupAttributeRecord> getRecordType() {
        return GroupAttributeRecord.class;
    }

    /**
     * The column <code>keycloak.group_attribute.id</code>.
     */
    public final TableField<GroupAttributeRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(36).nullable(false).defaultValue(DSL.field("'sybase-needs-something-here'::character varying", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>keycloak.group_attribute.name</code>.
     */
    public final TableField<GroupAttributeRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>keycloak.group_attribute.value</code>.
     */
    public final TableField<GroupAttributeRecord, String> VALUE = createField(DSL.name("value"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.group_attribute.group_id</code>.
     */
    public final TableField<GroupAttributeRecord, String> GROUP_ID = createField(DSL.name("group_id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    private GroupAttribute(Name alias, Table<GroupAttributeRecord> aliased) {
        this(alias, aliased, null);
    }

    private GroupAttribute(Name alias, Table<GroupAttributeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.group_attribute</code> table reference
     */
    public GroupAttribute(String alias) {
        this(DSL.name(alias), GROUP_ATTRIBUTE);
    }

    /**
     * Create an aliased <code>keycloak.group_attribute</code> table reference
     */
    public GroupAttribute(Name alias) {
        this(alias, GROUP_ATTRIBUTE);
    }

    /**
     * Create a <code>keycloak.group_attribute</code> table reference
     */
    public GroupAttribute() {
        this(DSL.name("group_attribute"), null);
    }

    public <O extends Record> GroupAttribute(Table<O> child, ForeignKey<O, GroupAttributeRecord> key) {
        super(child, key, GROUP_ATTRIBUTE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_GROUP_ATTR_GROUP);
    }

    @Override
    public UniqueKey<GroupAttributeRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_GROUP_ATTRIBUTE_PK;
    }

    @Override
    public List<ForeignKey<GroupAttributeRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GROUP_ATTRIBUTE__FK_GROUP_ATTRIBUTE_GROUP);
    }

    private transient KeycloakGroup _keycloakGroup;

    /**
     * Get the implicit join path to the <code>keycloak.keycloak_group</code>
     * table.
     */
    public KeycloakGroup keycloakGroup() {
        if (_keycloakGroup == null)
            _keycloakGroup = new KeycloakGroup(this, Keys.GROUP_ATTRIBUTE__FK_GROUP_ATTRIBUTE_GROUP);

        return _keycloakGroup;
    }

    @Override
    public GroupAttribute as(String alias) {
        return new GroupAttribute(DSL.name(alias), this);
    }

    @Override
    public GroupAttribute as(Name alias) {
        return new GroupAttribute(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GroupAttribute rename(String name) {
        return new GroupAttribute(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GroupAttribute rename(Name name) {
        return new GroupAttribute(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}

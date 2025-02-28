/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.EventEntityRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
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
public class EventEntity extends TableImpl<EventEntityRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.event_entity</code>
     */
    public static final EventEntity EVENT_ENTITY = new EventEntity();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EventEntityRecord> getRecordType() {
        return EventEntityRecord.class;
    }

    /**
     * The column <code>keycloak.event_entity.id</code>.
     */
    public final TableField<EventEntityRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>keycloak.event_entity.client_id</code>.
     */
    public final TableField<EventEntityRecord, String> CLIENT_ID = createField(DSL.name("client_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.event_entity.details_json</code>.
     */
    public final TableField<EventEntityRecord, String> DETAILS_JSON = createField(DSL.name("details_json"), SQLDataType.VARCHAR(2550), this, "");

    /**
     * The column <code>keycloak.event_entity.error</code>.
     */
    public final TableField<EventEntityRecord, String> ERROR = createField(DSL.name("error"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.event_entity.ip_address</code>.
     */
    public final TableField<EventEntityRecord, String> IP_ADDRESS = createField(DSL.name("ip_address"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.event_entity.realm_id</code>.
     */
    public final TableField<EventEntityRecord, String> REALM_ID = createField(DSL.name("realm_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.event_entity.session_id</code>.
     */
    public final TableField<EventEntityRecord, String> SESSION_ID = createField(DSL.name("session_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.event_entity.event_time</code>.
     */
    public final TableField<EventEntityRecord, Long> EVENT_TIME = createField(DSL.name("event_time"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>keycloak.event_entity.type</code>.
     */
    public final TableField<EventEntityRecord, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.event_entity.user_id</code>.
     */
    public final TableField<EventEntityRecord, String> USER_ID = createField(DSL.name("user_id"), SQLDataType.VARCHAR(255), this, "");

    private EventEntity(Name alias, Table<EventEntityRecord> aliased) {
        this(alias, aliased, null);
    }

    private EventEntity(Name alias, Table<EventEntityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.event_entity</code> table reference
     */
    public EventEntity(String alias) {
        this(DSL.name(alias), EVENT_ENTITY);
    }

    /**
     * Create an aliased <code>keycloak.event_entity</code> table reference
     */
    public EventEntity(Name alias) {
        this(alias, EVENT_ENTITY);
    }

    /**
     * Create a <code>keycloak.event_entity</code> table reference
     */
    public EventEntity() {
        this(DSL.name("event_entity"), null);
    }

    public <O extends Record> EventEntity(Table<O> child, ForeignKey<O, EventEntityRecord> key) {
        super(child, key, EVENT_ENTITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public UniqueKey<EventEntityRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_4;
    }

    @Override
    public EventEntity as(String alias) {
        return new EventEntity(DSL.name(alias), this);
    }

    @Override
    public EventEntity as(Name alias) {
        return new EventEntity(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public EventEntity rename(String name) {
        return new EventEntity(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public EventEntity rename(Name name) {
        return new EventEntity(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<String, String, String, String, String, String, String, Long, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}

/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.UsernameLoginFailureRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class UsernameLoginFailure extends TableImpl<UsernameLoginFailureRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.username_login_failure</code>
     */
    public static final UsernameLoginFailure USERNAME_LOGIN_FAILURE = new UsernameLoginFailure();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsernameLoginFailureRecord> getRecordType() {
        return UsernameLoginFailureRecord.class;
    }

    /**
     * The column <code>keycloak.username_login_failure.realm_id</code>.
     */
    public final TableField<UsernameLoginFailureRecord, String> REALM_ID = createField(DSL.name("realm_id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>keycloak.username_login_failure.username</code>.
     */
    public final TableField<UsernameLoginFailureRecord, String> USERNAME = createField(DSL.name("username"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column
     * <code>keycloak.username_login_failure.failed_login_not_before</code>.
     */
    public final TableField<UsernameLoginFailureRecord, Integer> FAILED_LOGIN_NOT_BEFORE = createField(DSL.name("failed_login_not_before"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>keycloak.username_login_failure.last_failure</code>.
     */
    public final TableField<UsernameLoginFailureRecord, Long> LAST_FAILURE = createField(DSL.name("last_failure"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>keycloak.username_login_failure.last_ip_failure</code>.
     */
    public final TableField<UsernameLoginFailureRecord, String> LAST_IP_FAILURE = createField(DSL.name("last_ip_failure"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>keycloak.username_login_failure.num_failures</code>.
     */
    public final TableField<UsernameLoginFailureRecord, Integer> NUM_FAILURES = createField(DSL.name("num_failures"), SQLDataType.INTEGER, this, "");

    private UsernameLoginFailure(Name alias, Table<UsernameLoginFailureRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsernameLoginFailure(Name alias, Table<UsernameLoginFailureRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.username_login_failure</code> table
     * reference
     */
    public UsernameLoginFailure(String alias) {
        this(DSL.name(alias), USERNAME_LOGIN_FAILURE);
    }

    /**
     * Create an aliased <code>keycloak.username_login_failure</code> table
     * reference
     */
    public UsernameLoginFailure(Name alias) {
        this(alias, USERNAME_LOGIN_FAILURE);
    }

    /**
     * Create a <code>keycloak.username_login_failure</code> table reference
     */
    public UsernameLoginFailure() {
        this(DSL.name("username_login_failure"), null);
    }

    public <O extends Record> UsernameLoginFailure(Table<O> child, ForeignKey<O, UsernameLoginFailureRecord> key) {
        super(child, key, USERNAME_LOGIN_FAILURE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public UniqueKey<UsernameLoginFailureRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_17_2;
    }

    @Override
    public UsernameLoginFailure as(String alias) {
        return new UsernameLoginFailure(DSL.name(alias), this);
    }

    @Override
    public UsernameLoginFailure as(Name alias) {
        return new UsernameLoginFailure(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UsernameLoginFailure rename(String name) {
        return new UsernameLoginFailure(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsernameLoginFailure rename(Name name) {
        return new UsernameLoginFailure(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, Integer, Long, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}

/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables;


import com.hiddenswitch.framework.schema.keycloak.Keycloak;
import com.hiddenswitch.framework.schema.keycloak.Keys;
import com.hiddenswitch.framework.schema.keycloak.tables.records.FedUserRequiredActionRecord;

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
public class FedUserRequiredAction extends TableImpl<FedUserRequiredActionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keycloak.fed_user_required_action</code>
     */
    public static final FedUserRequiredAction FED_USER_REQUIRED_ACTION = new FedUserRequiredAction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FedUserRequiredActionRecord> getRecordType() {
        return FedUserRequiredActionRecord.class;
    }

    /**
     * The column
     * <code>keycloak.fed_user_required_action.required_action</code>.
     */
    public final TableField<FedUserRequiredActionRecord, String> REQUIRED_ACTION = createField(DSL.name("required_action"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.field("' '::character varying", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>keycloak.fed_user_required_action.user_id</code>.
     */
    public final TableField<FedUserRequiredActionRecord, String> USER_ID = createField(DSL.name("user_id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>keycloak.fed_user_required_action.realm_id</code>.
     */
    public final TableField<FedUserRequiredActionRecord, String> REALM_ID = createField(DSL.name("realm_id"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column
     * <code>keycloak.fed_user_required_action.storage_provider_id</code>.
     */
    public final TableField<FedUserRequiredActionRecord, String> STORAGE_PROVIDER_ID = createField(DSL.name("storage_provider_id"), SQLDataType.VARCHAR(36), this, "");

    private FedUserRequiredAction(Name alias, Table<FedUserRequiredActionRecord> aliased) {
        this(alias, aliased, null);
    }

    private FedUserRequiredAction(Name alias, Table<FedUserRequiredActionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keycloak.fed_user_required_action</code> table
     * reference
     */
    public FedUserRequiredAction(String alias) {
        this(DSL.name(alias), FED_USER_REQUIRED_ACTION);
    }

    /**
     * Create an aliased <code>keycloak.fed_user_required_action</code> table
     * reference
     */
    public FedUserRequiredAction(Name alias) {
        this(alias, FED_USER_REQUIRED_ACTION);
    }

    /**
     * Create a <code>keycloak.fed_user_required_action</code> table reference
     */
    public FedUserRequiredAction() {
        this(DSL.name("fed_user_required_action"), null);
    }

    public <O extends Record> FedUserRequiredAction(Table<O> child, ForeignKey<O, FedUserRequiredActionRecord> key) {
        super(child, key, FED_USER_REQUIRED_ACTION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Keycloak.KEYCLOAK;
    }

    @Override
    public UniqueKey<FedUserRequiredActionRecord> getPrimaryKey() {
        return Keys.CONSTR_FED_REQUIRED_ACTION;
    }

    @Override
    public FedUserRequiredAction as(String alias) {
        return new FedUserRequiredAction(DSL.name(alias), this);
    }

    @Override
    public FedUserRequiredAction as(Name alias) {
        return new FedUserRequiredAction(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FedUserRequiredAction rename(String name) {
        return new FedUserRequiredAction(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FedUserRequiredAction rename(Name name) {
        return new FedUserRequiredAction(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}

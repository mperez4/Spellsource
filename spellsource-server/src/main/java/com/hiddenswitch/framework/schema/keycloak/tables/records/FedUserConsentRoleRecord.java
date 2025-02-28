/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.records;


import com.hiddenswitch.framework.schema.keycloak.tables.FedUserConsentRole;
import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IFedUserConsentRole;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FedUserConsentRoleRecord extends UpdatableRecordImpl<FedUserConsentRoleRecord> implements VertxPojo, Record2<String, String>, IFedUserConsentRole {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>keycloak.fed_user_consent_role.user_consent_id</code>.
     */
    @Override
    public FedUserConsentRoleRecord setUserConsentId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.fed_user_consent_role.user_consent_id</code>.
     */
    @Override
    public String getUserConsentId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>keycloak.fed_user_consent_role.role_id</code>.
     */
    @Override
    public FedUserConsentRoleRecord setRoleId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.fed_user_consent_role.role_id</code>.
     */
    @Override
    public String getRoleId() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return FedUserConsentRole.FED_USER_CONSENT_ROLE.USER_CONSENT_ID;
    }

    @Override
    public Field<String> field2() {
        return FedUserConsentRole.FED_USER_CONSENT_ROLE.ROLE_ID;
    }

    @Override
    public String component1() {
        return getUserConsentId();
    }

    @Override
    public String component2() {
        return getRoleId();
    }

    @Override
    public String value1() {
        return getUserConsentId();
    }

    @Override
    public String value2() {
        return getRoleId();
    }

    @Override
    public FedUserConsentRoleRecord value1(String value) {
        setUserConsentId(value);
        return this;
    }

    @Override
    public FedUserConsentRoleRecord value2(String value) {
        setRoleId(value);
        return this;
    }

    @Override
    public FedUserConsentRoleRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IFedUserConsentRole from) {
        setUserConsentId(from.getUserConsentId());
        setRoleId(from.getRoleId());
    }

    @Override
    public <E extends IFedUserConsentRole> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FedUserConsentRoleRecord
     */
    public FedUserConsentRoleRecord() {
        super(FedUserConsentRole.FED_USER_CONSENT_ROLE);
    }

    /**
     * Create a detached, initialised FedUserConsentRoleRecord
     */
    public FedUserConsentRoleRecord(String userConsentId, String roleId) {
        super(FedUserConsentRole.FED_USER_CONSENT_ROLE);

        setUserConsentId(userConsentId);
        setRoleId(roleId);
    }

    /**
     * Create a detached, initialised FedUserConsentRoleRecord
     */
    public FedUserConsentRoleRecord(com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserConsentRole value) {
        super(FedUserConsentRole.FED_USER_CONSENT_ROLE);

        if (value != null) {
            setUserConsentId(value.getUserConsentId());
            setRoleId(value.getRoleId());
        }
    }

        public FedUserConsentRoleRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}

/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.interfaces;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IUserConsentRole extends VertxPojo, Serializable {

    /**
     * Setter for <code>keycloak.user_consent_role.user_consent_id</code>.
     */
    public IUserConsentRole setUserConsentId(String value);

    /**
     * Getter for <code>keycloak.user_consent_role.user_consent_id</code>.
     */
    public String getUserConsentId();

    /**
     * Setter for <code>keycloak.user_consent_role.role_id</code>.
     */
    public IUserConsentRole setRoleId(String value);

    /**
     * Getter for <code>keycloak.user_consent_role.role_id</code>.
     */
    public String getRoleId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IUserConsentRole
     */
    public void from(IUserConsentRole from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IUserConsentRole
     */
    public <E extends IUserConsentRole> E into(E into);

        @Override
        public default IUserConsentRole fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setUserConsentId,json::getString,"user_consent_id","java.lang.String");
                setOrThrow(this::setRoleId,json::getString,"role_id","java.lang.String");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("user_consent_id",getUserConsentId());
                json.put("role_id",getRoleId());
                return json;
        }

}

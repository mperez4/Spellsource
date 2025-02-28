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
public interface IRealmAttribute extends VertxPojo, Serializable {

    /**
     * Setter for <code>keycloak.realm_attribute.name</code>.
     */
    public IRealmAttribute setName(String value);

    /**
     * Getter for <code>keycloak.realm_attribute.name</code>.
     */
    public String getName();

    /**
     * Setter for <code>keycloak.realm_attribute.value</code>.
     */
    public IRealmAttribute setValue(String value);

    /**
     * Getter for <code>keycloak.realm_attribute.value</code>.
     */
    public String getValue();

    /**
     * Setter for <code>keycloak.realm_attribute.realm_id</code>.
     */
    public IRealmAttribute setRealmId(String value);

    /**
     * Getter for <code>keycloak.realm_attribute.realm_id</code>.
     */
    public String getRealmId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IRealmAttribute
     */
    public void from(IRealmAttribute from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IRealmAttribute
     */
    public <E extends IRealmAttribute> E into(E into);

        @Override
        public default IRealmAttribute fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setName,json::getString,"name","java.lang.String");
                setOrThrow(this::setValue,json::getString,"value","java.lang.String");
                setOrThrow(this::setRealmId,json::getString,"realm_id","java.lang.String");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("name",getName());
                json.put("value",getValue());
                json.put("realm_id",getRealmId());
                return json;
        }

}

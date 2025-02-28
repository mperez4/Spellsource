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
public interface IOfflineUserSession extends VertxPojo, Serializable {

    /**
     * Setter for <code>keycloak.offline_user_session.user_session_id</code>.
     */
    public IOfflineUserSession setUserSessionId(String value);

    /**
     * Getter for <code>keycloak.offline_user_session.user_session_id</code>.
     */
    public String getUserSessionId();

    /**
     * Setter for <code>keycloak.offline_user_session.user_id</code>.
     */
    public IOfflineUserSession setUserId(String value);

    /**
     * Getter for <code>keycloak.offline_user_session.user_id</code>.
     */
    public String getUserId();

    /**
     * Setter for <code>keycloak.offline_user_session.realm_id</code>.
     */
    public IOfflineUserSession setRealmId(String value);

    /**
     * Getter for <code>keycloak.offline_user_session.realm_id</code>.
     */
    public String getRealmId();

    /**
     * Setter for
     * <code>keycloak.offline_user_session.last_session_refresh</code>.
     */
    public IOfflineUserSession setLastSessionRefresh(Integer value);

    /**
     * Getter for
     * <code>keycloak.offline_user_session.last_session_refresh</code>.
     */
    public Integer getLastSessionRefresh();

    /**
     * Setter for <code>keycloak.offline_user_session.offline_flag</code>.
     */
    public IOfflineUserSession setOfflineFlag(String value);

    /**
     * Getter for <code>keycloak.offline_user_session.offline_flag</code>.
     */
    public String getOfflineFlag();

    /**
     * Setter for <code>keycloak.offline_user_session.data</code>.
     */
    public IOfflineUserSession setData(String value);

    /**
     * Getter for <code>keycloak.offline_user_session.data</code>.
     */
    public String getData();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IOfflineUserSession
     */
    public void from(IOfflineUserSession from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IOfflineUserSession
     */
    public <E extends IOfflineUserSession> E into(E into);

        @Override
        public default IOfflineUserSession fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setUserSessionId,json::getString,"user_session_id","java.lang.String");
                setOrThrow(this::setUserId,json::getString,"user_id","java.lang.String");
                setOrThrow(this::setRealmId,json::getString,"realm_id","java.lang.String");
                setOrThrow(this::setLastSessionRefresh,json::getInteger,"last_session_refresh","java.lang.Integer");
                setOrThrow(this::setOfflineFlag,json::getString,"offline_flag","java.lang.String");
                setOrThrow(this::setData,json::getString,"data","java.lang.String");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("user_session_id",getUserSessionId());
                json.put("user_id",getUserId());
                json.put("realm_id",getRealmId());
                json.put("last_session_refresh",getLastSessionRefresh());
                json.put("offline_flag",getOfflineFlag());
                json.put("data",getData());
                return json;
        }

}

/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.pojos;


import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IUserSession;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserSession implements VertxPojo, IUserSession {

    private static final long serialVersionUID = 1L;

    private String  id;
    private String  authMethod;
    private String  ipAddress;
    private Integer lastSessionRefresh;
    private String  loginUsername;
    private String  realmId;
    private Boolean rememberMe;
    private Integer started;
    private String  userId;
    private Integer userSessionState;
    private String  brokerSessionId;
    private String  brokerUserId;

    public UserSession() {}

    public UserSession(IUserSession value) {
        this.id = value.getId();
        this.authMethod = value.getAuthMethod();
        this.ipAddress = value.getIpAddress();
        this.lastSessionRefresh = value.getLastSessionRefresh();
        this.loginUsername = value.getLoginUsername();
        this.realmId = value.getRealmId();
        this.rememberMe = value.getRememberMe();
        this.started = value.getStarted();
        this.userId = value.getUserId();
        this.userSessionState = value.getUserSessionState();
        this.brokerSessionId = value.getBrokerSessionId();
        this.brokerUserId = value.getBrokerUserId();
    }

    public UserSession(
        String  id,
        String  authMethod,
        String  ipAddress,
        Integer lastSessionRefresh,
        String  loginUsername,
        String  realmId,
        Boolean rememberMe,
        Integer started,
        String  userId,
        Integer userSessionState,
        String  brokerSessionId,
        String  brokerUserId
    ) {
        this.id = id;
        this.authMethod = authMethod;
        this.ipAddress = ipAddress;
        this.lastSessionRefresh = lastSessionRefresh;
        this.loginUsername = loginUsername;
        this.realmId = realmId;
        this.rememberMe = rememberMe;
        this.started = started;
        this.userId = userId;
        this.userSessionState = userSessionState;
        this.brokerSessionId = brokerSessionId;
        this.brokerUserId = brokerUserId;
    }

        public UserSession(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>keycloak.user_session.id</code>.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Setter for <code>keycloak.user_session.id</code>.
     */
    @Override
    public UserSession setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.auth_method</code>.
     */
    @Override
    public String getAuthMethod() {
        return this.authMethod;
    }

    /**
     * Setter for <code>keycloak.user_session.auth_method</code>.
     */
    @Override
    public UserSession setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.ip_address</code>.
     */
    @Override
    public String getIpAddress() {
        return this.ipAddress;
    }

    /**
     * Setter for <code>keycloak.user_session.ip_address</code>.
     */
    @Override
    public UserSession setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.last_session_refresh</code>.
     */
    @Override
    public Integer getLastSessionRefresh() {
        return this.lastSessionRefresh;
    }

    /**
     * Setter for <code>keycloak.user_session.last_session_refresh</code>.
     */
    @Override
    public UserSession setLastSessionRefresh(Integer lastSessionRefresh) {
        this.lastSessionRefresh = lastSessionRefresh;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.login_username</code>.
     */
    @Override
    public String getLoginUsername() {
        return this.loginUsername;
    }

    /**
     * Setter for <code>keycloak.user_session.login_username</code>.
     */
    @Override
    public UserSession setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.realm_id</code>.
     */
    @Override
    public String getRealmId() {
        return this.realmId;
    }

    /**
     * Setter for <code>keycloak.user_session.realm_id</code>.
     */
    @Override
    public UserSession setRealmId(String realmId) {
        this.realmId = realmId;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.remember_me</code>.
     */
    @Override
    public Boolean getRememberMe() {
        return this.rememberMe;
    }

    /**
     * Setter for <code>keycloak.user_session.remember_me</code>.
     */
    @Override
    public UserSession setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.started</code>.
     */
    @Override
    public Integer getStarted() {
        return this.started;
    }

    /**
     * Setter for <code>keycloak.user_session.started</code>.
     */
    @Override
    public UserSession setStarted(Integer started) {
        this.started = started;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.user_id</code>.
     */
    @Override
    public String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>keycloak.user_session.user_id</code>.
     */
    @Override
    public UserSession setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.user_session_state</code>.
     */
    @Override
    public Integer getUserSessionState() {
        return this.userSessionState;
    }

    /**
     * Setter for <code>keycloak.user_session.user_session_state</code>.
     */
    @Override
    public UserSession setUserSessionState(Integer userSessionState) {
        this.userSessionState = userSessionState;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.broker_session_id</code>.
     */
    @Override
    public String getBrokerSessionId() {
        return this.brokerSessionId;
    }

    /**
     * Setter for <code>keycloak.user_session.broker_session_id</code>.
     */
    @Override
    public UserSession setBrokerSessionId(String brokerSessionId) {
        this.brokerSessionId = brokerSessionId;
        return this;
    }

    /**
     * Getter for <code>keycloak.user_session.broker_user_id</code>.
     */
    @Override
    public String getBrokerUserId() {
        return this.brokerUserId;
    }

    /**
     * Setter for <code>keycloak.user_session.broker_user_id</code>.
     */
    @Override
    public UserSession setBrokerUserId(String brokerUserId) {
        this.brokerUserId = brokerUserId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserSession (");

        sb.append(id);
        sb.append(", ").append(authMethod);
        sb.append(", ").append(ipAddress);
        sb.append(", ").append(lastSessionRefresh);
        sb.append(", ").append(loginUsername);
        sb.append(", ").append(realmId);
        sb.append(", ").append(rememberMe);
        sb.append(", ").append(started);
        sb.append(", ").append(userId);
        sb.append(", ").append(userSessionState);
        sb.append(", ").append(brokerSessionId);
        sb.append(", ").append(brokerUserId);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUserSession from) {
        setId(from.getId());
        setAuthMethod(from.getAuthMethod());
        setIpAddress(from.getIpAddress());
        setLastSessionRefresh(from.getLastSessionRefresh());
        setLoginUsername(from.getLoginUsername());
        setRealmId(from.getRealmId());
        setRememberMe(from.getRememberMe());
        setStarted(from.getStarted());
        setUserId(from.getUserId());
        setUserSessionState(from.getUserSessionState());
        setBrokerSessionId(from.getBrokerSessionId());
        setBrokerUserId(from.getBrokerUserId());
    }

    @Override
    public <E extends IUserSession> E into(E into) {
        into.from(this);
        return into;
    }
}

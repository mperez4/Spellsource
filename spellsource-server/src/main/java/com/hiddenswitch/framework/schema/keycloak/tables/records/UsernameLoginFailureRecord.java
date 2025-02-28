/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.records;


import com.hiddenswitch.framework.schema.keycloak.tables.UsernameLoginFailure;
import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IUsernameLoginFailure;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsernameLoginFailureRecord extends UpdatableRecordImpl<UsernameLoginFailureRecord> implements VertxPojo, Record6<String, String, Integer, Long, String, Integer>, IUsernameLoginFailure {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>keycloak.username_login_failure.realm_id</code>.
     */
    @Override
    public UsernameLoginFailureRecord setRealmId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.username_login_failure.realm_id</code>.
     */
    @Override
    public String getRealmId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>keycloak.username_login_failure.username</code>.
     */
    @Override
    public UsernameLoginFailureRecord setUsername(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.username_login_failure.username</code>.
     */
    @Override
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for
     * <code>keycloak.username_login_failure.failed_login_not_before</code>.
     */
    @Override
    public UsernameLoginFailureRecord setFailedLoginNotBefore(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for
     * <code>keycloak.username_login_failure.failed_login_not_before</code>.
     */
    @Override
    public Integer getFailedLoginNotBefore() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>keycloak.username_login_failure.last_failure</code>.
     */
    @Override
    public UsernameLoginFailureRecord setLastFailure(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.username_login_failure.last_failure</code>.
     */
    @Override
    public Long getLastFailure() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>keycloak.username_login_failure.last_ip_failure</code>.
     */
    @Override
    public UsernameLoginFailureRecord setLastIpFailure(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.username_login_failure.last_ip_failure</code>.
     */
    @Override
    public String getLastIpFailure() {
        return (String) get(4);
    }

    /**
     * Setter for <code>keycloak.username_login_failure.num_failures</code>.
     */
    @Override
    public UsernameLoginFailureRecord setNumFailures(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.username_login_failure.num_failures</code>.
     */
    @Override
    public Integer getNumFailures() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, Integer, Long, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, String, Integer, Long, String, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return UsernameLoginFailure.USERNAME_LOGIN_FAILURE.REALM_ID;
    }

    @Override
    public Field<String> field2() {
        return UsernameLoginFailure.USERNAME_LOGIN_FAILURE.USERNAME;
    }

    @Override
    public Field<Integer> field3() {
        return UsernameLoginFailure.USERNAME_LOGIN_FAILURE.FAILED_LOGIN_NOT_BEFORE;
    }

    @Override
    public Field<Long> field4() {
        return UsernameLoginFailure.USERNAME_LOGIN_FAILURE.LAST_FAILURE;
    }

    @Override
    public Field<String> field5() {
        return UsernameLoginFailure.USERNAME_LOGIN_FAILURE.LAST_IP_FAILURE;
    }

    @Override
    public Field<Integer> field6() {
        return UsernameLoginFailure.USERNAME_LOGIN_FAILURE.NUM_FAILURES;
    }

    @Override
    public String component1() {
        return getRealmId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public Integer component3() {
        return getFailedLoginNotBefore();
    }

    @Override
    public Long component4() {
        return getLastFailure();
    }

    @Override
    public String component5() {
        return getLastIpFailure();
    }

    @Override
    public Integer component6() {
        return getNumFailures();
    }

    @Override
    public String value1() {
        return getRealmId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public Integer value3() {
        return getFailedLoginNotBefore();
    }

    @Override
    public Long value4() {
        return getLastFailure();
    }

    @Override
    public String value5() {
        return getLastIpFailure();
    }

    @Override
    public Integer value6() {
        return getNumFailures();
    }

    @Override
    public UsernameLoginFailureRecord value1(String value) {
        setRealmId(value);
        return this;
    }

    @Override
    public UsernameLoginFailureRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UsernameLoginFailureRecord value3(Integer value) {
        setFailedLoginNotBefore(value);
        return this;
    }

    @Override
    public UsernameLoginFailureRecord value4(Long value) {
        setLastFailure(value);
        return this;
    }

    @Override
    public UsernameLoginFailureRecord value5(String value) {
        setLastIpFailure(value);
        return this;
    }

    @Override
    public UsernameLoginFailureRecord value6(Integer value) {
        setNumFailures(value);
        return this;
    }

    @Override
    public UsernameLoginFailureRecord values(String value1, String value2, Integer value3, Long value4, String value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUsernameLoginFailure from) {
        setRealmId(from.getRealmId());
        setUsername(from.getUsername());
        setFailedLoginNotBefore(from.getFailedLoginNotBefore());
        setLastFailure(from.getLastFailure());
        setLastIpFailure(from.getLastIpFailure());
        setNumFailures(from.getNumFailures());
    }

    @Override
    public <E extends IUsernameLoginFailure> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsernameLoginFailureRecord
     */
    public UsernameLoginFailureRecord() {
        super(UsernameLoginFailure.USERNAME_LOGIN_FAILURE);
    }

    /**
     * Create a detached, initialised UsernameLoginFailureRecord
     */
    public UsernameLoginFailureRecord(String realmId, String username, Integer failedLoginNotBefore, Long lastFailure, String lastIpFailure, Integer numFailures) {
        super(UsernameLoginFailure.USERNAME_LOGIN_FAILURE);

        setRealmId(realmId);
        setUsername(username);
        setFailedLoginNotBefore(failedLoginNotBefore);
        setLastFailure(lastFailure);
        setLastIpFailure(lastIpFailure);
        setNumFailures(numFailures);
    }

    /**
     * Create a detached, initialised UsernameLoginFailureRecord
     */
    public UsernameLoginFailureRecord(com.hiddenswitch.framework.schema.keycloak.tables.pojos.UsernameLoginFailure value) {
        super(UsernameLoginFailure.USERNAME_LOGIN_FAILURE);

        if (value != null) {
            setRealmId(value.getRealmId());
            setUsername(value.getUsername());
            setFailedLoginNotBefore(value.getFailedLoginNotBefore());
            setLastFailure(value.getLastFailure());
            setLastIpFailure(value.getLastIpFailure());
            setNumFailures(value.getNumFailures());
        }
    }

        public UsernameLoginFailureRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}

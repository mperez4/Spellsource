/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.pojos;


import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.ICredential;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Credential implements VertxPojo, ICredential {

    private static final long serialVersionUID = 1L;

    private String  id;
    private String  device;
    private Integer hashIterations;
    private byte[]  salt;
    private String  type;
    private String  value;
    private String  userId;
    private Long    createdDate;
    private Integer counter;
    private Integer digits;
    private Integer period;
    private String  algorithm;

    public Credential() {}

    public Credential(ICredential value) {
        this.id = value.getId();
        this.device = value.getDevice();
        this.hashIterations = value.getHashIterations();
        this.salt = value.getSalt();
        this.type = value.getType();
        this.value = value.getValue();
        this.userId = value.getUserId();
        this.createdDate = value.getCreatedDate();
        this.counter = value.getCounter();
        this.digits = value.getDigits();
        this.period = value.getPeriod();
        this.algorithm = value.getAlgorithm();
    }

    public Credential(
        String  id,
        String  device,
        Integer hashIterations,
        byte[]  salt,
        String  type,
        String  value,
        String  userId,
        Long    createdDate,
        Integer counter,
        Integer digits,
        Integer period,
        String  algorithm
    ) {
        this.id = id;
        this.device = device;
        this.hashIterations = hashIterations;
        this.salt = salt;
        this.type = type;
        this.value = value;
        this.userId = userId;
        this.createdDate = createdDate;
        this.counter = counter;
        this.digits = digits;
        this.period = period;
        this.algorithm = algorithm;
    }

        public Credential(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>keycloak.credential.id</code>.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Setter for <code>keycloak.credential.id</code>.
     */
    @Override
    public Credential setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.device</code>.
     */
    @Override
    public String getDevice() {
        return this.device;
    }

    /**
     * Setter for <code>keycloak.credential.device</code>.
     */
    @Override
    public Credential setDevice(String device) {
        this.device = device;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.hash_iterations</code>.
     */
    @Override
    public Integer getHashIterations() {
        return this.hashIterations;
    }

    /**
     * Setter for <code>keycloak.credential.hash_iterations</code>.
     */
    @Override
    public Credential setHashIterations(Integer hashIterations) {
        this.hashIterations = hashIterations;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.salt</code>.
     */
    @Override
    public byte[] getSalt() {
        return this.salt;
    }

    /**
     * Setter for <code>keycloak.credential.salt</code>.
     */
    @Override
    public Credential setSalt(byte[] salt) {
        this.salt = salt;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.type</code>.
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Setter for <code>keycloak.credential.type</code>.
     */
    @Override
    public Credential setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.value</code>.
     */
    @Override
    public String getValue() {
        return this.value;
    }

    /**
     * Setter for <code>keycloak.credential.value</code>.
     */
    @Override
    public Credential setValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.user_id</code>.
     */
    @Override
    public String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>keycloak.credential.user_id</code>.
     */
    @Override
    public Credential setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.created_date</code>.
     */
    @Override
    public Long getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Setter for <code>keycloak.credential.created_date</code>.
     */
    @Override
    public Credential setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.counter</code>.
     */
    @Override
    public Integer getCounter() {
        return this.counter;
    }

    /**
     * Setter for <code>keycloak.credential.counter</code>.
     */
    @Override
    public Credential setCounter(Integer counter) {
        this.counter = counter;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.digits</code>.
     */
    @Override
    public Integer getDigits() {
        return this.digits;
    }

    /**
     * Setter for <code>keycloak.credential.digits</code>.
     */
    @Override
    public Credential setDigits(Integer digits) {
        this.digits = digits;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.period</code>.
     */
    @Override
    public Integer getPeriod() {
        return this.period;
    }

    /**
     * Setter for <code>keycloak.credential.period</code>.
     */
    @Override
    public Credential setPeriod(Integer period) {
        this.period = period;
        return this;
    }

    /**
     * Getter for <code>keycloak.credential.algorithm</code>.
     */
    @Override
    public String getAlgorithm() {
        return this.algorithm;
    }

    /**
     * Setter for <code>keycloak.credential.algorithm</code>.
     */
    @Override
    public Credential setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Credential (");

        sb.append(id);
        sb.append(", ").append(device);
        sb.append(", ").append(hashIterations);
        sb.append(", ").append("[binary...]");
        sb.append(", ").append(type);
        sb.append(", ").append(value);
        sb.append(", ").append(userId);
        sb.append(", ").append(createdDate);
        sb.append(", ").append(counter);
        sb.append(", ").append(digits);
        sb.append(", ").append(period);
        sb.append(", ").append(algorithm);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ICredential from) {
        setId(from.getId());
        setDevice(from.getDevice());
        setHashIterations(from.getHashIterations());
        setSalt(from.getSalt());
        setType(from.getType());
        setValue(from.getValue());
        setUserId(from.getUserId());
        setCreatedDate(from.getCreatedDate());
        setCounter(from.getCounter());
        setDigits(from.getDigits());
        setPeriod(from.getPeriod());
        setAlgorithm(from.getAlgorithm());
    }

    @Override
    public <E extends ICredential> E into(E into) {
        into.from(this);
        return into;
    }
}

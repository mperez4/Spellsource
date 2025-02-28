/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.records;


import com.hiddenswitch.framework.schema.keycloak.tables.ResourceServerPolicy;
import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IResourceServerPolicy;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ResourceServerPolicyRecord extends UpdatableRecordImpl<ResourceServerPolicyRecord> implements VertxPojo, Record7<String, String, String, String, String, String, String>, IResourceServerPolicy {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>keycloak.resource_server_policy.id</code>.
     */
    @Override
    public ResourceServerPolicyRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.resource_server_policy.id</code>.
     */
    @Override
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>keycloak.resource_server_policy.name</code>.
     */
    @Override
    public ResourceServerPolicyRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.resource_server_policy.name</code>.
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>keycloak.resource_server_policy.description</code>.
     */
    @Override
    public ResourceServerPolicyRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.resource_server_policy.description</code>.
     */
    @Override
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>keycloak.resource_server_policy.type</code>.
     */
    @Override
    public ResourceServerPolicyRecord setType(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.resource_server_policy.type</code>.
     */
    @Override
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for
     * <code>keycloak.resource_server_policy.decision_strategy</code>.
     */
    @Override
    public ResourceServerPolicyRecord setDecisionStrategy(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for
     * <code>keycloak.resource_server_policy.decision_strategy</code>.
     */
    @Override
    public String getDecisionStrategy() {
        return (String) get(4);
    }

    /**
     * Setter for <code>keycloak.resource_server_policy.logic</code>.
     */
    @Override
    public ResourceServerPolicyRecord setLogic(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>keycloak.resource_server_policy.logic</code>.
     */
    @Override
    public String getLogic() {
        return (String) get(5);
    }

    /**
     * Setter for
     * <code>keycloak.resource_server_policy.resource_server_id</code>.
     */
    @Override
    public ResourceServerPolicyRecord setResourceServerId(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for
     * <code>keycloak.resource_server_policy.resource_server_id</code>.
     */
    @Override
    public String getResourceServerId() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<String, String, String, String, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return ResourceServerPolicy.RESOURCE_SERVER_POLICY.ID;
    }

    @Override
    public Field<String> field2() {
        return ResourceServerPolicy.RESOURCE_SERVER_POLICY.NAME;
    }

    @Override
    public Field<String> field3() {
        return ResourceServerPolicy.RESOURCE_SERVER_POLICY.DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return ResourceServerPolicy.RESOURCE_SERVER_POLICY.TYPE;
    }

    @Override
    public Field<String> field5() {
        return ResourceServerPolicy.RESOURCE_SERVER_POLICY.DECISION_STRATEGY;
    }

    @Override
    public Field<String> field6() {
        return ResourceServerPolicy.RESOURCE_SERVER_POLICY.LOGIC;
    }

    @Override
    public Field<String> field7() {
        return ResourceServerPolicy.RESOURCE_SERVER_POLICY.RESOURCE_SERVER_ID;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getDescription();
    }

    @Override
    public String component4() {
        return getType();
    }

    @Override
    public String component5() {
        return getDecisionStrategy();
    }

    @Override
    public String component6() {
        return getLogic();
    }

    @Override
    public String component7() {
        return getResourceServerId();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getDescription();
    }

    @Override
    public String value4() {
        return getType();
    }

    @Override
    public String value5() {
        return getDecisionStrategy();
    }

    @Override
    public String value6() {
        return getLogic();
    }

    @Override
    public String value7() {
        return getResourceServerId();
    }

    @Override
    public ResourceServerPolicyRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public ResourceServerPolicyRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ResourceServerPolicyRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public ResourceServerPolicyRecord value4(String value) {
        setType(value);
        return this;
    }

    @Override
    public ResourceServerPolicyRecord value5(String value) {
        setDecisionStrategy(value);
        return this;
    }

    @Override
    public ResourceServerPolicyRecord value6(String value) {
        setLogic(value);
        return this;
    }

    @Override
    public ResourceServerPolicyRecord value7(String value) {
        setResourceServerId(value);
        return this;
    }

    @Override
    public ResourceServerPolicyRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IResourceServerPolicy from) {
        setId(from.getId());
        setName(from.getName());
        setDescription(from.getDescription());
        setType(from.getType());
        setDecisionStrategy(from.getDecisionStrategy());
        setLogic(from.getLogic());
        setResourceServerId(from.getResourceServerId());
    }

    @Override
    public <E extends IResourceServerPolicy> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ResourceServerPolicyRecord
     */
    public ResourceServerPolicyRecord() {
        super(ResourceServerPolicy.RESOURCE_SERVER_POLICY);
    }

    /**
     * Create a detached, initialised ResourceServerPolicyRecord
     */
    public ResourceServerPolicyRecord(String id, String name, String description, String type, String decisionStrategy, String logic, String resourceServerId) {
        super(ResourceServerPolicy.RESOURCE_SERVER_POLICY);

        setId(id);
        setName(name);
        setDescription(description);
        setType(type);
        setDecisionStrategy(decisionStrategy);
        setLogic(logic);
        setResourceServerId(resourceServerId);
    }

    /**
     * Create a detached, initialised ResourceServerPolicyRecord
     */
    public ResourceServerPolicyRecord(com.hiddenswitch.framework.schema.keycloak.tables.pojos.ResourceServerPolicy value) {
        super(ResourceServerPolicy.RESOURCE_SERVER_POLICY);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setDescription(value.getDescription());
            setType(value.getType());
            setDecisionStrategy(value.getDecisionStrategy());
            setLogic(value.getLogic());
            setResourceServerId(value.getResourceServerId());
        }
    }

        public ResourceServerPolicyRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}

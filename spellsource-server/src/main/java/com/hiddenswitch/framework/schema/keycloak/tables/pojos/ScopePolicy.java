/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.pojos;


import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IScopePolicy;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScopePolicy implements VertxPojo, IScopePolicy {

    private static final long serialVersionUID = 1L;

    private String scopeId;
    private String policyId;

    public ScopePolicy() {}

    public ScopePolicy(IScopePolicy value) {
        this.scopeId = value.getScopeId();
        this.policyId = value.getPolicyId();
    }

    public ScopePolicy(
        String scopeId,
        String policyId
    ) {
        this.scopeId = scopeId;
        this.policyId = policyId;
    }

        public ScopePolicy(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>keycloak.scope_policy.scope_id</code>.
     */
    @Override
    public String getScopeId() {
        return this.scopeId;
    }

    /**
     * Setter for <code>keycloak.scope_policy.scope_id</code>.
     */
    @Override
    public ScopePolicy setScopeId(String scopeId) {
        this.scopeId = scopeId;
        return this;
    }

    /**
     * Getter for <code>keycloak.scope_policy.policy_id</code>.
     */
    @Override
    public String getPolicyId() {
        return this.policyId;
    }

    /**
     * Setter for <code>keycloak.scope_policy.policy_id</code>.
     */
    @Override
    public ScopePolicy setPolicyId(String policyId) {
        this.policyId = policyId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ScopePolicy (");

        sb.append(scopeId);
        sb.append(", ").append(policyId);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IScopePolicy from) {
        setScopeId(from.getScopeId());
        setPolicyId(from.getPolicyId());
    }

    @Override
    public <E extends IScopePolicy> E into(E into) {
        into.from(this);
        return into;
    }
}

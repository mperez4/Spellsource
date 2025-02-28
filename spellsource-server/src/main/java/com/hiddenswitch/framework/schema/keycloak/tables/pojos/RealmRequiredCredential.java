/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.pojos;


import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IRealmRequiredCredential;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RealmRequiredCredential implements VertxPojo, IRealmRequiredCredential {

    private static final long serialVersionUID = 1L;

    private String  type;
    private String  formLabel;
    private Boolean input;
    private Boolean secret;
    private String  realmId;

    public RealmRequiredCredential() {}

    public RealmRequiredCredential(IRealmRequiredCredential value) {
        this.type = value.getType();
        this.formLabel = value.getFormLabel();
        this.input = value.getInput();
        this.secret = value.getSecret();
        this.realmId = value.getRealmId();
    }

    public RealmRequiredCredential(
        String  type,
        String  formLabel,
        Boolean input,
        Boolean secret,
        String  realmId
    ) {
        this.type = type;
        this.formLabel = formLabel;
        this.input = input;
        this.secret = secret;
        this.realmId = realmId;
    }

        public RealmRequiredCredential(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>keycloak.realm_required_credential.type</code>.
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Setter for <code>keycloak.realm_required_credential.type</code>.
     */
    @Override
    public RealmRequiredCredential setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_required_credential.form_label</code>.
     */
    @Override
    public String getFormLabel() {
        return this.formLabel;
    }

    /**
     * Setter for <code>keycloak.realm_required_credential.form_label</code>.
     */
    @Override
    public RealmRequiredCredential setFormLabel(String formLabel) {
        this.formLabel = formLabel;
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_required_credential.input</code>.
     */
    @Override
    public Boolean getInput() {
        return this.input;
    }

    /**
     * Setter for <code>keycloak.realm_required_credential.input</code>.
     */
    @Override
    public RealmRequiredCredential setInput(Boolean input) {
        this.input = input;
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_required_credential.secret</code>.
     */
    @Override
    public Boolean getSecret() {
        return this.secret;
    }

    /**
     * Setter for <code>keycloak.realm_required_credential.secret</code>.
     */
    @Override
    public RealmRequiredCredential setSecret(Boolean secret) {
        this.secret = secret;
        return this;
    }

    /**
     * Getter for <code>keycloak.realm_required_credential.realm_id</code>.
     */
    @Override
    public String getRealmId() {
        return this.realmId;
    }

    /**
     * Setter for <code>keycloak.realm_required_credential.realm_id</code>.
     */
    @Override
    public RealmRequiredCredential setRealmId(String realmId) {
        this.realmId = realmId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RealmRequiredCredential (");

        sb.append(type);
        sb.append(", ").append(formLabel);
        sb.append(", ").append(input);
        sb.append(", ").append(secret);
        sb.append(", ").append(realmId);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IRealmRequiredCredential from) {
        setType(from.getType());
        setFormLabel(from.getFormLabel());
        setInput(from.getInput());
        setSecret(from.getSecret());
        setRealmId(from.getRealmId());
    }

    @Override
    public <E extends IRealmRequiredCredential> E into(E into) {
        into.from(this);
        return into;
    }
}

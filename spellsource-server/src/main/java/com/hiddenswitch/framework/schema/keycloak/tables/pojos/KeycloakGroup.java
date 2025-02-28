/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.pojos;


import com.hiddenswitch.framework.schema.keycloak.tables.interfaces.IKeycloakGroup;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class KeycloakGroup implements VertxPojo, IKeycloakGroup {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String parentGroup;
    private String realmId;

    public KeycloakGroup() {}

    public KeycloakGroup(IKeycloakGroup value) {
        this.id = value.getId();
        this.name = value.getName();
        this.parentGroup = value.getParentGroup();
        this.realmId = value.getRealmId();
    }

    public KeycloakGroup(
        String id,
        String name,
        String parentGroup,
        String realmId
    ) {
        this.id = id;
        this.name = name;
        this.parentGroup = parentGroup;
        this.realmId = realmId;
    }

        public KeycloakGroup(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>keycloak.keycloak_group.id</code>.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Setter for <code>keycloak.keycloak_group.id</code>.
     */
    @Override
    public KeycloakGroup setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>keycloak.keycloak_group.name</code>.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>keycloak.keycloak_group.name</code>.
     */
    @Override
    public KeycloakGroup setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>keycloak.keycloak_group.parent_group</code>.
     */
    @Override
    public String getParentGroup() {
        return this.parentGroup;
    }

    /**
     * Setter for <code>keycloak.keycloak_group.parent_group</code>.
     */
    @Override
    public KeycloakGroup setParentGroup(String parentGroup) {
        this.parentGroup = parentGroup;
        return this;
    }

    /**
     * Getter for <code>keycloak.keycloak_group.realm_id</code>.
     */
    @Override
    public String getRealmId() {
        return this.realmId;
    }

    /**
     * Setter for <code>keycloak.keycloak_group.realm_id</code>.
     */
    @Override
    public KeycloakGroup setRealmId(String realmId) {
        this.realmId = realmId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("KeycloakGroup (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(parentGroup);
        sb.append(", ").append(realmId);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IKeycloakGroup from) {
        setId(from.getId());
        setName(from.getName());
        setParentGroup(from.getParentGroup());
        setRealmId(from.getRealmId());
    }

    @Override
    public <E extends IKeycloakGroup> E into(E into) {
        into.from(this);
        return into;
    }
}

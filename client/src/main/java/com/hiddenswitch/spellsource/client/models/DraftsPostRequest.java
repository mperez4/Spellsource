/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more.  To get started, create a user account and make sure to include the entirety of the returned login token as the X-Auth-Token header. You can reuse this token, or login for a new one.  ClientToServerMessage and ServerToClientMessage are used for the realtime game state and actions two-way websocket interface for actually playing a game. Envelope is used for the realtime API services. 
 *
 * OpenAPI spec version: 1.1.0
 * Contact: ben@hiddenswitch.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.hiddenswitch.spellsource.client.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * DraftsPostRequest
 */

public class DraftsPostRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("startDraft")
  private Boolean startDraft = null;

  @JsonProperty("retireEarly")
  private Boolean retireEarly = null;

  public DraftsPostRequest startDraft(Boolean startDraft) {
    this.startDraft = startDraft;
    return this;
  }

   /**
   * Starts a new draft. 
   * @return startDraft
  **/
  @ApiModelProperty(value = "Starts a new draft. ")
  public Boolean isStartDraft() {
    return startDraft;
  }

  public void setStartDraft(Boolean startDraft) {
    this.startDraft = startDraft;
  }

  public DraftsPostRequest retireEarly(Boolean retireEarly) {
    this.retireEarly = retireEarly;
    return this;
  }

   /**
   * Retires a draft early. Typically this costs some number of lives. 
   * @return retireEarly
  **/
  @ApiModelProperty(value = "Retires a draft early. Typically this costs some number of lives. ")
  public Boolean isRetireEarly() {
    return retireEarly;
  }

  public void setRetireEarly(Boolean retireEarly) {
    this.retireEarly = retireEarly;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DraftsPostRequest draftsPostRequest = (DraftsPostRequest) o;
    return Objects.equals(this.startDraft, draftsPostRequest.startDraft) &&
        Objects.equals(this.retireEarly, draftsPostRequest.retireEarly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDraft, retireEarly);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DraftsPostRequest {\n");
    
    sb.append("    startDraft: ").append(toIndentedString(startDraft)).append("\n");
    sb.append("    retireEarly: ").append(toIndentedString(retireEarly)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


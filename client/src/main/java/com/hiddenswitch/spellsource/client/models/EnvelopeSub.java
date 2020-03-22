/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more.  To get started, create a user account and make sure to include the entirety of the returned login token as the X-Auth-Token header. You can reuse this token, or login for a new one.  ClientToServerMessage and ServerToClientMessage are used for the realtime game state and actions two-way websocket interface for actually playing a game. Envelope is used for the realtime API services.  For the routes that correspond to the paths in this file, visit the Gateway.java file in the Spellsource-Server GitHub repository located in this definition file. 
 *
 * OpenAPI spec version: 4.0.1
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
import com.hiddenswitch.spellsource.client.models.EnvelopeSubConversation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * When populated by the client and sent to the server, subscribes to data of the specified kind. 
 */
@ApiModel(description = "When populated by the client and sent to the server, subscribes to data of the specified kind. ")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class EnvelopeSub implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("editableCards")
  private Object editableCards = null;

  @JsonProperty("conversation")
  private EnvelopeSubConversation conversation = null;

  public EnvelopeSub editableCards(Object editableCards) {
    this.editableCards = editableCards;
    return this;
  }

   /**
   * Subscribes to the user&#39;s editable card collection. 
   * @return editableCards
  **/
  @ApiModelProperty(value = "Subscribes to the user's editable card collection. ")
  public Object getEditableCards() {
    return editableCards;
  }

  public void setEditableCards(Object editableCards) {
    this.editableCards = editableCards;
  }

  public EnvelopeSub conversation(EnvelopeSubConversation conversation) {
    this.conversation = conversation;
    return this;
  }

   /**
   * Get conversation
   * @return conversation
  **/
  @ApiModelProperty(value = "")
  public EnvelopeSubConversation getConversation() {
    return conversation;
  }

  public void setConversation(EnvelopeSubConversation conversation) {
    this.conversation = conversation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnvelopeSub envelopeSub = (EnvelopeSub) o;
    return Objects.equals(this.editableCards, envelopeSub.editableCards) &&
        Objects.equals(this.conversation, envelopeSub.conversation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(editableCards, conversation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnvelopeSub {\n");
    
    sb.append("    editableCards: ").append(toIndentedString(editableCards)).append("\n");
    sb.append("    conversation: ").append(toIndentedString(conversation)).append("\n");
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


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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Requests to send an invite to play a 1v1 match, to friend a player, or both. 
 */
@ApiModel(description = "Requests to send an invite to play a 1v1 match, to friend a player, or both. ")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class InvitePostRequest implements Serializable {

  @JsonProperty("friend")
  private Boolean friend = false;

  @JsonProperty("queueId")
  private String queueId = null;

  @JsonProperty("deckId")
  private String deckId = null;

  @JsonProperty("toUserId")
  private String toUserId = null;

  @JsonProperty("toUserNameWithToken")
  private String toUserNameWithToken = null;

  @JsonProperty("message")
  private String message = null;

  public InvitePostRequest friend(Boolean friend) {
    this.friend = friend;
    return this;
  }

   /**
   * When true, indicates that this request is a friend invitation. 
   * @return friend
  **/
  @ApiModelProperty(value = "When true, indicates that this request is a friend invitation. ")
  public Boolean isFriend() {
    return friend;
  }

  public void setFriend(Boolean friend) {
    this.friend = friend;
  }

  public InvitePostRequest queueId(String queueId) {
    this.queueId = queueId;
    return this;
  }

   /**
   * The queue that the player would like to 1v1 inside of. These may differ from the competitive queues. 
   * @return queueId
  **/
  @ApiModelProperty(value = "The queue that the player would like to 1v1 inside of. These may differ from the competitive queues. ")
  public String getQueueId() {
    return queueId;
  }

  public void setQueueId(String queueId) {
    this.queueId = queueId;
  }

  public InvitePostRequest deckId(String deckId) {
    this.deckId = deckId;
    return this;
  }

   /**
   * The deck the user is creating this invite with. Used for 1v1 queues. If this is specified, the user is automatically enqueued. 
   * @return deckId
  **/
  @ApiModelProperty(value = "The deck the user is creating this invite with. Used for 1v1 queues. If this is specified, the user is automatically enqueued. ")
  public String getDeckId() {
    return deckId;
  }

  public void setDeckId(String deckId) {
    this.deckId = deckId;
  }

  public InvitePostRequest toUserId(String toUserId) {
    this.toUserId = toUserId;
    return this;
  }

   /**
   * The user who should receive the invite 
   * @return toUserId
  **/
  @ApiModelProperty(value = "The user who should receive the invite ")
  public String getToUserId() {
    return toUserId;
  }

  public void setToUserId(String toUserId) {
    this.toUserId = toUserId;
  }

  public InvitePostRequest toUserNameWithToken(String toUserNameWithToken) {
    this.toUserNameWithToken = toUserNameWithToken;
    return this;
  }

   /**
   * The username and privacy token (#1234 part) to send the request to 
   * @return toUserNameWithToken
  **/
  @ApiModelProperty(value = "The username and privacy token (#1234 part) to send the request to ")
  public String getToUserNameWithToken() {
    return toUserNameWithToken;
  }

  public void setToUserNameWithToken(String toUserNameWithToken) {
    this.toUserNameWithToken = toUserNameWithToken;
  }

  public InvitePostRequest message(String message) {
    this.message = message;
    return this;
  }

   /**
   * An optional message to add to the invite request 
   * @return message
  **/
  @ApiModelProperty(value = "An optional message to add to the invite request ")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvitePostRequest invitePostRequest = (InvitePostRequest) o;
    return Objects.equals(this.friend, invitePostRequest.friend) &&
        Objects.equals(this.queueId, invitePostRequest.queueId) &&
        Objects.equals(this.deckId, invitePostRequest.deckId) &&
        Objects.equals(this.toUserId, invitePostRequest.toUserId) &&
        Objects.equals(this.toUserNameWithToken, invitePostRequest.toUserNameWithToken) &&
        Objects.equals(this.message, invitePostRequest.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(friend, queueId, deckId, toUserId, toUserNameWithToken, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvitePostRequest {\n");
    
    sb.append("    friend: ").append(toIndentedString(friend)).append("\n");
    sb.append("    queueId: ").append(toIndentedString(queueId)).append("\n");
    sb.append("    deckId: ").append(toIndentedString(deckId)).append("\n");
    sb.append("    toUserId: ").append(toIndentedString(toUserId)).append("\n");
    sb.append("    toUserNameWithToken: ").append(toIndentedString(toUserNameWithToken)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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


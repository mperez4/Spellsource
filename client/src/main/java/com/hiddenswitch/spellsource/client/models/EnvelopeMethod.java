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
import com.hiddenswitch.spellsource.client.models.EnvelopeMethodDequeue;
import com.hiddenswitch.spellsource.client.models.EnvelopeMethodEnqueue;
import com.hiddenswitch.spellsource.client.models.EnvelopeMethodSendMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * When populated by the client and sent to the server, indicates a method should be called. The side effects of methods may include new data updates and a response. 
 */
@ApiModel(description = "When populated by the client and sent to the server, indicates a method should be called. The side effects of methods may include new data updates and a response. ")

public class EnvelopeMethod implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("methodId")
  private String methodId = null;

  @JsonProperty("enqueue")
  private EnvelopeMethodEnqueue enqueue = null;

  @JsonProperty("dequeue")
  private EnvelopeMethodDequeue dequeue = null;

  @JsonProperty("sendMessage")
  private EnvelopeMethodSendMessage sendMessage = null;

  public EnvelopeMethod methodId(String methodId) {
    this.methodId = methodId;
    return this;
  }

   /**
   * The client-specified ID that will be used to mark the reply (the result) of this method call. 
   * @return methodId
  **/
  @ApiModelProperty(value = "The client-specified ID that will be used to mark the reply (the result) of this method call. ")
  public String getMethodId() {
    return methodId;
  }

  public void setMethodId(String methodId) {
    this.methodId = methodId;
  }

  public EnvelopeMethod enqueue(EnvelopeMethodEnqueue enqueue) {
    this.enqueue = enqueue;
    return this;
  }

   /**
   * Get enqueue
   * @return enqueue
  **/
  @ApiModelProperty(value = "")
  public EnvelopeMethodEnqueue getEnqueue() {
    return enqueue;
  }

  public void setEnqueue(EnvelopeMethodEnqueue enqueue) {
    this.enqueue = enqueue;
  }

  public EnvelopeMethod dequeue(EnvelopeMethodDequeue dequeue) {
    this.dequeue = dequeue;
    return this;
  }

   /**
   * Get dequeue
   * @return dequeue
  **/
  @ApiModelProperty(value = "")
  public EnvelopeMethodDequeue getDequeue() {
    return dequeue;
  }

  public void setDequeue(EnvelopeMethodDequeue dequeue) {
    this.dequeue = dequeue;
  }

  public EnvelopeMethod sendMessage(EnvelopeMethodSendMessage sendMessage) {
    this.sendMessage = sendMessage;
    return this;
  }

   /**
   * Get sendMessage
   * @return sendMessage
  **/
  @ApiModelProperty(value = "")
  public EnvelopeMethodSendMessage getSendMessage() {
    return sendMessage;
  }

  public void setSendMessage(EnvelopeMethodSendMessage sendMessage) {
    this.sendMessage = sendMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnvelopeMethod envelopeMethod = (EnvelopeMethod) o;
    return Objects.equals(this.methodId, envelopeMethod.methodId) &&
        Objects.equals(this.enqueue, envelopeMethod.enqueue) &&
        Objects.equals(this.dequeue, envelopeMethod.dequeue) &&
        Objects.equals(this.sendMessage, envelopeMethod.sendMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(methodId, enqueue, dequeue, sendMessage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnvelopeMethod {\n");
    
    sb.append("    methodId: ").append(toIndentedString(methodId)).append("\n");
    sb.append("    enqueue: ").append(toIndentedString(enqueue)).append("\n");
    sb.append("    dequeue: ").append(toIndentedString(dequeue)).append("\n");
    sb.append("    sendMessage: ").append(toIndentedString(sendMessage)).append("\n");
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


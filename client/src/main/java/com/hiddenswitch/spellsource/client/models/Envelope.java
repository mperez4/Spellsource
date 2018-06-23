/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more.  To get started, create a user account and make sure to include the entirety of the returned login token as the X-Auth-Token header. You can reuse this token, or login for a new one.  ClientToServerMessage and ServerToClientMessage are used for the realtime game state and actions two-way websocket interface for actually playing a game. Envelope is used for the realtime API services. 
 *
 * OpenAPI spec version: 2.0.0
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
import com.hiddenswitch.spellsource.client.models.EnvelopeAdded;
import com.hiddenswitch.spellsource.client.models.EnvelopeChanged;
import com.hiddenswitch.spellsource.client.models.EnvelopeMethod;
import com.hiddenswitch.spellsource.client.models.EnvelopeRemoved;
import com.hiddenswitch.spellsource.client.models.EnvelopeRequest;
import com.hiddenswitch.spellsource.client.models.EnvelopeResponse;
import com.hiddenswitch.spellsource.client.models.EnvelopeResult;
import com.hiddenswitch.spellsource.client.models.EnvelopeSub;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * A container for data to and from the server. This envelope is the type of every message sent through the /realtime websocket endpoint. 
 */
@ApiModel(description = "A container for data to and from the server. This envelope is the type of every message sent through the /realtime websocket endpoint. ")

public class Envelope implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("added")
  private EnvelopeAdded added = null;

  @JsonProperty("changed")
  private EnvelopeChanged changed = null;

  @JsonProperty("removed")
  private EnvelopeRemoved removed = null;

  @JsonProperty("sub")
  private EnvelopeSub sub = null;

  @JsonProperty("request")
  private EnvelopeRequest request = null;

  @JsonProperty("response")
  private EnvelopeResponse response = null;

  @JsonProperty("method")
  private EnvelopeMethod method = null;

  @JsonProperty("result")
  private EnvelopeResult result = null;

  public Envelope added(EnvelopeAdded added) {
    this.added = added;
    return this;
  }

   /**
   * Get added
   * @return added
  **/
  @ApiModelProperty(value = "")
  public EnvelopeAdded getAdded() {
    return added;
  }

  public void setAdded(EnvelopeAdded added) {
    this.added = added;
  }

  public Envelope changed(EnvelopeChanged changed) {
    this.changed = changed;
    return this;
  }

   /**
   * Get changed
   * @return changed
  **/
  @ApiModelProperty(value = "")
  public EnvelopeChanged getChanged() {
    return changed;
  }

  public void setChanged(EnvelopeChanged changed) {
    this.changed = changed;
  }

  public Envelope removed(EnvelopeRemoved removed) {
    this.removed = removed;
    return this;
  }

   /**
   * Get removed
   * @return removed
  **/
  @ApiModelProperty(value = "")
  public EnvelopeRemoved getRemoved() {
    return removed;
  }

  public void setRemoved(EnvelopeRemoved removed) {
    this.removed = removed;
  }

  public Envelope sub(EnvelopeSub sub) {
    this.sub = sub;
    return this;
  }

   /**
   * Get sub
   * @return sub
  **/
  @ApiModelProperty(value = "")
  public EnvelopeSub getSub() {
    return sub;
  }

  public void setSub(EnvelopeSub sub) {
    this.sub = sub;
  }

  public Envelope request(EnvelopeRequest request) {
    this.request = request;
    return this;
  }

   /**
   * Get request
   * @return request
  **/
  @ApiModelProperty(value = "")
  public EnvelopeRequest getRequest() {
    return request;
  }

  public void setRequest(EnvelopeRequest request) {
    this.request = request;
  }

  public Envelope response(EnvelopeResponse response) {
    this.response = response;
    return this;
  }

   /**
   * Get response
   * @return response
  **/
  @ApiModelProperty(value = "")
  public EnvelopeResponse getResponse() {
    return response;
  }

  public void setResponse(EnvelopeResponse response) {
    this.response = response;
  }

  public Envelope method(EnvelopeMethod method) {
    this.method = method;
    return this;
  }

   /**
   * Get method
   * @return method
  **/
  @ApiModelProperty(value = "")
  public EnvelopeMethod getMethod() {
    return method;
  }

  public void setMethod(EnvelopeMethod method) {
    this.method = method;
  }

  public Envelope result(EnvelopeResult result) {
    this.result = result;
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")
  public EnvelopeResult getResult() {
    return result;
  }

  public void setResult(EnvelopeResult result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Envelope envelope = (Envelope) o;
    return Objects.equals(this.added, envelope.added) &&
        Objects.equals(this.changed, envelope.changed) &&
        Objects.equals(this.removed, envelope.removed) &&
        Objects.equals(this.sub, envelope.sub) &&
        Objects.equals(this.request, envelope.request) &&
        Objects.equals(this.response, envelope.response) &&
        Objects.equals(this.method, envelope.method) &&
        Objects.equals(this.result, envelope.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(added, changed, removed, sub, request, response, method, result);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Envelope {\n");
    
    sb.append("    added: ").append(toIndentedString(added)).append("\n");
    sb.append("    changed: ").append(toIndentedString(changed)).append("\n");
    sb.append("    removed: ").append(toIndentedString(removed)).append("\n");
    sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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


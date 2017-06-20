/**
 * Hidden Switch Minionate API
 * The Minionate API for matchmaking, user accounts, collections management and more
 *
 * OpenAPI spec version: 1.0.1
 * Contact: benjamin.s.berman@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.hiddenswitch.proto3.net.client.models;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import com.hiddenswitch.proto3.net.client.models.Entity;
import com.hiddenswitch.proto3.net.client.models.GameEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
/**
 * GameState
 */

public class GameState  implements Serializable {
  @SerializedName("eventStack")
  private List<GameEvent> eventStack = new ArrayList<GameEvent>();

  @SerializedName("entities")
  private List<Entity> entities = new ArrayList<Entity>();

  @SerializedName("isLocalPlayerTurn")
  private Boolean isLocalPlayerTurn = null;

  @SerializedName("turnState")
  private String turnState = null;

  @SerializedName("turnNumber")
  private Integer turnNumber = null;

  @SerializedName("timestamp")
  private Long timestamp = null;

  public GameState eventStack(List<GameEvent> eventStack) {
    this.eventStack = eventStack;
    return this;
  }

  public GameState addEventStackItem(GameEvent eventStackItem) {
    this.eventStack.add(eventStackItem);
    return this;
  }

   /**
   * Get eventStack
   * @return eventStack
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<GameEvent> getEventStack() {
    return eventStack;
  }

  public void setEventStack(List<GameEvent> eventStack) {
    this.eventStack = eventStack;
  }

  public GameState entities(List<Entity> entities) {
    this.entities = entities;
    return this;
  }

  public GameState addEntitiesItem(Entity entitiesItem) {
    this.entities.add(entitiesItem);
    return this;
  }

   /**
   * Get entities
   * @return entities
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<Entity> getEntities() {
    return entities;
  }

  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  public GameState isLocalPlayerTurn(Boolean isLocalPlayerTurn) {
    this.isLocalPlayerTurn = isLocalPlayerTurn;
    return this;
  }

   /**
   * When true, it is the local player's turn.
   * @return isLocalPlayerTurn
  **/
  @ApiModelProperty(example = "null", value = "When true, it is the local player's turn.")
  public Boolean getIsLocalPlayerTurn() {
    return isLocalPlayerTurn;
  }

  public void setIsLocalPlayerTurn(Boolean isLocalPlayerTurn) {
    this.isLocalPlayerTurn = isLocalPlayerTurn;
  }

  public GameState turnState(String turnState) {
    this.turnState = turnState;
    return this;
  }

   /**
   * Get turnState
   * @return turnState
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getTurnState() {
    return turnState;
  }

  public void setTurnState(String turnState) {
    this.turnState = turnState;
  }

  public GameState turnNumber(Integer turnNumber) {
    this.turnNumber = turnNumber;
    return this;
  }

   /**
   * Get turnNumber
   * @return turnNumber
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getTurnNumber() {
    return turnNumber;
  }

  public void setTurnNumber(Integer turnNumber) {
    this.turnNumber = turnNumber;
  }

  public GameState timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(example = "null", value = "")
  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameState gameState = (GameState) o;
    return Objects.equals(this.eventStack, gameState.eventStack) &&
        Objects.equals(this.entities, gameState.entities) &&
        Objects.equals(this.isLocalPlayerTurn, gameState.isLocalPlayerTurn) &&
        Objects.equals(this.turnState, gameState.turnState) &&
        Objects.equals(this.turnNumber, gameState.turnNumber) &&
        Objects.equals(this.timestamp, gameState.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventStack, entities, isLocalPlayerTurn, turnState, turnNumber, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameState {\n");
    
    sb.append("    eventStack: ").append(toIndentedString(eventStack)).append("\n");
    sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
    sb.append("    isLocalPlayerTurn: ").append(toIndentedString(isLocalPlayerTurn)).append("\n");
    sb.append("    turnState: ").append(toIndentedString(turnState)).append("\n");
    sb.append("    turnNumber: ").append(toIndentedString(turnNumber)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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


/**
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more
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


package com.hiddenswitch.spellsource.client.models;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import com.hiddenswitch.spellsource.client.models.GameActionsChooseOnesSpells;
import com.hiddenswitch.spellsource.client.models.GameActionsChooseOnesSummons;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
/**
 * Choose one actions, summons and spells. 
 */
@ApiModel(description = "Choose one actions, summons and spells. ")

public class GameActionsChooseOnes  implements Serializable {
  @SerializedName("spells")
  private List<GameActionsChooseOnesSpells> spells = new ArrayList<GameActionsChooseOnesSpells>();

  @SerializedName("summons")
  private List<GameActionsChooseOnesSummons> summons = new ArrayList<GameActionsChooseOnesSummons>();

  public GameActionsChooseOnes spells(List<GameActionsChooseOnesSpells> spells) {
    this.spells = spells;
    return this;
  }

  public GameActionsChooseOnes addSpellsItem(GameActionsChooseOnesSpells spellsItem) {
    this.spells.add(spellsItem);
    return this;
  }

   /**
   * An array of choose one spells. Each spell is represented by a different card. An entity that can be used to render a card for the option is provided. Use the spell action's card ID to figure out which options correspond to which cards in the hand. 
   * @return spells
  **/
  @ApiModelProperty(example = "null", value = "An array of choose one spells. Each spell is represented by a different card. An entity that can be used to render a card for the option is provided. Use the spell action's card ID to figure out which options correspond to which cards in the hand. ")
  public List<GameActionsChooseOnesSpells> getSpells() {
    return spells;
  }

  public void setSpells(List<GameActionsChooseOnesSpells> spells) {
    this.spells = spells;
  }

  public GameActionsChooseOnes summons(List<GameActionsChooseOnesSummons> summons) {
    this.summons = summons;
    return this;
  }

  public GameActionsChooseOnes addSummonsItem(GameActionsChooseOnesSummons summonsItem) {
    this.summons.add(summonsItem);
    return this;
  }

   /**
   * An array of choose one summonables. Use the description to help render the appropriate options. 
   * @return summons
  **/
  @ApiModelProperty(example = "null", value = "An array of choose one summonables. Use the description to help render the appropriate options. ")
  public List<GameActionsChooseOnesSummons> getSummons() {
    return summons;
  }

  public void setSummons(List<GameActionsChooseOnesSummons> summons) {
    this.summons = summons;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameActionsChooseOnes gameActionsChooseOnes = (GameActionsChooseOnes) o;
    return Objects.equals(this.spells, gameActionsChooseOnes.spells) &&
        Objects.equals(this.summons, gameActionsChooseOnes.summons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spells, summons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameActionsChooseOnes {\n");
    
    sb.append("    spells: ").append(toIndentedString(spells)).append("\n");
    sb.append("    summons: ").append(toIndentedString(summons)).append("\n");
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


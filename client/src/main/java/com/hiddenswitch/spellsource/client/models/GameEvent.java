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
import com.hiddenswitch.spellsource.client.models.CardEvent;
import com.hiddenswitch.spellsource.client.models.GameEventAfterSpellCasted;
import com.hiddenswitch.spellsource.client.models.GameEventArmorGained;
import com.hiddenswitch.spellsource.client.models.GameEventBeforeSummon;
import com.hiddenswitch.spellsource.client.models.GameEventDamage;
import com.hiddenswitch.spellsource.client.models.GameEventFatigue;
import com.hiddenswitch.spellsource.client.models.GameEventHeal;
import com.hiddenswitch.spellsource.client.models.GameEventHeroPowerUsed;
import com.hiddenswitch.spellsource.client.models.GameEventJoust;
import com.hiddenswitch.spellsource.client.models.GameEventKill;
import com.hiddenswitch.spellsource.client.models.GameEventOverload;
import com.hiddenswitch.spellsource.client.models.GameEventPerformedGameAction;
import com.hiddenswitch.spellsource.client.models.GameEventPreDamage;
import com.hiddenswitch.spellsource.client.models.GameEventQuestSuccessful;
import com.hiddenswitch.spellsource.client.models.GameEventSecretPlayed;
import com.hiddenswitch.spellsource.client.models.GameEventSecretRevealed;
import com.hiddenswitch.spellsource.client.models.GameEventSilence;
import com.hiddenswitch.spellsource.client.models.GameEventTargetAcquisition;
import com.hiddenswitch.spellsource.client.models.GameEventTriggerFired;
import com.hiddenswitch.spellsource.client.models.GameEventWeaponDestroyed;
import com.hiddenswitch.spellsource.client.models.PhysicalAttackEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * GameEvent
 */

public class GameEvent implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isPowerHistory")
  private Boolean isPowerHistory = null;

  /**
   * The game event type corresponding to this game event. 
   */
  public enum EventTypeEnum {
    ALL("ALL"),
    
    AFTER_PHYSICAL_ATTACK("AFTER_PHYSICAL_ATTACK"),
    
    AFTER_PLAY_CARD("AFTER_PLAY_CARD"),
    
    AFTER_SPELL_CASTED("AFTER_SPELL_CASTED"),
    
    AFTER_SUMMON("AFTER_SUMMON"),
    
    ATTRIBUTE_APPLIED("ATTRIBUTE_APPLIED"),
    
    ARMOR_GAINED("ARMOR_GAINED"),
    
    BEFORE_SUMMON("BEFORE_SUMMON"),
    
    BOARD_CHANGED("BOARD_CHANGED"),
    
    CARD_SHUFFLED("CARD_SHUFFLED"),
    
    DAMAGE("DAMAGE"),
    
    DISCARD("DISCARD"),
    
    DRAW_CARD("DRAW_CARD"),
    
    ENRAGE_CHANGED("ENRAGE_CHANGED"),
    
    ENTITY_TOUCHED("ENTITY_TOUCHED"),
    
    ENTITY_UNTOUCHED("ENTITY_UNTOUCHED"),
    
    FATIGUE("FATIGUE"),
    
    GAME_START("GAME_START"),
    
    HEAL("HEAL"),
    
    HERO_POWER_USED("HERO_POWER_USED"),
    
    INVOKED("INVOKED"),
    
    JOUST("JOUST"),
    
    KILL("KILL"),
    
    LOSE_DIVINE_SHIELD("LOSE_DIVINE_SHIELD"),
    
    LOSE_DEFLECT("LOSE_DEFLECT"),
    
    MILL("MILL"),
    
    MAX_MANA("MAX_MANA"),
    
    MANA_MODIFIED("MANA_MODIFIED"),
    
    OVERLOAD("OVERLOAD"),
    
    PERFORMED_GAME_ACTION("PERFORMED_GAME_ACTION"),
    
    PHYSICAL_ATTACK("PHYSICAL_ATTACK"),
    
    PLAY_CARD("PLAY_CARD"),
    
    PRE_DAMAGE("PRE_DAMAGE"),
    
    QUEST_PLAYED("QUEST_PLAYED"),
    
    QUEST_SUCCESSFUL("QUEST_SUCCESSFUL"),
    
    REVEAL_CARD("REVEAL_CARD"),
    
    SECRET_PLAYED("SECRET_PLAYED"),
    
    SECRET_REVEALED("SECRET_REVEALED"),
    
    SPELL_CASTED("SPELL_CASTED"),
    
    SUMMON("SUMMON"),
    
    TARGET_ACQUISITION("TARGET_ACQUISITION"),
    
    TRIGGER_FIRED("TRIGGER_FIRED"),
    
    TURN_END("TURN_END"),
    
    TURN_START("TURN_START"),
    
    SILENCE("SILENCE"),
    
    WEAPON_DESTROYED("WEAPON_DESTROYED"),
    
    WEAPON_EQUIPPED("WEAPON_EQUIPPED"),
    
    WILL_END_SEQUENCE("WILL_END_SEQUENCE");

    private String value;

    EventTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EventTypeEnum fromValue(String text) {
      for (EventTypeEnum b : EventTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("eventType")
  private EventTypeEnum eventType = null;

  @JsonProperty("afterPhysicalAttack")
  private PhysicalAttackEvent afterPhysicalAttack = null;

  @JsonProperty("drawCard")
  private CardEvent drawCard = null;

  @JsonProperty("entityTouched")
  private Integer entityTouched = null;

  @JsonProperty("entityUntouched")
  private Integer entityUntouched = null;

  @JsonProperty("preDamage")
  private GameEventPreDamage preDamage = null;

  @JsonProperty("silence")
  private GameEventSilence silence = null;

  @JsonProperty("secretPlayed")
  private GameEventSecretPlayed secretPlayed = null;

  @JsonProperty("beforeSummon")
  private GameEventBeforeSummon beforeSummon = null;

  @JsonProperty("cardPlayed")
  private CardEvent cardPlayed = null;

  @JsonProperty("armorGained")
  private GameEventArmorGained armorGained = null;

  @JsonProperty("afterSummon")
  private GameEventBeforeSummon afterSummon = null;

  @JsonProperty("spellCasted")
  private CardEvent spellCasted = null;

  @JsonProperty("joust")
  private GameEventJoust joust = null;

  @JsonProperty("weaponDestroyed")
  private GameEventWeaponDestroyed weaponDestroyed = null;

  @JsonProperty("heroPowerUsed")
  private GameEventHeroPowerUsed heroPowerUsed = null;

  @JsonProperty("enrageChanged")
  private GameEventSilence enrageChanged = null;

  @JsonProperty("targetAcquisition")
  private GameEventTargetAcquisition targetAcquisition = null;

  @JsonProperty("damage")
  private GameEventDamage damage = null;

  @JsonProperty("weaponEquipped")
  private GameEventWeaponDestroyed weaponEquipped = null;

  @JsonProperty("performedGameAction")
  private GameEventPerformedGameAction performedGameAction = null;

  @JsonProperty("physicalAttack")
  private PhysicalAttackEvent physicalAttack = null;

  @JsonProperty("overload")
  private GameEventOverload overload = null;

  @JsonProperty("heal")
  private GameEventHeal heal = null;

  @JsonProperty("secretRevealed")
  private GameEventSecretRevealed secretRevealed = null;

  @JsonProperty("questSuccessful")
  private GameEventQuestSuccessful questSuccessful = null;

  @JsonProperty("questPlayed")
  private GameEventQuestSuccessful questPlayed = null;

  @JsonProperty("summon")
  private GameEventBeforeSummon summon = null;

  @JsonProperty("afterSpellCasted")
  private GameEventAfterSpellCasted afterSpellCasted = null;

  @JsonProperty("discard")
  private CardEvent discard = null;

  @JsonProperty("mill")
  private CardEvent mill = null;

  @JsonProperty("kill")
  private GameEventKill kill = null;

  @JsonProperty("fatigue")
  private GameEventFatigue fatigue = null;

  @JsonProperty("triggerFired")
  private GameEventTriggerFired triggerFired = null;

  public GameEvent id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * An integer ID corresponding to the order of this event from the client&#39;s point of view. 
   * @return id
  **/
  @ApiModelProperty(value = "An integer ID corresponding to the order of this event from the client's point of view. ")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GameEvent description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A plaintext description of this event. 
   * @return description
  **/
  @ApiModelProperty(value = "A plaintext description of this event. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GameEvent isPowerHistory(Boolean isPowerHistory) {
    this.isPowerHistory = isPowerHistory;
    return this;
  }

   /**
   * Should this event be rendered in the power history? 
   * @return isPowerHistory
  **/
  @ApiModelProperty(value = "Should this event be rendered in the power history? ")
  public Boolean isIsPowerHistory() {
    return isPowerHistory;
  }

  public void setIsPowerHistory(Boolean isPowerHistory) {
    this.isPowerHistory = isPowerHistory;
  }

  public GameEvent eventType(EventTypeEnum eventType) {
    this.eventType = eventType;
    return this;
  }

   /**
   * The game event type corresponding to this game event. 
   * @return eventType
  **/
  @ApiModelProperty(value = "The game event type corresponding to this game event. ")
  public EventTypeEnum getEventType() {
    return eventType;
  }

  public void setEventType(EventTypeEnum eventType) {
    this.eventType = eventType;
  }

  public GameEvent afterPhysicalAttack(PhysicalAttackEvent afterPhysicalAttack) {
    this.afterPhysicalAttack = afterPhysicalAttack;
    return this;
  }

   /**
   * Get afterPhysicalAttack
   * @return afterPhysicalAttack
  **/
  @ApiModelProperty(value = "")
  public PhysicalAttackEvent getAfterPhysicalAttack() {
    return afterPhysicalAttack;
  }

  public void setAfterPhysicalAttack(PhysicalAttackEvent afterPhysicalAttack) {
    this.afterPhysicalAttack = afterPhysicalAttack;
  }

  public GameEvent drawCard(CardEvent drawCard) {
    this.drawCard = drawCard;
    return this;
  }

   /**
   * Get drawCard
   * @return drawCard
  **/
  @ApiModelProperty(value = "")
  public CardEvent getDrawCard() {
    return drawCard;
  }

  public void setDrawCard(CardEvent drawCard) {
    this.drawCard = drawCard;
  }

  public GameEvent entityTouched(Integer entityTouched) {
    this.entityTouched = entityTouched;
    return this;
  }

   /**
   * Get entityTouched
   * @return entityTouched
  **/
  @ApiModelProperty(value = "")
  public Integer getEntityTouched() {
    return entityTouched;
  }

  public void setEntityTouched(Integer entityTouched) {
    this.entityTouched = entityTouched;
  }

  public GameEvent entityUntouched(Integer entityUntouched) {
    this.entityUntouched = entityUntouched;
    return this;
  }

   /**
   * Get entityUntouched
   * @return entityUntouched
  **/
  @ApiModelProperty(value = "")
  public Integer getEntityUntouched() {
    return entityUntouched;
  }

  public void setEntityUntouched(Integer entityUntouched) {
    this.entityUntouched = entityUntouched;
  }

  public GameEvent preDamage(GameEventPreDamage preDamage) {
    this.preDamage = preDamage;
    return this;
  }

   /**
   * Get preDamage
   * @return preDamage
  **/
  @ApiModelProperty(value = "")
  public GameEventPreDamage getPreDamage() {
    return preDamage;
  }

  public void setPreDamage(GameEventPreDamage preDamage) {
    this.preDamage = preDamage;
  }

  public GameEvent silence(GameEventSilence silence) {
    this.silence = silence;
    return this;
  }

   /**
   * Get silence
   * @return silence
  **/
  @ApiModelProperty(value = "")
  public GameEventSilence getSilence() {
    return silence;
  }

  public void setSilence(GameEventSilence silence) {
    this.silence = silence;
  }

  public GameEvent secretPlayed(GameEventSecretPlayed secretPlayed) {
    this.secretPlayed = secretPlayed;
    return this;
  }

   /**
   * Get secretPlayed
   * @return secretPlayed
  **/
  @ApiModelProperty(value = "")
  public GameEventSecretPlayed getSecretPlayed() {
    return secretPlayed;
  }

  public void setSecretPlayed(GameEventSecretPlayed secretPlayed) {
    this.secretPlayed = secretPlayed;
  }

  public GameEvent beforeSummon(GameEventBeforeSummon beforeSummon) {
    this.beforeSummon = beforeSummon;
    return this;
  }

   /**
   * Get beforeSummon
   * @return beforeSummon
  **/
  @ApiModelProperty(value = "")
  public GameEventBeforeSummon getBeforeSummon() {
    return beforeSummon;
  }

  public void setBeforeSummon(GameEventBeforeSummon beforeSummon) {
    this.beforeSummon = beforeSummon;
  }

  public GameEvent cardPlayed(CardEvent cardPlayed) {
    this.cardPlayed = cardPlayed;
    return this;
  }

   /**
   * Get cardPlayed
   * @return cardPlayed
  **/
  @ApiModelProperty(value = "")
  public CardEvent getCardPlayed() {
    return cardPlayed;
  }

  public void setCardPlayed(CardEvent cardPlayed) {
    this.cardPlayed = cardPlayed;
  }

  public GameEvent armorGained(GameEventArmorGained armorGained) {
    this.armorGained = armorGained;
    return this;
  }

   /**
   * Get armorGained
   * @return armorGained
  **/
  @ApiModelProperty(value = "")
  public GameEventArmorGained getArmorGained() {
    return armorGained;
  }

  public void setArmorGained(GameEventArmorGained armorGained) {
    this.armorGained = armorGained;
  }

  public GameEvent afterSummon(GameEventBeforeSummon afterSummon) {
    this.afterSummon = afterSummon;
    return this;
  }

   /**
   * Get afterSummon
   * @return afterSummon
  **/
  @ApiModelProperty(value = "")
  public GameEventBeforeSummon getAfterSummon() {
    return afterSummon;
  }

  public void setAfterSummon(GameEventBeforeSummon afterSummon) {
    this.afterSummon = afterSummon;
  }

  public GameEvent spellCasted(CardEvent spellCasted) {
    this.spellCasted = spellCasted;
    return this;
  }

   /**
   * Get spellCasted
   * @return spellCasted
  **/
  @ApiModelProperty(value = "")
  public CardEvent getSpellCasted() {
    return spellCasted;
  }

  public void setSpellCasted(CardEvent spellCasted) {
    this.spellCasted = spellCasted;
  }

  public GameEvent joust(GameEventJoust joust) {
    this.joust = joust;
    return this;
  }

   /**
   * Get joust
   * @return joust
  **/
  @ApiModelProperty(value = "")
  public GameEventJoust getJoust() {
    return joust;
  }

  public void setJoust(GameEventJoust joust) {
    this.joust = joust;
  }

  public GameEvent weaponDestroyed(GameEventWeaponDestroyed weaponDestroyed) {
    this.weaponDestroyed = weaponDestroyed;
    return this;
  }

   /**
   * Get weaponDestroyed
   * @return weaponDestroyed
  **/
  @ApiModelProperty(value = "")
  public GameEventWeaponDestroyed getWeaponDestroyed() {
    return weaponDestroyed;
  }

  public void setWeaponDestroyed(GameEventWeaponDestroyed weaponDestroyed) {
    this.weaponDestroyed = weaponDestroyed;
  }

  public GameEvent heroPowerUsed(GameEventHeroPowerUsed heroPowerUsed) {
    this.heroPowerUsed = heroPowerUsed;
    return this;
  }

   /**
   * Get heroPowerUsed
   * @return heroPowerUsed
  **/
  @ApiModelProperty(value = "")
  public GameEventHeroPowerUsed getHeroPowerUsed() {
    return heroPowerUsed;
  }

  public void setHeroPowerUsed(GameEventHeroPowerUsed heroPowerUsed) {
    this.heroPowerUsed = heroPowerUsed;
  }

  public GameEvent enrageChanged(GameEventSilence enrageChanged) {
    this.enrageChanged = enrageChanged;
    return this;
  }

   /**
   * Get enrageChanged
   * @return enrageChanged
  **/
  @ApiModelProperty(value = "")
  public GameEventSilence getEnrageChanged() {
    return enrageChanged;
  }

  public void setEnrageChanged(GameEventSilence enrageChanged) {
    this.enrageChanged = enrageChanged;
  }

  public GameEvent targetAcquisition(GameEventTargetAcquisition targetAcquisition) {
    this.targetAcquisition = targetAcquisition;
    return this;
  }

   /**
   * Get targetAcquisition
   * @return targetAcquisition
  **/
  @ApiModelProperty(value = "")
  public GameEventTargetAcquisition getTargetAcquisition() {
    return targetAcquisition;
  }

  public void setTargetAcquisition(GameEventTargetAcquisition targetAcquisition) {
    this.targetAcquisition = targetAcquisition;
  }

  public GameEvent damage(GameEventDamage damage) {
    this.damage = damage;
    return this;
  }

   /**
   * Get damage
   * @return damage
  **/
  @ApiModelProperty(value = "")
  public GameEventDamage getDamage() {
    return damage;
  }

  public void setDamage(GameEventDamage damage) {
    this.damage = damage;
  }

  public GameEvent weaponEquipped(GameEventWeaponDestroyed weaponEquipped) {
    this.weaponEquipped = weaponEquipped;
    return this;
  }

   /**
   * Get weaponEquipped
   * @return weaponEquipped
  **/
  @ApiModelProperty(value = "")
  public GameEventWeaponDestroyed getWeaponEquipped() {
    return weaponEquipped;
  }

  public void setWeaponEquipped(GameEventWeaponDestroyed weaponEquipped) {
    this.weaponEquipped = weaponEquipped;
  }

  public GameEvent performedGameAction(GameEventPerformedGameAction performedGameAction) {
    this.performedGameAction = performedGameAction;
    return this;
  }

   /**
   * Get performedGameAction
   * @return performedGameAction
  **/
  @ApiModelProperty(value = "")
  public GameEventPerformedGameAction getPerformedGameAction() {
    return performedGameAction;
  }

  public void setPerformedGameAction(GameEventPerformedGameAction performedGameAction) {
    this.performedGameAction = performedGameAction;
  }

  public GameEvent physicalAttack(PhysicalAttackEvent physicalAttack) {
    this.physicalAttack = physicalAttack;
    return this;
  }

   /**
   * Get physicalAttack
   * @return physicalAttack
  **/
  @ApiModelProperty(value = "")
  public PhysicalAttackEvent getPhysicalAttack() {
    return physicalAttack;
  }

  public void setPhysicalAttack(PhysicalAttackEvent physicalAttack) {
    this.physicalAttack = physicalAttack;
  }

  public GameEvent overload(GameEventOverload overload) {
    this.overload = overload;
    return this;
  }

   /**
   * Get overload
   * @return overload
  **/
  @ApiModelProperty(value = "")
  public GameEventOverload getOverload() {
    return overload;
  }

  public void setOverload(GameEventOverload overload) {
    this.overload = overload;
  }

  public GameEvent heal(GameEventHeal heal) {
    this.heal = heal;
    return this;
  }

   /**
   * Get heal
   * @return heal
  **/
  @ApiModelProperty(value = "")
  public GameEventHeal getHeal() {
    return heal;
  }

  public void setHeal(GameEventHeal heal) {
    this.heal = heal;
  }

  public GameEvent secretRevealed(GameEventSecretRevealed secretRevealed) {
    this.secretRevealed = secretRevealed;
    return this;
  }

   /**
   * Get secretRevealed
   * @return secretRevealed
  **/
  @ApiModelProperty(value = "")
  public GameEventSecretRevealed getSecretRevealed() {
    return secretRevealed;
  }

  public void setSecretRevealed(GameEventSecretRevealed secretRevealed) {
    this.secretRevealed = secretRevealed;
  }

  public GameEvent questSuccessful(GameEventQuestSuccessful questSuccessful) {
    this.questSuccessful = questSuccessful;
    return this;
  }

   /**
   * Get questSuccessful
   * @return questSuccessful
  **/
  @ApiModelProperty(value = "")
  public GameEventQuestSuccessful getQuestSuccessful() {
    return questSuccessful;
  }

  public void setQuestSuccessful(GameEventQuestSuccessful questSuccessful) {
    this.questSuccessful = questSuccessful;
  }

  public GameEvent questPlayed(GameEventQuestSuccessful questPlayed) {
    this.questPlayed = questPlayed;
    return this;
  }

   /**
   * Get questPlayed
   * @return questPlayed
  **/
  @ApiModelProperty(value = "")
  public GameEventQuestSuccessful getQuestPlayed() {
    return questPlayed;
  }

  public void setQuestPlayed(GameEventQuestSuccessful questPlayed) {
    this.questPlayed = questPlayed;
  }

  public GameEvent summon(GameEventBeforeSummon summon) {
    this.summon = summon;
    return this;
  }

   /**
   * Get summon
   * @return summon
  **/
  @ApiModelProperty(value = "")
  public GameEventBeforeSummon getSummon() {
    return summon;
  }

  public void setSummon(GameEventBeforeSummon summon) {
    this.summon = summon;
  }

  public GameEvent afterSpellCasted(GameEventAfterSpellCasted afterSpellCasted) {
    this.afterSpellCasted = afterSpellCasted;
    return this;
  }

   /**
   * Get afterSpellCasted
   * @return afterSpellCasted
  **/
  @ApiModelProperty(value = "")
  public GameEventAfterSpellCasted getAfterSpellCasted() {
    return afterSpellCasted;
  }

  public void setAfterSpellCasted(GameEventAfterSpellCasted afterSpellCasted) {
    this.afterSpellCasted = afterSpellCasted;
  }

  public GameEvent discard(CardEvent discard) {
    this.discard = discard;
    return this;
  }

   /**
   * Get discard
   * @return discard
  **/
  @ApiModelProperty(value = "")
  public CardEvent getDiscard() {
    return discard;
  }

  public void setDiscard(CardEvent discard) {
    this.discard = discard;
  }

  public GameEvent mill(CardEvent mill) {
    this.mill = mill;
    return this;
  }

   /**
   * Get mill
   * @return mill
  **/
  @ApiModelProperty(value = "")
  public CardEvent getMill() {
    return mill;
  }

  public void setMill(CardEvent mill) {
    this.mill = mill;
  }

  public GameEvent kill(GameEventKill kill) {
    this.kill = kill;
    return this;
  }

   /**
   * Get kill
   * @return kill
  **/
  @ApiModelProperty(value = "")
  public GameEventKill getKill() {
    return kill;
  }

  public void setKill(GameEventKill kill) {
    this.kill = kill;
  }

  public GameEvent fatigue(GameEventFatigue fatigue) {
    this.fatigue = fatigue;
    return this;
  }

   /**
   * Get fatigue
   * @return fatigue
  **/
  @ApiModelProperty(value = "")
  public GameEventFatigue getFatigue() {
    return fatigue;
  }

  public void setFatigue(GameEventFatigue fatigue) {
    this.fatigue = fatigue;
  }

  public GameEvent triggerFired(GameEventTriggerFired triggerFired) {
    this.triggerFired = triggerFired;
    return this;
  }

   /**
   * Get triggerFired
   * @return triggerFired
  **/
  @ApiModelProperty(value = "")
  public GameEventTriggerFired getTriggerFired() {
    return triggerFired;
  }

  public void setTriggerFired(GameEventTriggerFired triggerFired) {
    this.triggerFired = triggerFired;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameEvent gameEvent = (GameEvent) o;
    return Objects.equals(this.id, gameEvent.id) &&
        Objects.equals(this.description, gameEvent.description) &&
        Objects.equals(this.isPowerHistory, gameEvent.isPowerHistory) &&
        Objects.equals(this.eventType, gameEvent.eventType) &&
        Objects.equals(this.afterPhysicalAttack, gameEvent.afterPhysicalAttack) &&
        Objects.equals(this.drawCard, gameEvent.drawCard) &&
        Objects.equals(this.entityTouched, gameEvent.entityTouched) &&
        Objects.equals(this.entityUntouched, gameEvent.entityUntouched) &&
        Objects.equals(this.preDamage, gameEvent.preDamage) &&
        Objects.equals(this.silence, gameEvent.silence) &&
        Objects.equals(this.secretPlayed, gameEvent.secretPlayed) &&
        Objects.equals(this.beforeSummon, gameEvent.beforeSummon) &&
        Objects.equals(this.cardPlayed, gameEvent.cardPlayed) &&
        Objects.equals(this.armorGained, gameEvent.armorGained) &&
        Objects.equals(this.afterSummon, gameEvent.afterSummon) &&
        Objects.equals(this.spellCasted, gameEvent.spellCasted) &&
        Objects.equals(this.joust, gameEvent.joust) &&
        Objects.equals(this.weaponDestroyed, gameEvent.weaponDestroyed) &&
        Objects.equals(this.heroPowerUsed, gameEvent.heroPowerUsed) &&
        Objects.equals(this.enrageChanged, gameEvent.enrageChanged) &&
        Objects.equals(this.targetAcquisition, gameEvent.targetAcquisition) &&
        Objects.equals(this.damage, gameEvent.damage) &&
        Objects.equals(this.weaponEquipped, gameEvent.weaponEquipped) &&
        Objects.equals(this.performedGameAction, gameEvent.performedGameAction) &&
        Objects.equals(this.physicalAttack, gameEvent.physicalAttack) &&
        Objects.equals(this.overload, gameEvent.overload) &&
        Objects.equals(this.heal, gameEvent.heal) &&
        Objects.equals(this.secretRevealed, gameEvent.secretRevealed) &&
        Objects.equals(this.questSuccessful, gameEvent.questSuccessful) &&
        Objects.equals(this.questPlayed, gameEvent.questPlayed) &&
        Objects.equals(this.summon, gameEvent.summon) &&
        Objects.equals(this.afterSpellCasted, gameEvent.afterSpellCasted) &&
        Objects.equals(this.discard, gameEvent.discard) &&
        Objects.equals(this.mill, gameEvent.mill) &&
        Objects.equals(this.kill, gameEvent.kill) &&
        Objects.equals(this.fatigue, gameEvent.fatigue) &&
        Objects.equals(this.triggerFired, gameEvent.triggerFired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, isPowerHistory, eventType, afterPhysicalAttack, drawCard, entityTouched, entityUntouched, preDamage, silence, secretPlayed, beforeSummon, cardPlayed, armorGained, afterSummon, spellCasted, joust, weaponDestroyed, heroPowerUsed, enrageChanged, targetAcquisition, damage, weaponEquipped, performedGameAction, physicalAttack, overload, heal, secretRevealed, questSuccessful, questPlayed, summon, afterSpellCasted, discard, mill, kill, fatigue, triggerFired);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameEvent {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isPowerHistory: ").append(toIndentedString(isPowerHistory)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    afterPhysicalAttack: ").append(toIndentedString(afterPhysicalAttack)).append("\n");
    sb.append("    drawCard: ").append(toIndentedString(drawCard)).append("\n");
    sb.append("    entityTouched: ").append(toIndentedString(entityTouched)).append("\n");
    sb.append("    entityUntouched: ").append(toIndentedString(entityUntouched)).append("\n");
    sb.append("    preDamage: ").append(toIndentedString(preDamage)).append("\n");
    sb.append("    silence: ").append(toIndentedString(silence)).append("\n");
    sb.append("    secretPlayed: ").append(toIndentedString(secretPlayed)).append("\n");
    sb.append("    beforeSummon: ").append(toIndentedString(beforeSummon)).append("\n");
    sb.append("    cardPlayed: ").append(toIndentedString(cardPlayed)).append("\n");
    sb.append("    armorGained: ").append(toIndentedString(armorGained)).append("\n");
    sb.append("    afterSummon: ").append(toIndentedString(afterSummon)).append("\n");
    sb.append("    spellCasted: ").append(toIndentedString(spellCasted)).append("\n");
    sb.append("    joust: ").append(toIndentedString(joust)).append("\n");
    sb.append("    weaponDestroyed: ").append(toIndentedString(weaponDestroyed)).append("\n");
    sb.append("    heroPowerUsed: ").append(toIndentedString(heroPowerUsed)).append("\n");
    sb.append("    enrageChanged: ").append(toIndentedString(enrageChanged)).append("\n");
    sb.append("    targetAcquisition: ").append(toIndentedString(targetAcquisition)).append("\n");
    sb.append("    damage: ").append(toIndentedString(damage)).append("\n");
    sb.append("    weaponEquipped: ").append(toIndentedString(weaponEquipped)).append("\n");
    sb.append("    performedGameAction: ").append(toIndentedString(performedGameAction)).append("\n");
    sb.append("    physicalAttack: ").append(toIndentedString(physicalAttack)).append("\n");
    sb.append("    overload: ").append(toIndentedString(overload)).append("\n");
    sb.append("    heal: ").append(toIndentedString(heal)).append("\n");
    sb.append("    secretRevealed: ").append(toIndentedString(secretRevealed)).append("\n");
    sb.append("    questSuccessful: ").append(toIndentedString(questSuccessful)).append("\n");
    sb.append("    questPlayed: ").append(toIndentedString(questPlayed)).append("\n");
    sb.append("    summon: ").append(toIndentedString(summon)).append("\n");
    sb.append("    afterSpellCasted: ").append(toIndentedString(afterSpellCasted)).append("\n");
    sb.append("    discard: ").append(toIndentedString(discard)).append("\n");
    sb.append("    mill: ").append(toIndentedString(mill)).append("\n");
    sb.append("    kill: ").append(toIndentedString(kill)).append("\n");
    sb.append("    fatigue: ").append(toIndentedString(fatigue)).append("\n");
    sb.append("    triggerFired: ").append(toIndentedString(triggerFired)).append("\n");
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


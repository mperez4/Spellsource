/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.spellsource.tables.daos;


import com.hiddenswitch.framework.schema.spellsource.tables.Cards;
import com.hiddenswitch.framework.schema.spellsource.tables.records.CardsRecord;

import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;
import io.vertx.core.json.JsonObject;

import java.time.OffsetDateTime;
import java.util.Collection;

import org.jooq.Configuration;
import org.jooq.XML;


import java.util.List;
import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.reactivepg.ReactiveClassicQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CardsDao extends AbstractReactiveVertxDAO<CardsRecord, com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards, String, Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>>, Future<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>, Future<Integer>, Future<String>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<CardsRecord,com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards,String> {

        /**
     * @param configuration Used for rendering, so only SQLDialect must be set
     * and must be one of the POSTGREs types.
     * @param delegate A configured AsyncSQLClient that is used for query
     * execution
     */
        public CardsDao(Configuration configuration, io.vertx.sqlclient.SqlClient delegate) {
                super(Cards.CARDS, com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards.class, new ReactiveClassicQueryExecutor<CardsRecord,com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards,String>(configuration,delegate,com.hiddenswitch.framework.schema.spellsource.tables.mappers.RowMappers.getCardsMapper()));
        }

        @Override
        protected String getId(com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards object) {
                return object.getId();
        }

        /**
     * Find records that have <code>created_by IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByCreatedBy(Collection<String> values) {
                return findManyByCondition(Cards.CARDS.CREATED_BY.in(values));
        }

        /**
     * Find records that have <code>created_by IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByCreatedBy(Collection<String> values, int limit) {
                return findManyByCondition(Cards.CARDS.CREATED_BY.in(values),limit);
        }

        /**
     * Find records that have <code>uri IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByUri(Collection<String> values) {
                return findManyByCondition(Cards.CARDS.URI.in(values));
        }

        /**
     * Find records that have <code>uri IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByUri(Collection<String> values, int limit) {
                return findManyByCondition(Cards.CARDS.URI.in(values),limit);
        }

        /**
     * Find records that have <code>blockly_workspace IN (values)</code>
     * asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByBlocklyWorkspace(Collection<XML> values) {
                return findManyByCondition(Cards.CARDS.BLOCKLY_WORKSPACE.in(values));
        }

        /**
     * Find records that have <code>blockly_workspace IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByBlocklyWorkspace(Collection<XML> values, int limit) {
                return findManyByCondition(Cards.CARDS.BLOCKLY_WORKSPACE.in(values),limit);
        }

        /**
     * Find records that have <code>card_script IN (values)</code>
     * asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByCardScript(Collection<JsonObject> values) {
                return findManyByCondition(Cards.CARDS.CARD_SCRIPT.in(values));
        }

        /**
     * Find records that have <code>card_script IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByCardScript(Collection<JsonObject> values, int limit) {
                return findManyByCondition(Cards.CARDS.CARD_SCRIPT.in(values),limit);
        }

        /**
     * Find records that have <code>created_at IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByCreatedAt(Collection<OffsetDateTime> values) {
                return findManyByCondition(Cards.CARDS.CREATED_AT.in(values));
        }

        /**
     * Find records that have <code>created_at IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByCreatedAt(Collection<OffsetDateTime> values, int limit) {
                return findManyByCondition(Cards.CARDS.CREATED_AT.in(values),limit);
        }

        /**
     * Find records that have <code>last_modified IN (values)</code>
     * asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByLastModified(Collection<OffsetDateTime> values) {
                return findManyByCondition(Cards.CARDS.LAST_MODIFIED.in(values));
        }

        /**
     * Find records that have <code>last_modified IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards>> findManyByLastModified(Collection<OffsetDateTime> values, int limit) {
                return findManyByCondition(Cards.CARDS.LAST_MODIFIED.in(values),limit);
        }

        @Override
        public ReactiveClassicQueryExecutor<CardsRecord,com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards,String> queryExecutor(){
                return (ReactiveClassicQueryExecutor<CardsRecord,com.hiddenswitch.framework.schema.spellsource.tables.pojos.Cards,String>) super.queryExecutor();
        }
}

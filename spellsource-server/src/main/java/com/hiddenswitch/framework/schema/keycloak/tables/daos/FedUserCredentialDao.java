/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.daos;


import com.hiddenswitch.framework.schema.keycloak.tables.FedUserCredential;
import com.hiddenswitch.framework.schema.keycloak.tables.records.FedUserCredentialRecord;

import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;

import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.reactivepg.ReactiveClassicQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FedUserCredentialDao extends AbstractReactiveVertxDAO<FedUserCredentialRecord, com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential, String, Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>>, Future<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>, Future<Integer>, Future<String>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<FedUserCredentialRecord,com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential,String> {

        /**
     * @param configuration Used for rendering, so only SQLDialect must be set
     * and must be one of the POSTGREs types.
     * @param delegate A configured AsyncSQLClient that is used for query
     * execution
     */
        public FedUserCredentialDao(Configuration configuration, io.vertx.sqlclient.SqlClient delegate) {
                super(FedUserCredential.FED_USER_CREDENTIAL, com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential.class, new ReactiveClassicQueryExecutor<FedUserCredentialRecord,com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential,String>(configuration,delegate,com.hiddenswitch.framework.schema.keycloak.tables.mappers.RowMappers.getFedUserCredentialMapper()));
        }

        @Override
        protected String getId(com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential object) {
                return object.getId();
        }

        /**
     * Find records that have <code>device IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByDevice(Collection<String> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.DEVICE.in(values));
        }

        /**
     * Find records that have <code>device IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByDevice(Collection<String> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.DEVICE.in(values),limit);
        }

        /**
     * Find records that have <code>hash_iterations IN (values)</code>
     * asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByHashIterations(Collection<Integer> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.HASH_ITERATIONS.in(values));
        }

        /**
     * Find records that have <code>hash_iterations IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByHashIterations(Collection<Integer> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.HASH_ITERATIONS.in(values),limit);
        }

        /**
     * Find records that have <code>salt IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyBySalt(Collection<byte[]> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.SALT.in(values));
        }

        /**
     * Find records that have <code>salt IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyBySalt(Collection<byte[]> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.SALT.in(values),limit);
        }

        /**
     * Find records that have <code>type IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByType(Collection<String> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.TYPE.in(values));
        }

        /**
     * Find records that have <code>type IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByType(Collection<String> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.TYPE.in(values),limit);
        }

        /**
     * Find records that have <code>value IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByValue(Collection<String> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.VALUE.in(values));
        }

        /**
     * Find records that have <code>value IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByValue(Collection<String> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.VALUE.in(values),limit);
        }

        /**
     * Find records that have <code>created_date IN (values)</code>
     * asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByCreatedDate(Collection<Long> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.CREATED_DATE.in(values));
        }

        /**
     * Find records that have <code>created_date IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByCreatedDate(Collection<Long> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.CREATED_DATE.in(values),limit);
        }

        /**
     * Find records that have <code>counter IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByCounter(Collection<Integer> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.COUNTER.in(values));
        }

        /**
     * Find records that have <code>counter IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByCounter(Collection<Integer> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.COUNTER.in(values),limit);
        }

        /**
     * Find records that have <code>digits IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByDigits(Collection<Integer> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.DIGITS.in(values));
        }

        /**
     * Find records that have <code>digits IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByDigits(Collection<Integer> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.DIGITS.in(values),limit);
        }

        /**
     * Find records that have <code>period IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByPeriod(Collection<Integer> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.PERIOD.in(values));
        }

        /**
     * Find records that have <code>period IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByPeriod(Collection<Integer> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.PERIOD.in(values),limit);
        }

        /**
     * Find records that have <code>algorithm IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByAlgorithm(Collection<String> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.ALGORITHM.in(values));
        }

        /**
     * Find records that have <code>algorithm IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByAlgorithm(Collection<String> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.ALGORITHM.in(values),limit);
        }

        /**
     * Find records that have <code>user_id IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByUserId(Collection<String> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.USER_ID.in(values));
        }

        /**
     * Find records that have <code>user_id IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByUserId(Collection<String> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.USER_ID.in(values),limit);
        }

        /**
     * Find records that have <code>realm_id IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByRealmId(Collection<String> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.REALM_ID.in(values));
        }

        /**
     * Find records that have <code>realm_id IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByRealmId(Collection<String> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.REALM_ID.in(values),limit);
        }

        /**
     * Find records that have <code>storage_provider_id IN (values)</code>
     * asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByStorageProviderId(Collection<String> values) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.STORAGE_PROVIDER_ID.in(values));
        }

        /**
     * Find records that have <code>storage_provider_id IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential>> findManyByStorageProviderId(Collection<String> values, int limit) {
                return findManyByCondition(FedUserCredential.FED_USER_CREDENTIAL.STORAGE_PROVIDER_ID.in(values),limit);
        }

        @Override
        public ReactiveClassicQueryExecutor<FedUserCredentialRecord,com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential,String> queryExecutor(){
                return (ReactiveClassicQueryExecutor<FedUserCredentialRecord,com.hiddenswitch.framework.schema.keycloak.tables.pojos.FedUserCredential,String>) super.queryExecutor();
        }
}

/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.keycloak.tables.daos;


import com.hiddenswitch.framework.schema.keycloak.tables.TemplateScopeMapping;
import com.hiddenswitch.framework.schema.keycloak.tables.records.TemplateScopeMappingRecord;

import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;

import java.util.Collection;

import org.jooq.Configuration;
import org.jooq.Record2;


import java.util.List;
import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.reactivepg.ReactiveClassicQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TemplateScopeMappingDao extends AbstractReactiveVertxDAO<TemplateScopeMappingRecord, com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping, Record2<String, String>, Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping>>, Future<com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping>, Future<Integer>, Future<Record2<String, String>>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<TemplateScopeMappingRecord,com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping,Record2<String, String>> {

        /**
     * @param configuration Used for rendering, so only SQLDialect must be set
     * and must be one of the POSTGREs types.
     * @param delegate A configured AsyncSQLClient that is used for query
     * execution
     */
        public TemplateScopeMappingDao(Configuration configuration, io.vertx.sqlclient.SqlClient delegate) {
                super(TemplateScopeMapping.TEMPLATE_SCOPE_MAPPING, com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping.class, new ReactiveClassicQueryExecutor<TemplateScopeMappingRecord,com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping,Record2<String, String>>(configuration,delegate,com.hiddenswitch.framework.schema.keycloak.tables.mappers.RowMappers.getTemplateScopeMappingMapper()));
        }

        @Override
        protected Record2<String, String> getId(com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping object) {
                return compositeKeyRecord(object.getTemplateId(), object.getRoleId());
        }

        /**
     * Find records that have <code>role_id IN (values)</code> asynchronously
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping>> findManyByRoleId(Collection<String> values) {
                return findManyByCondition(TemplateScopeMapping.TEMPLATE_SCOPE_MAPPING.ROLE_ID.in(values));
        }

        /**
     * Find records that have <code>role_id IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping>> findManyByRoleId(Collection<String> values, int limit) {
                return findManyByCondition(TemplateScopeMapping.TEMPLATE_SCOPE_MAPPING.ROLE_ID.in(values),limit);
        }

        @Override
        public ReactiveClassicQueryExecutor<TemplateScopeMappingRecord,com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping,Record2<String, String>> queryExecutor(){
                return (ReactiveClassicQueryExecutor<TemplateScopeMappingRecord,com.hiddenswitch.framework.schema.keycloak.tables.pojos.TemplateScopeMapping,Record2<String, String>>) super.queryExecutor();
        }
}

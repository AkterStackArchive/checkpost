package io.checkpost

import org.neo4j.ogm.session.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement


@Configuration
@EnableNeo4jRepositories(basePackages = "io.checkpost")
@EnableTransactionManagement
class AppConf {

    @Bean
    SessionFactory sessionFactory() {
        return new SessionFactory("io.checkpost")
    }

    @Bean
    Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory())
    }

}

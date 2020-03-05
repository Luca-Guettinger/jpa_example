package net.myplayplanet.jpatest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
        "net.myplayplanet.jpatest.model"
})
@Transactional
public class PersistenceContext {
    @javax.persistence.PersistenceContext
    EntityManager entityManager;

    public EntityManager entityManager() {
        return this.entityManager;
    }
}

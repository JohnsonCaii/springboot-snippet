package com.snippet.multiple.datasource.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "marketInfoEntityManagerFactory",
        transactionManagerRef = "marketInfoTransactionManager",
        basePackages = {"com.snippet.multiple.datasource.repository.market.repo"})
public class MarketInfoDataSourceConfig extends CommonDataSourceConfig {

    @Bean(name = "marketInfoDataSource")
    @ConfigurationProperties(prefix = "market_info.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "marketInfoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("marketInfoDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.snippet.multiple.datasource.repository.market.model")
                .properties(super.props)
                .persistenceUnit("Market Info DataSource")
                .build();
    }

    @Bean(name = "marketInfoTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("marketInfoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
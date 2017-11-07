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
        entityManagerFactoryRef = "orderInfoEntityManagerFactory",
        transactionManagerRef = "orderInfoTransactionManager",
        basePackages = {"com.snippet.multiple.datasource.repository.order.repo"})
public class OrderInfoDataSourceConfig extends CommonDataSourceConfig {

    @Bean(name = "orderInfoDataSource")
    @ConfigurationProperties(prefix = "order_info.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "orderInfoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("orderInfoDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.snippet.multiple.datasource.repository.order.model")
                .properties(super.props)
                .persistenceUnit("OrderInfo DataSource")
                .build();
    }

    @Bean(name = "orderInfoTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("orderInfoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
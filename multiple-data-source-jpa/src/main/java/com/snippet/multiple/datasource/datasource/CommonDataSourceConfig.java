package com.snippet.multiple.datasource.datasource;

import com.google.common.collect.ImmutableMap;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.util.Map;

/**
 * Created by johnson on 4/20/17.
 */
public class CommonDataSourceConfig {

    protected Map<String, Object> props = new ImmutableMap.Builder<String, Object>()
            .put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName())
            .put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName())
            // .put("hibernate.dialect", MySQL5InnoDBDialect.class.getName())
            .build();
}

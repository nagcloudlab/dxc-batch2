package org.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class DataSourceConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("datasource.driver.class"));
        dataSource.setUrl(environment.getProperty("datasource.url"));
        dataSource.setUsername(environment.getProperty("datasource.user"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        dataSource.setMaxActive(15);
        dataSource.setMaxIdle(2);
        dataSource.setMaxWait(60);
        return dataSource;
    }

}

package org.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "db.properties")
public class DataSourceConfiguration {

    @Autowired
    Environment environment;

    @Bean
    @Scope("singleton")
    public DataSource dataSource(
            @Value("${db.driver.class}") String driverClass,
            @Value("#{environment['db.url']}") String url,
            @Value("${db.user}") String user,
            @Value("${db.password}") String password,
            @Value("#{systemProperties['os.name']}") String os
    ) {
        System.out.println("dataSource()");
        System.out.println(os);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driver.class"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.user"));
        dataSource.setPassword(environment.getProperty("db.password"));
        dataSource.setMaxActive(15);
        dataSource.setMaxIdle(2);
        dataSource.setMaxWait(60);
        return dataSource;
    }

}

package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({
        DataSourceConfiguration.class
})
@ComponentScan(basePackages = {"org.example"})
@EnableTransactionManagement
public class TransferServiceConfiguration {


}

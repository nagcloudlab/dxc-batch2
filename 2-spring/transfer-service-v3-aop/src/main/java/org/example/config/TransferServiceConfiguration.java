package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        DataSourceConfiguration.class
})
@ComponentScan(basePackages = {"org.example"})
@EnableAspectJAutoProxy
public class TransferServiceConfiguration {


}

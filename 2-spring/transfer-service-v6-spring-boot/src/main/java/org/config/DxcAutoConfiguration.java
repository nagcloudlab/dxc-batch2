package org.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "app", value = "company")
public class DxcAutoConfiguration {

    @Bean
    public String dxc() {
        return "DXC";
    }

}

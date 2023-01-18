package org.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class DxcAutoConfiguration {

    @Bean
    public String dxc() {
        return "DXC";
    }

}

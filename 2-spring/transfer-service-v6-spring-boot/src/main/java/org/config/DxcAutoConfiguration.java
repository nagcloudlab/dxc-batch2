package org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DxcConfiguration {

    @Bean
    public String dxc() {
        return "DXC";
    }

}

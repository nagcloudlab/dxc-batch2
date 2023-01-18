package org.example;

import org.example.service.TransferService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//
@Configuration
@EnableAutoConfiguration
@ComponentScan
//@SpringBootApplication
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {

        // init/booting phase
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);
        System.out.println();


        String dxcBean = applicationContext.getBean("dxc", String.class);
        System.out.println(dxcBean);


//        TransferService transferService = applicationContext.getBean(TransferService.class);
//        System.out.println(transferService.getClass());
//        transferService.transfer(100.00, "1", "2");
//        System.out.println();
        applicationContext.close();

    }
}

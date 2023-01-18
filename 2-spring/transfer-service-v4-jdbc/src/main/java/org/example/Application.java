package org.example;

import org.example.config.TransferServiceConfiguration;
import org.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // init/booting phase
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);
        System.out.println();
        TransferService transferService = applicationContext.getBean(TransferService.class);
        System.out.println(transferService.getClass());
        transferService.transfer(100.00, "1", "2");
        System.out.println();
        applicationContext.close();

    }
}

package org.example;

import org.example.config.TransferServiceConfiguration;
import org.example.repository.AccountRepository;
import org.example.repository.JdbcAccountRepository;
import org.example.repository.JpaAccountRepository;
import org.example.service.TransferService;
import org.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    public static void main(String[] args) {

        //----------------------------------------------------------
        // init / boot phase
        //----------------------------------------------------------
        logger.info("-".repeat(50));

        ConfigurableApplicationContext applicationContext =
                // new ClassPathXmlApplicationContext("transfer-service.xml");
                new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);

        logger.info("-".repeat(50));
        //----------------------------------------------------------
        // use phase
        //----------------------------------------------------------
//
        TransferService transferService =
                applicationContext.getBean("transferService", TransferService.class);

//        transferService.transfer(100.00, "1", "2");


        logger.info("-".repeat(50));
        //----------------------------------------------------------
        // destroy phase
        //----------------------------------------------------------

        logger.info("-".repeat(50));
        //----------------------------------------------------------

    }
}

package org.example.config;

import org.example.repository.AccountRepository;
import org.example.repository.JdbcAccountRepository;
import org.example.service.TransferService;
import org.example.service.UPITransferService;
import org.example.spring.RepoQualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

@Configuration
@Import({DataSourceConfiguration.class})
@ComponentScan(basePackages = {"org.example"})
public class TransferServiceConfiguration {


    @Bean
    public double transferLimit() {
        return 100000.00;
    }

//    @Bean
//    public AccountRepository jdbcAccountRepository(DataSource dataSource) {
//        JdbcAccountRepository jdbcAccountRepository = new JdbcAccountRepository(dataSource);
//        return jdbcAccountRepository;
//    }

//
//    @Bean("transferService")
//    public TransferService upiTransferService(/*@RepoQualifier(dbServer = "mysql",tech = "jdbc")*/ AccountRepository accountRepository,double transferLimit) {
//        UPITransferService upiTransferService = new UPITransferService(accountRepository,transferLimit);
//        return upiTransferService;
//    }

}

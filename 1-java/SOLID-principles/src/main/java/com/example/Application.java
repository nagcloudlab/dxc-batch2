package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferServiceImpl;

public class Application {
    public static void main(String[] args) {

        // init / boot phase
        System.out.println("-".repeat(100));
        AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
        AccountRepository jpaAccountRepository = new JpaAccountRepository();
        TransferServiceImpl transferService = new TransferServiceImpl(jdbcAccountRepository);
        System.out.println("-".repeat(100));

        // use phase
        transferService.transfer(100, "111", "222");
        System.out.println();
        transferService.transfer(100.00, "222", "111");

        System.out.println("-".repeat(100));
        // destroy phase
        System.out.println("-".repeat(100));

    }
}

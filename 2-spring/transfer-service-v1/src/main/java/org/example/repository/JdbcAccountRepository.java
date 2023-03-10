package org.example.repository;

import org.example.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcAccountRepository implements AccountRepository{

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    public JdbcAccountRepository() {
        logger.info("JdbcAccountRepository component created");
    }

    public Account loadAccount(String number) {
        //
        logger.info("loadAccount - " + number);
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        //
        logger.info("updateAccount - " + account.getNumber());
    }

}

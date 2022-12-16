package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

/**
 * author : dev-1 / team-1
 */

public class JdbcAccountRepository implements AccountRepository {

    private final static Logger logger = Logger.getLogger("transfer-service");

    public JdbcAccountRepository(){
        logger.info("JdbcAccountRepository component created");
    }

    public Account loadAccount(String number) {
        logger.info("loadAccount(" + number + ")");
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        //..
        logger.info("updateAccount(" + account.getNumber() + ")");
    }

}

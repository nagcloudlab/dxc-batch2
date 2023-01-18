package org.example.repository;

import org.example.model.Account;
import org.example.spring.RepoQualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
//@RepoQualifier(dbServer = "mysql",tech = "jpa")
public class JpaAccountRepository implements AccountRepository{

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    public JpaAccountRepository() {
        logger.info("JpaAccountRepository component created");
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

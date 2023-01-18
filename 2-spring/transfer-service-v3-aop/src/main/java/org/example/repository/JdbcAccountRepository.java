package org.example.repository;

import org.example.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcAccountRepository implements AccountRepository {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    private DataSource dataSource;

    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        logger.info("JdbcAccountRepository component created");
    }

    @Override
    public Account loadAccount(String number) {
        logger.info("loadAccount - " + number);  // SQLException
        return new Account(number,1000.00);
    }

    @Override
    public void updateAccount(Account account) {
        logger.info("updateAccount - " + account.getNumber());
    }
}

package org.example.repository;

import org.example.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcAccountRepository implements AccountRepository {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        logger.info("JdbcAccountRepository component created");
    }

    @Override
    public Account loadAccount(String number) {
        logger.info("loadAccount - " + number);
        return jdbcTemplate.queryForObject("select * from accounts where number =?", (rs, index) -> {
            return new Account(rs.getString("number"), rs.getDouble("balance"));
        }, number);
    }

    @Override
    public void updateAccount(Account account) {
        logger.info("updateAccount - " + account.getNumber());
        jdbcTemplate.update("update accounts set balance =? where number =?", account.getBalance(), account.getNumber());
    }
}

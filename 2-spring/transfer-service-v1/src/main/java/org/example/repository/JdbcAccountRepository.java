package org.example.repository;

import org.example.model.Account;

public class JdbcAccountRepository {

    public Account loadAccount(String number) {
        //
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        //
    }

}

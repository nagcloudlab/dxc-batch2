package org.example.repository;

import org.example.model.Account;

public interface AccountRepository {
    Account loadAccount(String number);
    void updateAccount(Account account);
}

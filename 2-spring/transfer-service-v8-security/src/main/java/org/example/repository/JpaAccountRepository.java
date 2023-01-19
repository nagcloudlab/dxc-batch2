package org.example.repository;

import org.example.model.Account;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account loadAccount(String number) {
        return entityManager.find(Account.class, number); // select * from account where number =?
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account); // update * from account where number =?
    }
}

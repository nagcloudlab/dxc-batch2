package com.example.repository;

public class AccountRepositoryFactory {
    public static AccountRepository getAccountRepository(String tech) {
        if (tech.equalsIgnoreCase("jdbc")) {
            return new JdbcAccountRepository();
        }
        if (tech.equalsIgnoreCase("jpa")) {
            return new JpaAccountRepository();
        }
        return null;
    }

}

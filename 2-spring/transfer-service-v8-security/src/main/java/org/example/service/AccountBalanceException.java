package org.example.service;

public class AccountBalanceException extends RuntimeException {
    public AccountBalanceException(String insufficientFunds) {
        super(insufficientFunds);
    }
}

package com.payment;

import com.exception.AccountBalanceException;
import com.exception.AccountNotFoundException;

public interface TransferService {
    void transfer(double amount, String source, String destination)  throws AccountNotFoundException, AccountBalanceException;
}

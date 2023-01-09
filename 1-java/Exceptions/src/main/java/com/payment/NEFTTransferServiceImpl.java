package com.payment;

import com.exception.AccountBalanceException;
import com.exception.AccountNotFoundException;

/**
 * team-2
 */

public class NEFTTransferServiceImpl implements TransferService {

    @Override
    public void transfer(double amount, String source, String destination) throws AccountNotFoundException,AccountBalanceException {
        //..
        if (source.equals("13"))
            throw new AccountNotFoundException("source account -" + source + " not found");

        if (destination.equals("31"))
            throw new AccountNotFoundException("destination account -" + source + " not found");
        //...
        double sourceAccountBalance = 1000.00;
        if (sourceAccountBalance < amount)
            throw new AccountBalanceException("current balance -" + sourceAccountBalance);

    }

}

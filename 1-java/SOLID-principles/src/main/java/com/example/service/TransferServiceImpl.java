package com.example.service;

import com.example.model.Account;
//import com.example.repository.JdbcAccountRepository;
import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;
import org.apache.log4j.Logger;

/**
 * author : dev2 / team-2
 */
public class TransferServiceImpl {
    private final static Logger logger = Logger.getLogger("transfer-service");
    private AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("TransferService component created");
    }

    public void transfer(double amount, String source, String destination) {
        logger.info("transfer initiated..");
//        JdbcAccountRepository accountRepository = new JdbcAccountRepository();
        //AccountRepository accountRepository= AccountRepositoryFactory.getAccountRepository("jdbc");
        // load source & destination accounts
        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);
        // debit & credit
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        // update accounts
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);
        logger.info("transfer completed..");
    }

}

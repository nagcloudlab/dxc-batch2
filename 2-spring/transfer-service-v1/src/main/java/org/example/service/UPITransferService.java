package org.example.service;

import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UPITransferService implements TransferService{

    private static Logger logger= LoggerFactory.getLogger("transfer-service");
    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("TransferService component created with accountRepository dependency`");
    }

    public void transfer(double amount, String source, String destination) {
        logger.info("transfer initiated");
        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);
        logger.info("debit");
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        logger.info("credit");
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);
        logger.info("transfer completed");
    }

}

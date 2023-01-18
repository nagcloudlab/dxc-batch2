package org.example.service;

import org.example.annotation.Transactional;
import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UPITransferService implements TransferService {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("TransferService component created with accountRepository dependency");
    }

    @Override
    @Transactional
    public void transfer1(double amount, String source, String destination) {

        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);
        logger.info("debit");
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        logger.info("credit");
        if (1 == 2) throw new RuntimeException();
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);

    }

    public void foo() {

    }


}

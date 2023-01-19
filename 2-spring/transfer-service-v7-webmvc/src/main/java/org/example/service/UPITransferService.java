package org.example.service;

import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UPITransferService implements TransferService {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    private AccountRepository accountRepository;

    public UPITransferService(@Qualifier("jpaAccountRepository") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("TransferService component created with accountRepository dependency");
    }

    @Override
    @Transactional(
            transactionManager = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {RuntimeException.class},
            noRollbackFor = {AccountBalanceException.class}
    )
    public void transfer(double amount, String source, String destination) {

        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);
        logger.info("debit");
        if (sourceAccount.getBalance() < amount)
            throw new AccountBalanceException("Insufficient funds");
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        logger.info("credit");
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        accountRepository.updateAccount(sourceAccount);
        if (1 == 2) throw new RuntimeException();
        accountRepository.updateAccount(destinationAccount);

    }

    public void foo() {

    }


}

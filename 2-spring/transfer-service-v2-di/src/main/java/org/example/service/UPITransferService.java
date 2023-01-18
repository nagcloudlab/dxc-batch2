package org.example.service;

import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.example.spring.RepoQualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("transferService")
@Service("transferService")
//@Lazy
public class UPITransferService implements TransferService {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    private double transferLimit;

    //    @Autowired
//    @RepoQualifier(dbServer = "mysql",tech = "jdbc")
    private AccountRepository accountRepository;

    //    @Autowired ( from spring -5 , this annotation not required over constructor )
    public UPITransferService(
            /*@RepoQualifier(dbServer = "mysql", tech = "jdbc")*/ AccountRepository accountRepository
            ) {
        this.accountRepository = accountRepository;
        logger.info("TransferService component created with accountRepository dependency");
    }

//    public UPITransferService(
//            /*@RepoQualifier(dbServer = "mysql", tech = "jdbc") */AccountRepository accountRepository,
//            double transferLimit
//    ) {
//        this.accountRepository = accountRepository;
//        this.transferLimit = transferLimit;
//        logger.info("TransferService component created with accountRepository dependency");
//    }

//    @Autowired(required = false)
//    public void setAccountRepository(@RepoQualifier(dbServer = "mysql",tech = "jdbc") AccountRepository accountRepository){
//        logger.info("TransferService component created with accountRepository dependency");
//        this.accountRepository = accountRepository;
//    }


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

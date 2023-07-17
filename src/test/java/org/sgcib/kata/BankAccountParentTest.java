package org.sgcib.kata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sgcib.kata.entity.Account;
import org.sgcib.kata.dao.AccountManager;
import org.sgcib.kata.factory.BankAccountFactory;


public abstract class BankAccountParentTest {
    private  BankAccountFactory factory = BankAccountFactory.getInstance();
    private AccountManager accountManager = AccountManager.getInstance();

    public BankAccountFactory getFactory() {
        return factory;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    @BeforeEach
     void setUp() {
        Account acc1 = accountManager.createAccount("BASIC",1L);
        Account acc2 = accountManager.createAccount("BASIC",2L);

    }
    @AfterEach
     void tearDown() {
        accountManager.getManagedAccounts().clear();
    }

}

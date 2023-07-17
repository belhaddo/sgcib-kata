package org.sgcib.kata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sgcib.kata.entity.Account;
import org.sgcib.kata.manager.AccountManager;


public abstract class BankAccountParentTest {
    private AccountManager accountManager = AccountManager.getInstance();

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

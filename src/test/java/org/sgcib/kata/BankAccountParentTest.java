package org.sgcib.kata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sgcib.kata.entity.Account;
import org.sgcib.kata.manager.AccountManager;
import org.sgcib.kata.manager.BankAccountFactory;

import java.math.BigDecimal;

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
        System.out.println("#### Test Setup before each: ");
        Account acc1 = accountManager.createAccount("BASIC",1L);
        Account acc2 = accountManager.createAccount("BASIC",2L);

        acc1.deposit(BigDecimal.TEN);
        acc1.deposit(BigDecimal.TEN);
        acc1.withdraw(BigDecimal.ONE);
        System.out.println("#### Test Setup done ");

    }
    @AfterEach
     void tearDown() {
        accountManager.getManagedAccounts().clear();
    }



}

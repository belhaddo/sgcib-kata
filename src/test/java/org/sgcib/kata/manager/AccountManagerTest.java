package org.sgcib.kata.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sgcib.kata.entity.Account;

import java.math.BigDecimal;
import java.util.List;

public class AccountManagerTest {
    AccountManager am;

    @BeforeEach
    void setUp() {
        am = AccountManager.getInstance();
        Account acc1 = am.createAccount(1L);
        Account acc2 = am.createAccount(2L);

        acc1.deposit(BigDecimal.TEN);
        acc1.deposit(BigDecimal.TEN);
        acc1.withdraw(BigDecimal.ONE);

    }
    @Test
    public void testGetManagedAccounts() {
        Assertions.assertEquals(am.getManagedAccounts().size(), 2);
    }
    @Test
    public void testCreateAccount() {
        Assertions.assertEquals(am.getManagedAccounts().size(), 2);
        Account acc3 = am.createAccount(3L);
        Assertions.assertEquals(am.getManagedAccounts().size(), 3);
        am.getManagedAccounts().remove(3L);
        Assertions.assertEquals(am.getManagedAccounts().size(), 2);

    }
    @Test
    public void testListAccounts() {
        Assertions.assertTrue(am.listAccounts().equals(List.of(1L, 2L)));
    }
}
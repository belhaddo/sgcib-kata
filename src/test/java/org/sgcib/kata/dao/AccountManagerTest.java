package org.sgcib.kata.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sgcib.kata.BankAccountParentTest;
import org.sgcib.kata.entity.Account;

import java.util.List;

public class AccountManagerTest extends BankAccountParentTest {
    @Test
    public void testGetManagedAccounts() {
        Assertions.assertEquals(getAccountManager().getManagedAccounts().size(), 2);
    }
    @Test
    public void testCreateAccount() {
        Assertions.assertEquals(getAccountManager().getManagedAccounts().size(), 2);
        Account acc3 = getAccountManager().createAccount("BASIC",3L);
        Assertions.assertEquals(getAccountManager().getManagedAccounts().size(), 3);
        getAccountManager().getManagedAccounts().remove(3L);
        Assertions.assertEquals(getAccountManager().getManagedAccounts().size(), 2);

    }
    @Test
    public void testCreateAccountFail() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> getAccountManager().createAccount("WRONG", 4L));
    }
    @Test
    public void testListAccounts() {
        Assertions.assertTrue(getAccountManager().listAccounts().equals(List.of(1L, 2L)));
    }

    @Test
    public void testDuplicateAccountFail() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> getAccountManager().createAccount("BASIC", 1L));
    }

}
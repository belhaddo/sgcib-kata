package org.sgcib.kata.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sgcib.kata.BankAccountParentTest;
import org.sgcib.kata.entity.BasicAccount;

public class BankAccountFactoryTest extends BankAccountParentTest {
    
    @Test
    public void testGetAccount() {
        boolean isBasic = getFactory().getAccount("BASIC", 5L) instanceof BasicAccount;
        Assertions.assertTrue(isBasic);
    }
}
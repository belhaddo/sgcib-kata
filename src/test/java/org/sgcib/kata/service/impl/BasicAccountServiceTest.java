package org.sgcib.kata.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sgcib.kata.BankAccountParentTest;
import org.sgcib.kata.entity.BasicAccount;

import java.math.BigDecimal;

public class BasicAccountServiceTest extends BankAccountParentTest {

    BasicAccountService service;
    BasicAccount acc;

    @BeforeEach
    void setUp() {
        System.out.println("#### Test Setup before each: ");
        service = new BasicAccountService();
        acc = new BasicAccount(1L);
        System.out.println("#### Test Setup done ");

    }
    @Test
    public void testWithdraw() {
        service.deposit(acc, BigDecimal.TEN);
        service.withdraw(acc,BigDecimal.ONE);
        Assertions.assertEquals(acc.getBalance(), BigDecimal.valueOf(9));
    }

    @Test
    public void testWithdrawFail() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> service.withdraw(acc,BigDecimal.ONE));
    }
    @Test
    public void testDeposit() {
        service.deposit(acc, BigDecimal.TEN);
        Assertions.assertEquals(acc.getBalance(), BigDecimal.valueOf(10));
    }
    @Test
    public void testCheckBalance() {
        Assertions.assertEquals(service.checkBalance(acc), BigDecimal.valueOf(0));
    }
    @Test
    public void testPrintStatementsHistory() {
        Assertions.assertEquals(service.printStatementsHistory(acc), "Account id : 1\n" +
                "Account Operations : \n" +
                "Account balance : 0");

    }
}
package org.sgcib.kata.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sgcib.kata.BankAccountParentTest;

import java.math.BigDecimal;

public class AccountTest extends BankAccountParentTest {
    Account acc;
    @BeforeEach
    void setUp() {
        System.out.println("#### Test Setup before each: ");
        acc = new BasicAccount(1L);
        System.out.println("#### Test Setup done ");

    }
    @Test
    public void testWithdraw() {
        acc.deposit(BigDecimal.TEN);
        acc.withdraw(BigDecimal.ONE);
        Assertions.assertEquals(acc.getBalance(), BigDecimal.valueOf(9));
    }

    @Test
    public void testWithdrawFail() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> acc.withdraw(BigDecimal.ONE));
    }
    @Test
    public void testDeposit() {
        acc.deposit(BigDecimal.TEN);
        Assertions.assertEquals(acc.getBalance(), BigDecimal.valueOf(10));
    }
    @Test
    public void testCheckBalance() {
        Assertions.assertEquals(acc.getBalance(), BigDecimal.valueOf(0));
    }
    @Test
    public void testPrintStatementsHistory() {
        Assertions.assertEquals(acc.printStatementsHistory(), "Account id : 1\n" +
                "Account Operations : \n" +
                "Account balance : 0");

    }
}
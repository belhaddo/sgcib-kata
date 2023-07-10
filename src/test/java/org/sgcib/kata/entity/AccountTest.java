package org.sgcib.kata.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {
    Account acc;
    @BeforeEach
    void setUp() {
        acc = new BasicAccount(1L);
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
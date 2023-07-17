package org.sgcib.kata.service;

import org.sgcib.kata.entity.BasicAccount;

import java.math.BigDecimal;

public interface Manageable {

    public void withdraw(BasicAccount account, BigDecimal amount);
    public void deposit(BasicAccount account, BigDecimal amount);
    public BigDecimal checkBalance(BasicAccount account);
    public String printStatementsHistory(BasicAccount account);
}

package org.sgcib.kata.entity;

import java.math.BigDecimal;

public interface Manageable {

    public void withdraw(BigDecimal amount);
    public void deposit(BigDecimal amount);
    public BigDecimal checkBalance();
    public String printStatementsHistory();
}

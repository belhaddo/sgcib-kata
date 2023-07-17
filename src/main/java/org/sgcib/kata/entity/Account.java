package org.sgcib.kata.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private Long id;
    private BigDecimal balance;
    private List<Operation> operations = new ArrayList<>();

    public Account(Long id) {
        this.id = id;
        this.balance = BigDecimal.ZERO;
        this.operations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

package org.sgcib.kata.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Manageable {
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

    @Override
    public void withdraw(BigDecimal amount) {

    }

    @Override
    public void deposit(BigDecimal amount) {

    }

    @Override
    public BigDecimal checkBalance() {
        return getBalance();
    }

    @Override
    public String printStatementsHistory() {

        StringBuilder statements = new StringBuilder();
        statements.append("Account id : " + getId());
        statements.append("\n");
        statements.append("Account Operations : ");
        statements.append("\n");

        getOperations().forEach(op ->
                statements.append("    | " + op.getTransactionDate() + " | " + op.getType() + " | " + op.getAmount() + "\n")
        );

        statements.append("Account balance : " + getBalance());
        return statements.toString();
    }
}

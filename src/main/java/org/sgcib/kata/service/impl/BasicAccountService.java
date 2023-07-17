package org.sgcib.kata.service.impl;

import org.sgcib.kata.entity.BasicAccount;
import org.sgcib.kata.entity.dto.Operation;
import org.sgcib.kata.entity.dto.TransactionType;
import org.sgcib.kata.service.Manageable;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BasicAccountService implements Manageable {
    @Override
    public void withdraw(BasicAccount account, BigDecimal amount) {
        if(account.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            account.getOperations().add(new Operation(LocalDate.now(), TransactionType.WITHDRAWAL,amount));
            account.setBalance(account.getBalance().subtract(amount));
            System.out.println("Successful Withdrawal operation of the amount : " + amount );
        } else {
            throw new IllegalArgumentException("Account '" +account.getId() + "' Your balance of '" + account.getBalance() + "' doesn't allow the withdrawal of the amount : " + amount);
        }
    }

    @Override
    public void deposit(BasicAccount account, BigDecimal amount) {
        account.getOperations().add(new Operation(LocalDate.now(), TransactionType.DEPOSIT,amount));
        account.setBalance(account.getBalance().add(amount));
        System.out.println("Successful Deposit operation of the amount : " + amount );
    }

    @Override
    public BigDecimal checkBalance(BasicAccount account) {
        return account.getBalance();
    }

    @Override
    public String printStatementsHistory(BasicAccount account) {

        StringBuilder statements = new StringBuilder();
        statements.append("Account id : " + account.getId());
        statements.append("\n");
        statements.append("Account Operations : ");
        statements.append("\n");

        account.getOperations().forEach(op ->
                statements.append("    | " + op.getTransactionDate() + " | " + op.getType() + " | " + op.getAmount() + "\n")
        );

        statements.append("Account balance : " + account.getBalance());
        return statements.toString();
    }
}

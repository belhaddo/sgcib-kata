package org.sgcib.kata.entity;

import java.time.LocalDate;

import java.math.BigDecimal;

public class BasicAccount extends Account {

    public BasicAccount(Long id) {
        super(id);
    }

    /**
     * withdraw money with balance validation
     * @param amount
     */
    @Override
    public void withdraw(BigDecimal amount) {

        if(getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            getOperations().add(new Operation(LocalDate.now(), TransactionType.WITHDRAWAL,amount));
            setBalance(getBalance().subtract(amount));
            System.out.println("Successful Withdrawal operation of the amount : " + amount );
        } else {
            throw new IllegalArgumentException("Account '" +getId() + "' Your balance of '" + getBalance() + "' doesn't allow the withdrawal of the amount : " + amount);
        }
    }

    /**
     * make bank account deposit
     * @param amount
     */
    @Override
    public void deposit(BigDecimal amount) {
        getOperations().add(new Operation(LocalDate.now(), TransactionType.DEPOSIT,amount));
        setBalance(getBalance().add(amount));
        System.out.println("Successful Deposit operation of the amount : " + amount );
    }



}

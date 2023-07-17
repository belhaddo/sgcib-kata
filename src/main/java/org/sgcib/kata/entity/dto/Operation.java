package org.sgcib.kata.entity.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Operation {

    private TransactionType type;
    private LocalDate transactionDate;
    private BigDecimal amount;

    public Operation(LocalDate transactionDate, TransactionType type, BigDecimal amount) {
        this.transactionDate = transactionDate;
        this.type = type;
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

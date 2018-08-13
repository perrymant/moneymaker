package io.github.perrymant.moneymaker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String time;
    private TransactionType transactionType;
    private int amount;
    private String description;

// use this to add the current time - not implemented yet.
    String getTimeNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }

    String getTime() {
        return time;
    }

    void setTime(String time) {
        this.time = time;
    }

    TransactionType getTransactionType() {
        return transactionType;
    }

    void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String reportStringFormat() {
        return  getTime() + ", " + getTransactionType() + ", " + getAmount() + ", " + getDescription();
    }
}

enum TransactionType {
    CREDIT,
    DEBIT
}


// This is a POJO
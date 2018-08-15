package io.github.perrymant.moneymaker;

class Transaction {
    private String time;
    private TransactionType transactionType;
    private double amount;
    private String description;

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

    double getAmount() {
        return amount;
    }

    void setAmount(double amount) {
        this.amount = amount;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

}

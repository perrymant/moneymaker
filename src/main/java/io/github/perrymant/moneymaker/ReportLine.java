package io.github.perrymant.moneymaker;

import static java.lang.String.valueOf;

class ReportLine {
    private final Transaction transaction;
    private final int balance;

    ReportLine(final Transaction transaction, final int balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    String[] getRowItems() {
        return new String[]{
                transaction.getTime(),
                transaction.getTransactionType().name(),
                valueOf(transaction.getAmount()),
                valueOf(balance),
                transaction.getDescription()
        };
    }
}
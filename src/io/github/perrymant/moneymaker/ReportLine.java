package io.github.perrymant.moneymaker;

import static java.lang.String.format;

class ReportLine {
    private final Transaction transaction;
    private final double balance;

    ReportLine(final Transaction transaction, final double balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    @Override
    public String toString() {
        final String time = transaction.getTime();
        final TransactionType transactionType = transaction.getTransactionType();
        final double amount = transaction.getAmount();
        final String description = TextWrapper.wrap(transaction.getDescription());
        return format("| %-11s| %-18s| £ %-,16.2f| £ %-, 16.2f| %24s",
                time, transactionType, amount, balance, description);
    }

    String toStringCSV() {
        final String time = transaction.getTime();
        final TransactionType transactionType = transaction.getTransactionType();
        final double amount = transaction.getAmount();
        final String description = treatComma(transaction.getDescription());
        return format("%s,%s,%s,%s,%s", time, transactionType, amount, balance, description);
    }

    private String treatComma(String description) {
        return "\"" + description + "\"";
    }

}
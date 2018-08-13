package io.github.perrymant.moneymaker;

class ReportLine {
    private final Transaction transaction;
    private final int balance;

    ReportLine(final Transaction transaction, final int balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return transaction.reportStringFormat() + ", " + balance;
    }
}
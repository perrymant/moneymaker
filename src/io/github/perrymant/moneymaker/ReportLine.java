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
        return transaction.getTime()
                + "\t| " + transaction.getTransactionType()
                + "\t\t\t| £ " + transaction.getAmount()
                + "\t\t| £ " + balance
                + "\t\t| "
                + TextWrapper.wrap(transaction.getDescription())
                + "\t\t|"; // TODO: endOfLineFormat
    }
}
package io.github.perrymant.moneymaker;

import java.util.List;

import static io.github.perrymant.moneymaker.TransactionType.*;

class Budget {

    private final Balance balance;
    private final List<Transaction> transactions;

    Budget(Balance balance, List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    void updateBalance() {
        for (Transaction transaction : transactions) {
            int sign = transaction.getTransactionType() == CREDIT ? 1 : -1;
            balance.increment(sign * transaction.getAmount());
        }
    }

    String printBalance() {
        String result = "";
        for (Transaction transaction : transactions) {
            result += transaction.reportStringFormat();
            result += "\n";
        }
        return result;
    }

}



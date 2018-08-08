package io.github.perrymant.moneymaker;

import java.util.ArrayList;
import java.util.List;

import static io.github.perrymant.moneymaker.TransactionType.*;

class Budget {

    private final Balance balance;
    private final List<Transaction> transactions;
    private final List<ReportLine> report = new ArrayList<>();

    Budget(Balance balance, List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    void updateBalance() {
        for (Transaction transaction : transactions) {
            int sign = transaction.getTransactionType() == CREDIT ? 1 : -1;
            balance.increment(sign * transaction.getAmount());
            report.add(new ReportLine(transaction, balance.get()));
        }
    }

    void report() {
        updateBalance();
        System.out.println(makeReport());
    }

    String makeReport() {
        String result = "";
        for (ReportLine reportLine : report) {
            result += reportLine.toString() + "\n";
        }
        return result;
    }

}



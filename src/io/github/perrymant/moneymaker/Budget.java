package io.github.perrymant.moneymaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.perrymant.moneymaker.TransactionType.*;

class Budget {
    private final Balance balance;
    private final List<Transaction> transactions;

    private final List<ReportLine> report = new ArrayList<>();

    Budget(final Balance balance, final List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    String report() {
        updateBalance();
        return report.stream()
                .map((rl) -> rl.toString() + "\n")
                .collect(Collectors.joining());
    }

    private void updateBalance() {
        for (final Transaction transaction : transactions) {
            final int sign = transaction.getTransactionType() == CREDIT ? 1 : -1;
            balance.increment(sign * transaction.getAmount());
            report.add(new ReportLine(transaction, balance.get()));
        }
    }

}



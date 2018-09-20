package io.github.perrymant.moneymaker;

import com.jakewharton.fliptables.FlipTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;

class Budget implements Serializable {
    private static final String[] HEADERS = new String[]{"Time", "Transaction Type", "Amount", "Balance", "Description"};
    private final Balance balance;
    private final List<Transaction> transactions;
    private final List<ReportLine> report = new ArrayList<>();

    Budget(final Balance balance, final List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    String report() {
        updateBalance();
        return FlipTable.of(HEADERS, createData());
    }

    private String[][] createData() {
        return report.stream()
                .map(rl -> rl.getRowItems())
                .collect(Collectors.toList())
                .toArray(new String[report.size()][]);
    }

    private List<String[]> createJSONData() {
        return report.stream()
                .map(rl -> rl.getRowItems())
                .collect(Collectors.toList());
    }

    private void updateBalance() {
        for (final Transaction transaction : transactions) {
            final int sign = transaction.getTransactionType() == CREDIT ? 1 : -1;
            balance.increment(sign * transaction.getAmount());
            report.add(new ReportLine(transaction, balance.get()));
        }
    }


}
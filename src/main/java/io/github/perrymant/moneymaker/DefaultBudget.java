package io.github.perrymant.moneymaker;

import com.jakewharton.fliptables.FlipTable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;

class DefaultBudget implements Budget {
    private static final String[] HEADERS = new String[]{"Time", "Transaction Type", "Amount", "Balance", "Description"};
    private final Balance balance;
    private final List<Transaction> transactions;
    private final List<ReportLine> report = new ArrayList<>();

    DefaultBudget(final Balance balance, final List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    @Override
    public String report() {
        updateBalance();
        return FlipTable.of(HEADERS, createData());
    }

    @Override
    public String[][] createData() {
        return report.stream()
                .map(ReportLine::getRowItems)
                .collect(Collectors.toList())
                .toArray(new String[report.size()][]);
    }

    @Override
    public void updateBalance() {
        for (final Transaction transaction : transactions) {
            final int sign = transaction.getTransactionType() == CREDIT ? 1 : -1;
            balance.increment(sign * transaction.getAmount());
            report.add(new ReportLine(transaction, balance.get()));
        }
    }

}
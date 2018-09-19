package io.github.perrymant.moneymaker;

import com.jakewharton.fliptables.FlipTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;

class Budget {
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

    List<String[]> reportJSON() {
        updateBalance();
        return createJSONData();
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

    private Map<String, List<String>> createJSONData2() {
        Map<String, Object> map = new HashMap();
        map = map.entrySet()
                .stream()
                .collect(Collectors.toMap(k -> k.getKey(), rl -> rl.getRowItems(),
                (k, v) -> k, HashMap::new));
        return report.stream()
                .map()
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
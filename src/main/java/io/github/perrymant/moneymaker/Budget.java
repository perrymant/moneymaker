package io.github.perrymant.moneymaker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakewharton.fliptables.FlipTable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;

class Budget {
    private static final String[] HEADERS = new String[]{"DateTime", "Transaction Type", "Amount", "Balance", "Description"};
    private final Balance balance;
    private final List<Transaction> transactions;
    private final List<ReportLine> report = new ArrayList<>();
    private String om;

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
                .map(ReportLine::getRowItems)
                .collect(Collectors.toList())
                .toArray(new String[report.size()][]);
    }

    private void updateBalance() {
        for (final Transaction transaction : transactions) {
            final int sign = transaction.getTransactionType() == CREDIT ? 1 : -1;
            balance.increment(sign * transaction.getAmount());
            report.add(new ReportLine(transaction, balance.get()));
        }
    }

    void transaction(String[] args) {
        TransactionExtractor transactionExtractor = new TransactionExtractor();
        final Transaction transaction = transactionExtractor.extract(args);
        final int sign = transaction.getTransactionType() == CREDIT ? 1 : -1;
        balance.increment(sign * transaction.getAmount());
        report.add(new ReportLine(transaction, balance.get()));
    }


    String reportJSON() {
        updateBalance();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            om = objectMapper.writeValueAsString(report);
            System.out.println(om);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return String.valueOf(om);
    }
}


//    @GetMapping
//    Map<String, String> reportJSON_1() {
//        updateBalance();
//        HashMap<String, String> map = new HashMap<>();
//        for (ReportLine line : report) {
//            map.put("date", line.getDateTime());
//            map.put("amount", String.valueOf(line.getAmount()));
//            map.put("balance", String.valueOf(line.getBalance()));
//            map.put("description", line.getDescription());
//        }
//        return map;
//    }


//    String reportJSON() {
//        updateBalance();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String jsonString = mapper.writeValueAsString(Arrays.deepToString(createData()));
//            System.out.println("jsonString = " + jsonString);
//            return jsonString;
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return "ERROR";
//    }
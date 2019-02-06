package io.github.perrymant.moneymaker;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static io.github.perrymant.moneymaker.TransactionType.DEBIT;

@Service
class ReportService {

    ReportResponse convert(final Account account) {
        if (account == null) {
            return null;
        }
        final ReportResponse response = new ReportResponse();
        response.setTransactions(makeReportLines(account));
        return response;
    }

    private List<ReportLine> makeReportLines(final Account account) {
        final List<ReportLine> transactions = new ArrayList<>();
        int balance = 0;
        for (final Transaction transaction : account.getTransactions()) {
            final ReportLine reportLine = makeReportLine(transaction, balance);
            transactions.add(reportLine);
            balance = reportLine.getBalance();
        }
        return transactions;
    }

    private ReportLine makeReportLine(final Transaction transaction, final int balance) {
        final ReportLine reportLine = new ReportLine();
        reportLine.setAmount(transaction.getAmount());
        reportLine.setDate(transaction.getDate());
        reportLine.setDescription(transaction.getDescription());
        reportLine.setTransactionType(transaction.getTransactionType());
        final int sign = reportLine.getTransactionType() == DEBIT ? -1 : 1;
        reportLine.setBalance(balance + (transaction.getAmount() * sign));
        return reportLine;
    }
}

package io.github.perrymant.moneymaker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReportServiceTest {

    private ReportService target = new ReportService();

    @Test
    public void givenNull_returnsNull() {
        Assert.assertNull(target.convert(null));
    }

    @Test
    public void givenAccountObject_returnsCorrespondingReportResponse() {
        final ReportResponse response = target.convert(makeAccount());
        assertNotNull(response);
        final List<ReportLine> transactions = response.getTransactions();
        assertNotNull(transactions);
        assertEquals(1, transactions.size());
        final ReportLine reportLine = transactions.get(0);
        assertEquals(100, reportLine.getAmount());
        assertEquals("20-12-85", reportLine.getDate());
        assertEquals("Purchase", reportLine.getDescription());
        assertEquals(TransactionType.DEBIT, reportLine.getTransactionType());
    }

    @Test
    public void givenTransaction_returnsBalance() {
        final Account account = makeAccount();
        account.getTransactions().add(makeTransaction());
        final ReportResponse response = target.convert(account);
        final List<ReportLine> transactions = response.getTransactions();
        assertEquals(-100, transactions.get(0).getBalance());
        assertEquals(-200, transactions.get(1).getBalance());
    }

    private Account makeAccount() {
        final Account account = new Account();
        account.setTransactions(makeTransactions());
        return account;
    }

    private List<Transaction> makeTransactions() {
        final List<Transaction> transactions = new ArrayList<>();
        transactions.add(makeTransaction());
        return transactions;
    }

    private Transaction makeTransaction() {
        final Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setDate("20-12-85");
        transaction.setDescription("Purchase");
        transaction.setTransactionType(TransactionType.DEBIT);
        return transaction;
    }

}
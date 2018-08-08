package io.github.perrymant.moneymaker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BudgetTest {

    private static final String DATE_TIME = "2018/01/02";
    private static final String DESCRIPTION = "Got paid";
    private Balance balance = new Balance();
    private List<Transaction> transactions = new ArrayList<>();

    @Test
    public void canProjectBalance() {
        makeBudget();
    }

    @Test
    public void startBalanceIsZero() {
        balance = new Balance();
        assertEquals(0, balance.get());
        makeBudget();
    }

    @Test
    public void createDebitTransaction() {
        transactions.add(makeDebitTransaction());
        Budget target = makeBudget();
        assertEquals(0, balance.get());
        target.report();
        assertEquals(-20, balance.get());
    }

    @Test
    public void givenTransactionWithHoursMinutes_GetReportStringFormat() {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setAmount(50);
        transaction.setDescription("New payment");
        transaction.setTime("2018/01/02 20:12");
        assertEquals("2018/01/02 20:12, CREDIT, 50, New payment", transaction.reportStringFormat());
    }

    @Test
    public void canGenerateStringReportWithUpdatedBalance() {
        transactions.add(makeTransactionFromArgs(TransactionType.CREDIT, 150, DESCRIPTION));
        transactions.add(makeTransactionFromArgs(TransactionType.DEBIT, 100, DESCRIPTION));
        Budget budget = new Budget(balance, transactions);
        budget.report();
        assertEquals("2018/01/02, CREDIT, 150, Got paid, 150\n2018/01/02, DEBIT, 100, Got paid, 50\n", budget.makeReport());
    }

    private Transaction makeTransactionFromArgs(TransactionType transactionType,
                                                int amount,
                                                String description) {
        Transaction transaction = new Transaction();
        transaction.setTime(DATE_TIME);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        return transaction;
    }

    private Transaction makeDebitTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.DEBIT);
        transaction.setAmount(20);
        return transaction;
    }

    private Budget makeBudget() {
        return new Budget(balance, transactions);

    }
}

// makeTransactionFromArgs - makeTransaction
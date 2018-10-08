package io.github.perrymant.moneymaker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BudgetTest {

    private static final String DATE_TIME = "2018-01-02";
    private Balance balance = new Balance();
    private List<Transaction> transactions = new ArrayList<>();
    private DefaultBudget target = new DefaultBudget(balance, transactions);

    @Test
    public void givenDebitTransaction_canHaveNegativeBalance() {
        transactions.add(makeDebitTransaction());
        target.report();
        assertEquals(-20, balance.get());
    }

    @Test
    public void useOfBudgetClassToGenerateTable() {
        final Balance balance = new Balance();
        List<Transaction> transactions = new TransactionMaker().getTransactions();
        final DefaultBudget budget = new DefaultBudget(balance, transactions);
        String expected = "" +
                "╔════════════╤══════════════════╤════════╤═════════╤═════════════╗\n" +
                "║ Time       │ Transaction Type │ Amount │ Balance │ Description ║\n" +
                "╠════════════╪══════════════════╪════════╪═════════╪═════════════╣\n" +
                "║ 2018-01-01 │ CREDIT           │ £1.25  │ £1.25   │ Got paid    ║\n" +
                "╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
                "║ 2018-01-01 │ CREDIT           │ £1.25  │ £2.50   │ Got paid    ║\n" +
                "╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
                "║ 2018-01-02 │ DEBIT            │ £0.72  │ £1.78   │ Paid bill   ║\n" +
                "╚════════════╧══════════════════╧════════╧═════════╧═════════════╝\n";

        assertEquals(expected, budget.report());
    }

    private Transaction makeDebitTransaction() {
        final Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.DEBIT);
        transaction.setAmount(20);
        transaction.setTime(DATE_TIME);
        transaction.setDescription("Lost money");
        return transaction;
    }

}

package io.github.perrymant.moneymaker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BudgetTest {

    private static final String DATE_TIME = "2018/01/02";
    private Balance balance = new Balance();
    private List<Transaction> transactions = new ArrayList<>();
    private Budget target = new Budget(balance, transactions);

    @Test
    public void givenDebitTransaction_canHaveNegativeBalance() {
        transactions.add(makeDebitTransaction());
        target.report();
        assertEquals(-20, balance.get(), 0.0f);
    }

    @Test
    public void givenMultipleTransactions_reportsAllTransactionsAndUpdatesBalance() {
        transactions.add(makeCreditTransaction());
        transactions.add(makeDebitTransaction());
        assertEquals("2018/01/02,CREDIT,150.0,150.0,\"Got paid\"\n2018/01/02,DEBIT,20.0,130.0,\"Lost money\"\n", target.reportCSV());
    }


    private Transaction makeCreditTransaction() {
        final Transaction transaction = new Transaction();
        transaction.setTime(DATE_TIME);
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setAmount(150);
        transaction.setDescription("Got paid");
        return transaction;
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

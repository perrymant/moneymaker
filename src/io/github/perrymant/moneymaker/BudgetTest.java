package io.github.perrymant.moneymaker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BudgetTest {

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
    public void startCanChangeBalanceValue_Credit() {
        transactions.add(makeCreditTransaction());
        transactions.add(makeCreditTransaction());
        Budget target = makeBudget();
        assertEquals(0, balance.get());
        target.updateBalance();
        assertEquals(300, balance.get());
    }

    @Test
    public void createDebitTransaction() {
        transactions.add(makeDebitTransaction());
        Budget target = makeBudget();
        assertEquals(0, balance.get());
        target.updateBalance();
        assertEquals(-20, balance.get());
    }

    // GivenATransaction_ReturnReportStringFormat

    @Test
    public void checkTimeFormatting() {
        Transaction transaction = new Transaction();
        assertEquals("2018-08-06", transaction.getTimeNow());
    }

    @Test
    public void givenTransaction_GetDescription() {
        Transaction transaction = new Transaction();
        transaction.setDescription("New payment");
        assertEquals("New payment", transaction.getDescription());
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
    public void createMultipleTransactions() {
        transactions.add(makeTransactionFromArgs("2018/01/02", TransactionType.CREDIT, 150, "Got paid"));
        transactions.add(makeTransactionFromArgs("2018/01/03", TransactionType.DEBIT, 100, "Got robbed"));
        Budget budget = new Budget(balance, transactions);
        budget.updateBalance();
        assertEquals(50, balance.get());
    }

    @Test
    public void canGenerateStringReport() {
        transactions.add(makeTransactionFromArgs("2018/01/02", TransactionType.CREDIT, 150, "Got paid"));
        transactions.add(makeTransactionFromArgs("2018/01/03", TransactionType.DEBIT, 100, "Got robbed"));
        Budget budget = new Budget(balance, transactions);
        budget.updateBalance();
        assertEquals("2018/01/02, CREDIT, 150, Got paid\n2018/01/03, DEBIT, 100, Got robbed\n", budget.printBalance());
    }

    @Test
    public void canGenerateStringReportWithUpdatedBalance() {
        transactions.add(makeTransactionFromArgs("2018/01/02", TransactionType.CREDIT, 150, "Got paid"));
        transactions.add(makeTransactionFromArgs("2018/01/03", TransactionType.DEBIT, 100, "Got robbed"));
        Budget budget = new Budget(balance, transactions);
        budget.updateBalance();
        assertEquals("2018/01/02, CREDIT, 150, Got paid, 150\n2018/01/03, DEBIT, 100, Got robbed, 50\n", budget.printBalance());
    }

    private Transaction makeTransactionFromArgs(String dateTime,
                                                TransactionType transactionType,
                                                int amount,
                                                String description) {
        Transaction transaction = new Transaction();
        transaction.setTime(dateTime);
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

    private Transaction makeCreditTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setAmount(150);
        return transaction;
    }

    private Budget makeBudget() {
        return new Budget(balance, transactions);

    }

}
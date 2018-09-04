package io.github.perrymant.moneymaker;

import com.jakewharton.fliptables.FlipTableConverters;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;
import static org.junit.Assert.assertEquals;

public class FlipTableTest {


    @Test
    public void createBasicTableFrom_TransactionMaker() {
        List<Transaction> transactions = new TransactionMaker().getTransactions();
        System.out.println(FlipTableConverters.fromIterable(transactions, Transaction.class));
    }


    @Test
    public void printBalanceInTable() {
        List<Transaction> transactions = new TransactionMaker().getTransactions();
        final Balance balance = new Balance();
        for (final Transaction transaction : transactions) {
            final int sign = transaction.getTransactionType() == CREDIT ? 1 : -1;
            balance.increment(sign * transaction.getAmount());
            transaction.setBalance(balance.get());
        }
        String expected = ""
                + "╔════════╤═════════╤═════════════╤════════════╤═════════════════╗\n"
                + "║ Amount │ Balance │ Description │ Time       │ TransactionType ║\n"
                + "╠════════╪═════════╪═════════════╪════════════╪═════════════════╣\n"
                + "║ 125    │ 125     │ Got paid    │ 2018/01/01 │ CREDIT          ║\n"
                + "╟────────┼─────────┼─────────────┼────────────┼─────────────────╢\n"
                + "║ 125    │ 250     │ Got paid    │ 2018/01/01 │ CREDIT          ║\n"
                + "╟────────┼─────────┼─────────────┼────────────┼─────────────────╢\n"
                + "║ 72     │ 178     │ Paid bill   │ 2018/01/02 │ DEBIT           ║\n"
                + "╚════════╧═════════╧═════════════╧════════════╧═════════════════╝\n";

        String table = FlipTableConverters.fromIterable(transactions, Transaction.class);
        assertEquals(expected, table);
    }

    /* Todo: use of Budget class in FlipTableConverters.fromIterable method */
    @Ignore
    @Test
    public void useOfBudgetClassToGenerateTable() {
        List<Transaction> transactions = new TransactionMaker().getTransactions();
        final Budget budget = new Budget(new Balance(), transactions);
//        System.out.println(budget.report());
        String expected = ""
                + "╔════════╤═════════╤═════════════╤════════════╤═════════════════╗\n"
                + "║ Amount │ Balance │ Description │ Time       │ TransactionType ║\n"
                + "╠════════╪═════════╪═════════════╪════════════╪═════════════════╣\n"
                + "║ 125    │ 125     │ Got paid    │ 2018/01/01 │ CREDIT          ║\n"
                + "╟────────┼─────────┼─────────────┼────────────┼─────────────────╢\n"
                + "║ 125    │ 250     │ Got paid    │ 2018/01/01 │ CREDIT          ║\n"
                + "╟────────┼─────────┼─────────────┼────────────┼─────────────────╢\n"
                + "║ 72     │ 178     │ Paid bill   │ 2018/01/02 │ DEBIT           ║\n"
                + "╚════════╧═════════╧═════════════╧════════════╧═════════════════╝\n";

        String table = FlipTableConverters.fromIterable(transactions, Transaction.class);
        assertEquals(expected, table);
    }

    /* Todo: FlipTableConverters forces ascending sorting of headers, be able to create desired order */
    @Ignore
    @Test
    public void orderOfHeaders() {
        String[] headerOrder = {"Time", "TransactionType", "Amount", "Balance", "Description"};
    }

}
package io.github.perrymant.moneymaker;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReportRepositoryTest {

    private static final int AMOUNT = 24;
    private static final String DESCRIPTION = "new watch";
    private static final String TIME = "2019-03-02";
    private static final String FILE_NAME = FileUtils.getTempDirectoryPath() + "/file_with_data_append_test";

    private ReportRepository target = new ReportRepository();

    @Test
    public void canReadAndWriteAccountObject() {
        target.write(makeAccount(), FILE_NAME);
        makeAssertions(target.read(FILE_NAME));
    }

    private void makeAssertions(Account retrieved) {
        assertEquals(1, retrieved.getTransactions().size());
        final Transaction transaction = retrieved.getTransactions().get(0);
        assertEquals(transaction.getDescription(), DESCRIPTION);
        assertEquals(transaction.getTime(), TIME);
        assertEquals(transaction.getTransactionType(), TransactionType.DEBIT);
        assertEquals(transaction.getAmount(), AMOUNT);
    }

    private Account makeAccount() {
        final Account account = new Account();
        account.setTransactions(makeTransactionList());
        return account;
    }

    private List<Transaction> makeTransactionList() {
        final List<Transaction> transactions = new ArrayList<>();
        transactions.add(makeTransaction());
        return transactions;
    }

    private Transaction makeTransaction() {
        final Transaction transaction = new Transaction();
        transaction.setAmount(AMOUNT);
        transaction.setDescription(DESCRIPTION);
        transaction.setTransactionType(TransactionType.DEBIT);
        transaction.setTime(TIME);
        return transaction;
    }

}

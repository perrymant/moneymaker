package io.github.perrymant.moneymaker;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountRepositoryTest {

    private static final int AMOUNT = 24;
    private static final String DESCRIPTION = "new watch";
    private static final String TIME = "2019-03-02";
    private static final int BALANCE = 44;
    private static final String FILE_NAME = FileUtils.getTempDirectoryPath() + "/file_with_data_append_test";

    private AccountRepository target = new AccountRepository();

    @Test
    public void canReadAndWriteAccountObject() {
        target.write(makeAccount(), FILE_NAME);
        makeAssertions(target.read(FILE_NAME));
    }

    private void makeAssertions(Account retrieved) {
        assertEquals(1, retrieved.getTransactions().size());
        final ReportLine transaction = retrieved.getTransactions().get(0);
        assertEquals(transaction.getBalance(), BALANCE);
        assertEquals(transaction.getDescription(), DESCRIPTION);
        assertEquals(transaction.getTime(), TIME);
        assertEquals(transaction.getTransactionType(), TransactionType.DEBIT);
        assertEquals(transaction.getAmount(), AMOUNT);
    }

    private Account makeAccount() {
        final Account account = new Account();
        account.setTransactions(makeReportLines());
        return account;
    }

    private List<ReportLine> makeReportLines() {
        final List<ReportLine> transactions = new ArrayList<>();
        transactions.add(new ReportLine(makeTransaction(), BALANCE));
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

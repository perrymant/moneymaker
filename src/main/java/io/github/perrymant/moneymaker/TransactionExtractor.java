package io.github.perrymant.moneymaker;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

class TransactionExtractor {
    private String DATE_TIME;
    private int AMOUNT;
    private TransactionType TRANSACTION_TYPE;
    private String DESCRIPTION;

    List<Transaction> extractComponents(String transactionExample) {
        String inputString = transactionExample;
        String pattern = "(\\w+)\\s(-?\\d+\\.?\\d+)\\s\"(.+)\"\\s(\\d{4}-\\d{2}-\\d{2})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(inputString);
        m.matches();
        DATE_TIME = m.group(4);
        DESCRIPTION = m.group(3);
        AMOUNT = Integer.valueOf(m.group(2));
        TRANSACTION_TYPE = Integer.valueOf(m.group(2)) >= 0 ? TransactionType.CREDIT : TransactionType.DEBIT;
        return getTransactions();
    }

    List<Transaction> getTransactions() {
        return asList(
                makeTransaction(DATE_TIME, TRANSACTION_TYPE, AMOUNT, DESCRIPTION));
    }

    private Transaction makeTransaction(String DATE_TIME, TransactionType TRANSACTION_TYPE, int AMOUNT, String DESCRIPTION) {
        final Transaction transaction = new Transaction();
        transaction.setTime(DATE_TIME);
        transaction.setTransactionType(TRANSACTION_TYPE);
        transaction.setAmount(AMOUNT);
        transaction.setDescription(DESCRIPTION);
        return transaction;
    }


}

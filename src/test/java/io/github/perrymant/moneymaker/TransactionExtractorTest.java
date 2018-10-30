package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionExtractorTest {

    @Test
    public void givenTime() {
        String[] transactionExample = new String[]{"transaction 100 \"A Watch\" 2018-10-30"};
        TransactionExtractor transactionValue = new TransactionExtractor();
        Object output = transactionValue.extractComponents(transactionExample, "time");
        assertEquals("2018-10-30", output);
    }

    @Test
    public void givenDescription() {
        String[] transactionExample = new String[]{"transaction 100 \"A Watch\" 2018-10-30"};
        TransactionExtractor transactionValue = new TransactionExtractor();
        Object output = transactionValue.extractComponents(transactionExample, "description");
        assertEquals("A Watch", output);
    }

    @Test
    public void givenPositiveAmount() {
        String[] transactionExample = new String[]{"transaction 100 \"A Watch\" 2018-10-30"};
        TransactionExtractor transactionValue = new TransactionExtractor();
        Object output = transactionValue.extractComponents(transactionExample, "amount");
        assertEquals("100", output);
    }

    @Test
    public void givenNegativeAmount() {
        String[] transactionExample = new String[]{"transaction -100 \"A Watch\" 2018-10-30"};
        TransactionExtractor transactionValue = new TransactionExtractor();
        Object output = transactionValue.extractComponents(transactionExample, "amount");
        assertEquals("-100", output);
    }

    @Test
    public void givenNegativeType() {
        String[] transactionExample = new String[]{"transaction -100 \"A Watch\" 2018-10-30"};
        TransactionExtractor transactionValue = new TransactionExtractor();
        Object output = transactionValue.extractComponents(transactionExample, "type");
        assertEquals(TransactionType.DEBIT, output);
    }

    @Test
    public void givenPositiveType() {
        String[] transactionExample = new String[]{"transaction 100 \"A Watch\" 2018-10-30"};
        TransactionExtractor transactionValue = new TransactionExtractor();
        Object output = transactionValue.extractComponents(transactionExample, "type");
        assertEquals(TransactionType.CREDIT, output);
    }

}
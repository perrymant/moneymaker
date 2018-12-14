package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionExtractorTest {
    @Test
    public void givenCreditInput_shouldCreateTransaction() {
        // Arrange
        String[] input = new String[]{"transaction", "100", "A Watch", "2018-10-30"};

        // Act
        TransactionExtractor target = new TransactionExtractor();
        Transaction transaction = target.extract(input);

        // Assert
        assertEquals(100, transaction.getAmount());
        assertEquals("A Watch", transaction.getDescription());
        assertEquals("2018-10-30", transaction.getDateTime());
        assertEquals(TransactionType.CREDIT, transaction.getTransactionType());
    }

    @Test
    public void givenDebitInput_shouldCreateTransaction() {
        // Arrange
        String[] input = new String[]{"transaction", "-100", "A Watch", "2018-10-30"};

        // Act
        TransactionExtractor target = new TransactionExtractor();
        Transaction transaction = target.extract(input);

        // Assert
        assertEquals(-100, transaction.getAmount());
        assertEquals("A Watch", transaction.getDescription());
        assertEquals("2018-10-30", transaction.getDateTime());
        assertEquals(TransactionType.DEBIT, transaction.getTransactionType());
    }
}
package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyFormatterTest {
    private MoneyFormatter moneyFormatter = new MoneyFormatter();

    @Test
    public void canIntToCurrencyFormat() {
        int input = 1250;
        String expected = "£12.50";
        assertEquals(expected, moneyFormatter.formatPounds(input));
    }

    @Test
    public void canFormat_0() {
        int input = 0;
        String expected = "£0.00";
        assertEquals(expected, moneyFormatter.formatPounds(input));
    }

    @Test
    public void canFormatNegativeValues() {
        int input = -100;
        String expected = "-£1.00";
        assertEquals(expected, moneyFormatter.formatPounds(input));
    }

    @Test
    public void canFormatSmallerThanAPound() {
        int input = 007;
        String expected = "£0.07";
        assertEquals(expected, moneyFormatter.formatPounds(input));
    }

}



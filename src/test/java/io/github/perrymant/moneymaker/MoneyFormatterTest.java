package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyFormatterTest {

    @Test
    public void canIntToCurrencyFormat() {
        int input = 1250;
        String expected = "£12.50";
        assertEquals(expected, MoneyFormatter.formatPounds(input));
    }

}



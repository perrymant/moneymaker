package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalanceTest {

    @Test
    public void startBalanceIsZero() {
        assertEquals(0.0, new Balance().get(), 0.0f);
    }

}

package io.github.perrymant.moneymaker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BudgetTest {

    private Balance balance = new Balance();
    private List<Transaction> transactions;

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
    public void startCanChangeBalanceValue() {
        Balance balance = new Balance();
        Budget target = makeBudget();
        assertEquals(0, balance.get());
        target.start();
        assertEquals(100, balance.get());
    }

    private Budget makeBudget() {
        return new Budget(balance, transactions);

    }


}
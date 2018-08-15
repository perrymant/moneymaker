package io.github.perrymant.moneymaker;

import com.jakewharton.fliptables.FlipTableConverters;
import org.junit.Test;

import java.util.List;

public class FlipTableTest {
    @Test
    public void test_1() {

        List<Transaction> people = new TransactionMaker().getTransactions();
        System.out.println(FlipTableConverters.fromIterable(people, Transaction.class));
    }
}
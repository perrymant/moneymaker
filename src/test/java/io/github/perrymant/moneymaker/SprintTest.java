package io.github.perrymant.moneymaker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SprintTest {

    @Test
    public void givenReport_returnJSOnResponse() {
        final Balance balance = new Balance();
        List<Transaction> transactions = new DefaultTransactionMaker().getTransactions();
        final Budget budget = new Budget(balance, transactions);
        String response_1 = "" +
                "{\n" +
                "  \"report\": [\n" +
                "    {\n" +
                "      \"date\": \"2018-01-01T00:00:01Z\",\n" +
                "      \"amount\": 125,\n" +
                "      \"balance\": 125,\n" +
                "      \"description\": \"Got Paid\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2018-01-01T00:00:02Z\",\n" +
                "      \"amount\": 125,\n" +
                "      \"balance\": 250,\n" +
                "      \"description\": \"Got Paid\"\n" +
                "    },\n" +
                "        {\n" +
                "      \"date\": \"2018-01-02T00:00:03Z\",\n" +
                "      \"amount\": -72,\n" +
                "      \"balance\": 178,\n" +
                "      \"description\": \"Paid Bill\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String response_2 = "{ \"report\": [ { \"date\": \"2018-01-011T00:00:01Z\", \"amount\": 125, \"balance\": 125, \"description\": \"Got Paid\" }, { \"date\": \"2018-01-011T00:00:02Z\", \"amount\": 125, \"balance\": 250, \"description\": \"Got Paid\" }, { \"date\": \"2018-01-021T00:00:03Z\", \"amount\": -72, \"balance\": 178, \"description\": \"Paid Bill\" } ] }";
        Assert.assertEquals(response_2, budget.reportJSON());
    }

}

package io.github.perrymant.moneymaker;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JSONPersistentDataTest {
    private final String JSONFilePath = System.getProperty("user.home") + "/.moneymaker";
    String expectedJSONObject = "test";
    //    final String expectedJSONObject =
//    { "budget" : [
//        { "time":"2018/01/01",
//          "transactionType":"CREDIT",
//          "amount":125,
//          "description":"Got paid" },
//        { "time":"2018/01/01",
//          "transactionType":"CREDIT",
//          "amount":125,
//          "description":"Got paid"},
//        { "time":"2018/01/02",
//          "transactionType":"DEBIT",
//          "amount":72,
//          "description":"Paid bill"}]}

    @Test
    public void CanWriteJSONObject() {
        Balance balance = new Balance();
        List<Transaction> transactions = new TransactionMaker().getTransactions();
        Budget target = new Budget(balance, transactions);
        JSONPersistentData JSONData = new JSONPersistentData();
        JSONData.writeJSONObject(target);
    }

//
//    @Test
//    public void CanReadJSONObject() {
//        Gson gson = new Gson();
//        JSONPersistentData JSONData = gson.fromJson(JSONFilePath);
//            assertEquals(expectedJSONObject, JSONData);
//    }



}

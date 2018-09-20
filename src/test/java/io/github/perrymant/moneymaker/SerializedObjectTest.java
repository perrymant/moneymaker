package io.github.perrymant.moneymaker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SerializedObjectTest {

    private final String objectFileName = System.getProperty("user.home") + "/.moneymaker";
    private final String dataToWrite = "2019/03/03, CREDIT, 201, 200, Got paid\n2019/03/04, DEBIT, 50, 150, Paid bill\n";
    private final String dataToAppend = "2018/01/01, CREDIT, 202, 200, Got paid\n2018/01/02, DEBIT, 50, 150, Paid bill\n";

    @Test
    public void canSaveSerializedObject() {
        SerializedObject serializedObject = new SerializedObject();
        serializedObject.saveData(dataToWrite, objectFileName);
        assertEquals(dataToWrite, serializedObject.loadData(objectFileName));

    }

    @Test
    public void canSaveBudgetAsJSON() {
        Balance balance = new Balance();
        List<Transaction> transactions = new TransactionMaker().getTransactions();
        Budget target = new Budget(balance, transactions);
        JSONPersistentData JSONData = new JSONPersistentData();
        SerializedObject serializedObject = new SerializedObject();
        serializedObject.saveData(String.valueOf(JSONData), objectFileName);
    }

    @Test
    public void canReadBudgetAsJSON() {
        SerializedObject serializedObject = new SerializedObject();
        System.out.println(serializedObject.loadData(objectFileName));
    }

    @Ignore
    @Test
    public void canSave_AppendAndLoadSerializedObject() {
        SerializedObject serializedObject = new SerializedObject();
        assertEquals((dataToWrite + dataToAppend), serializedObject.loadData(objectFileName));
    }
}

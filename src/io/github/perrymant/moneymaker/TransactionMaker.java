package io.github.perrymant.moneymaker;

import java.util.ArrayList;
import java.util.List;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;
import static io.github.perrymant.moneymaker.TransactionType.DEBIT;

class TransactionMaker {
    List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(makeTransaction());
        transactions.add(makeTransaction());
        transactions.add(makeTransaction_2());
        return transactions;
    }

    private Transaction makeTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTime("2018/01/01");
        transaction.setTransactionType(CREDIT);
        transaction.setAmount(125.50);
        transaction.setDescription("800Kg of diamonds from Sierra Leone");
        return transaction;
    }

    private Transaction makeTransaction_2() {
        Transaction transaction = new Transaction();
        transaction.setTime("2018/01/01");
        transaction.setTransactionType(DEBIT);
        transaction.setAmount(400000000);
        transaction.setDescription("Plumbing bill: callout for issue with storage heater");
        return transaction;
    }


}
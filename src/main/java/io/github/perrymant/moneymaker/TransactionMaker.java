package io.github.perrymant.moneymaker;

import java.util.ArrayList;
import java.util.List;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;

class TransactionMaker {
    List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(makeTransaction());
        transactions.add(makeTransaction());
        transactions.add(makeTransaction());
        return transactions;
    }

    private Transaction makeTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTime("2018/01/01");
        transaction.setTransactionType(CREDIT);
        transaction.setAmount(125);
        transaction.setDescription("Got paid");
        return transaction;
    }


}
package io.github.perrymant.moneymaker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;

class TransactionMaker {
    List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(makeTransaction());
        return transactions;
    }

    private Transaction makeTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(CREDIT);
        transaction.setDate(new Date());
        transaction.setDescription("Latest ");
        transaction.setAmount(100);
        return transaction;
    }
}
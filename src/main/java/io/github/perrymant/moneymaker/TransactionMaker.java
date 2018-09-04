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
        transactions.add(makeTransaction2());
        return transactions;
    }

    private Transaction makeTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTime("2018/01/01");
        transaction.setTransactionType(CREDIT);
        transaction.setAmount(125);
        transaction.setDescription("Got paid");
//        transaction.updateBalance(transaction.getAmount());
        return transaction;
    }

    private Transaction makeTransaction2() {
        Transaction transaction = new Transaction();
        transaction.setTime("2018/01/02");
        transaction.setTransactionType(DEBIT);
        transaction.setAmount(72);
        transaction.setDescription("Paid bill");
//        transaction.updateBalance(transaction.getAmount());
        return transaction;
    }

}
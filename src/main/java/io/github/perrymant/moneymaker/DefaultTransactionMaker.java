package io.github.perrymant.moneymaker;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;
import static io.github.perrymant.moneymaker.TransactionType.DEBIT;

@Service
class DefaultTransactionMaker implements TransactionMaker {
    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(makeTransaction());
        transactions.add(makeTransaction());
        transactions.add(makeTransaction2());
        return transactions;
    }

    private Transaction makeTransaction() {
        Transaction transaction = new Transaction();
        transaction.setDateTime("2018-01-011T00:00:01Z");
        transaction.setTransactionType(CREDIT);
        transaction.setAmount(125);
        transaction.setDescription("Got paid");
        return transaction;
    }

    private Transaction makeTransaction2() {
        Transaction transaction = new Transaction();
        transaction.setDateTime("2018-01-021T00:00:01Z");
        transaction.setTransactionType(DEBIT);
        transaction.setAmount(72);
        transaction.setDescription("Paid bill");
        return transaction;
    }

}
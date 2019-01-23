package io.github.perrymant.moneymaker;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * {
 *   "transactions": [
 *     {
 *       "description": ...,
 *       "date": ...,
 *       "amount": ...,
 *       "transactionType": ...,
 *     },
 *     ...
 *   ]
 * }
 * </pre>
 */
public class Account implements Serializable {
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

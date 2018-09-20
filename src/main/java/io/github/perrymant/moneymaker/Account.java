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
 *       "balance": ...,
 *     },
 *     ...
 *   ]
 * }
 * </pre>
 */
public class Account implements Serializable {
    private List<ReportLine> transactions;

    public List<ReportLine> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ReportLine> transactions) {
        this.transactions = transactions;
    }
}


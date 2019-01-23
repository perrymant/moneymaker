package io.github.perrymant.moneymaker;

import java.util.List;

public class ReportResponse {

    private List<ReportLine> transactions;

    public List<ReportLine> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ReportLine> transactions) {
        this.transactions = transactions;
    }
}



/*
{
  "transactions": [
    {
      "description": "...",
      "date": "...",
      "amount": "...",
      "transactionType": "...",
      "balance": "...",
    },
    "..."
  ]
}

*/
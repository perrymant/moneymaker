package io.github.perrymant.moneymaker;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;
import static io.github.perrymant.moneymaker.TransactionType.DEBIT;

class TransactionExtractor {

    Transaction extract(String[] input) {
        final Transaction result = new Transaction();
        result.setAmount(Integer.parseInt(input[1]));
        result.setDescription(input[2]);
        result.setTime(input[3]);
        result.setTransactionType(result.getAmount() >= 0 ? CREDIT : DEBIT);
        return result;
    }
}
package io.github.perrymant.moneymaker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TransactionExtractor {

    Object extractComponents(String[] transactionExample, String requiredOutput) {
        String inputString = transactionExample[0];
        String pattern = "(\\w+)\\s(-?\\d+\\.?\\d+)\\s\"(.+)\"\\s(\\d{4}-\\d{2}-\\d{2})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(inputString);
        m.matches();
        Object result = null;
        switch (requiredOutput) {
            case "time":
                result = m.group(4);
                break;
            case "description":
                result = m.group(3);
                break;
            case "amount":
                result = m.group(2);
                break;
            case "type":
                if (Integer.valueOf(m.group(2)) >= 0) {
                    result = TransactionType.CREDIT;
                } else {
                    result = TransactionType.DEBIT;
                }
        }
        return result;
    }

}

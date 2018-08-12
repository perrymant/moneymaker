package io.github.perrymant.moneymaker;

class TextWrapper {

    static String wrap(String s) {
        StringBuilder result = new StringBuilder();
        int position = 0;
        for (String remaining : s.split(" ", -1)) {
            if (result.length() - position + remaining.length() > 20) {
                result.append("\n\t\t\t|\t\t\t\t\t|\t\t\t| ").append(remaining);
                position = result.length() + 1;
            } else {
                result.append(result.length() == 0 ? "" : " ").append(remaining);
            }
        }
        return result.toString();
    }

}

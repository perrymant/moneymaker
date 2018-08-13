package io.github.perrymant.moneymaker;

class TextWrapper {

    static String wrap(String s) {
        StringBuilder result = new StringBuilder();
        int position = 0;
        int spacesRemaining = 0;
        for (String nextWord : s.split(" ", -1)) {
            int lineLength = result.length() - position + nextWord.length();
            if (lineLength > 23) {
                result.append("\n\t\t\t|\t\t\t\t\t|\t\t\t\t\t|\t\t\t\t\t| ").append(nextWord);// TODO: newLineFormat
                position = result.length() + 1;
            } else {
                result.append(result.length() == 0 ? "" : " ").append(nextWord);
                spacesRemaining = 23 - lineLength;
            }
        }
        return result.toString();
    }

}
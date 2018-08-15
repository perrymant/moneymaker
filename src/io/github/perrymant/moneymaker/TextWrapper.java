package io.github.perrymant.moneymaker;

class TextWrapper {

    static String wrap(String s) {
        StringBuilder result = new StringBuilder();
        int position = 0;
        int lineCount = -1;
        for (String nextWord : s.split(" ", -1)) {
            int lineLength = result.length() - position + nextWord.length();
            if (lineLength > 32) {
                result.append(String.format("%" + (34 - lineCount) + "s", " ") + "|");
                result.append(String.format("\n|%13s%20s%20s%20s ", "|", "|", "|", "|")).append(nextWord);
                position = result.length() + 1;
                lineCount = nextWord.length();
            } else {
                result.append(result.length() == 0 ? "" : " ").append(nextWord);
                lineCount += nextWord.length() + 1;
            }
        }
        result.append(String.format("%" + (34 - lineCount) + "s", " ") + "|");

        return result.toString();
    }

}
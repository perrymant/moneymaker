package io.github.perrymant.moneymaker;

public class Moneymaker {
    public static void main(String[] args) {
        new Budget(new Balance(), new TransactionMaker().getTransactions()).start();
    }
}


// Main classes should be ~1 line. There is not much need to test it.
// avoid OR/AND in a method/class names.
// only 1 public class per file.
//Paste class code when in the "Project pane" -> auto generate class.
// POJOs get tested through their use in other classes.
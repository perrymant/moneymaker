[![Build Status](https://travis-ci.org/perrymant/moneymaker.svg?branch=sprint-2)](https://travis-ci.org/perrymant/moneymaker) 
![GitHub](https://img.shields.io/github/license/mashape/apistatus.svg) 
![GitHub package version](https://img.shields.io/github/package-json/v/badges/shields.svg)


budget calculator
1. user input (hardcoded)
    1. String date
    1. String description
    1. int amount
    1. int outgoing
1. display to user
    1. int balance projection
<<<<<<< HEAD

Classes in use:
=======
 Default considerations: seed data, testing, documentation.
 Classes in use:
>>>>>>> b501cd59f02d273b9d0ae5d38276bb73a5193ca3
1. Moneymaker (main method)
    - creates a new Budget using:
    - new Budget(new Balance(), new TransactionMaker().getTransactions());
    - Logger.info(budget.report())
1. Budget: (T)
    - Budget(Balance balance, List<Transaction> transactions)
    - .updateBalance()
    - .printBalance()
1. Balance: (T)
    - .get()
    - .increment(int i)
1. TransactionType:
    - Enum: CREDIT, DEBIT.
1. Transaction: (a POJO)
    - String time
    - TransactionType transactionType: (enum CREDIT/DEBIT)
    - int amount
    - String description
    - .reportStringFormat()
1. TransactionMaker
    - Hardcode the transactions with makeTransaction()
    - Uses the Transaction object
<<<<<<< HEAD
1. Logger:
    - info(String)
1. ReportLine: (T)
    - Transaction transaction
    - int balance
    - Reportline(transaction, balance)
    - .toString()

TODO: Format output: spacing
TODO: input/output to csv file
=======
1. Transaction: (a POJO)
     - String time
     - TransactionType transactionType: (enum CREDIT/DEBIT)
     - int amount
     - String description
     - String reportStringFormat()
     Todo: should reportStringFormat() be in it's own class?
 transaction.reportStringFormat() should look like:
UTC, transactionType, value, description, balance after transaction.
 TODO: unable to print balance after each transaction - I can only print the final balance.
- tried to do this in the Budget.printBalance() for loop with budget.get()...
- tried to add a budget field in the Transaction class with getters/setters...
 Todo: the tests are getting incomprehensible - it suggest the program needs alteration.
I feel that the makeTransactionFromArgs() method should be part of the program,
somehow replacing aspects of the TransactionMaker class - but I'm worried a chance here will require
many changes throughout the program.
 Transaction + Balance --> ReportLine
 
TODO:
1. The original README.md was deleted from this branch. Are there other files missing?
1. FlipTableTest: I want main to be able to use the FlipTable, but I am unsuccessful with using the .fromIterable method, 
so instead I want to use FlipTableConverters.fromObjects. While I have a header, the second argument needs to be of 
String[][] type. This suggests I need to update the Budget.report() method - so that the steam converts this to nested arrays.
>>>>>>> b501cd59f02d273b9d0ae5d38276bb73a5193ca3

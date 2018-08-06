# moneymaker

budget calculator
1. user input (hardcoded)
    1. String date
    1. String description
    1. int amount
    1. int outgoing
1. display to user
    1. int balance projection

Classes in use:
1. Moneymaker (main method)
    - creates a new Budget using:
    - new Budget(new Balance(), new TransactionMaker().getTransactions()).printReport();
    Todo: is TransactionMaker really the most simple way to get data into the system?
1. Budget:
    - Budget(Balance balance, List<Transaction> transactions)
    - updateBalance()
    - printBalance()
1. Balance:
    - get()
    - increment(int i)
1. TransactionMaker
    - Hardcode the transactions with makeTransaction()
    - Uses the Transaction object
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
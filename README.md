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
1. Logger:
    - info(String)
1. ReportLine: (T)
    - Transaction transaction
    - int balance
    - Reportline(transaction, balance)
    - .toString()

http://patorjk.com/software/taag/#p=display&f=Big%20Money-ne&t=MoneyMaker

TODO: input/output to csv file
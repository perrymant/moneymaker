[![Build Status](https://travis-ci.org/perrymant/moneymaker.svg)](https://travis-ci.org/perrymant/moneymaker)
![GitHub](https://img.shields.io/github/license/perrymant/moneymaker.svg)

```
 /$$      /$$     Welcome to ...                      /$$      /$$           /$$
| $$$    /$$$                                        | $$$    /$$$          | $$
| $$$$  /$$$$  /$$$$$$  /$$$$$$$   /$$$$$$  /$$   /$$| $$$$  /$$$$  /$$$$$$ | $$   /$$  /$$$$$$   /$$$$$$
| $$ $$/$$ $$ /$$__  $$| $$__  $$ /$$__  $$| $$  | $$| $$ $$/$$ $$ |____  $$| $$  /$$/ /$$__  $$ /$$__  $$
| $$  $$$| $$| $$  \ $$| $$  \ $$| $$$$$$$$| $$  | $$| $$  $$$| $$  /$$$$$$$| $$$$$$/ | $$$$$$$$| $$  \__/
| $$\  $ | $$| $$  | $$| $$  | $$| $$_____/| $$  | $$| $$\  $ | $$ /$$__  $$| $$_  $$ | $$_____/| $$
| $$ \/  | $$|  $$$$$$/| $$  | $$|  $$$$$$$|  $$$$$$$| $$ \/  | $$|  $$$$$$$| $$ \  $$|  $$$$$$$| $$
|__/     |__/ \______/ |__/  |__/ \_______/ \____  $$|__/     |__/ \_______/|__/  \__/ \_______/|__/
                                            /$$  | $$
                                           |  $$$$$$/     ... Gold don't get old
                                            \______/
```

# A Budget Calculator

### Classes & Methods in use:
1. Moneymaker (main method)
    - Prints a report:
    - new Logger().info(budget.report());
1. Balance:
    - get()
    - increment(int i)
1. Budget:
    - Budget(Balance balance, List<Transaction> transactions)
    - report()
    - createData()
    - updateBalance()
1. FileIO:
    - read(String fileName)
    - write(String data, String fileName)
    - append(String dataToAppend, String fileName)
1. Logger:
    - info(String string)
1. ReportLine:
    - getRowItems()
1. Transaction: (a POJO)
     - String time
     - TransactionType transactionType: (enum CREDIT/DEBIT)
     - int amount
     - String description
1. TransactionMaker:
    - makeTransaction()
    - getTransactions


# Sprint details:

### Armadillo Sprint: 18 Jul
The budget calculator should:
1. store the date in the format YYYY/MM/DD.
1. store a short textual description.
1. store a value for incoming money as an integer.
1. store a value for outgoing money as an integer.
1. display the balance as an integer.

### Bear Sprint: 25 Jul
The budget calculator should:
1. have documentation in README.md.
1. add a formatter for converting transactions into Strings.
1. have transactions with a credit/debit TransactionType.
1. have hardcoded transactions, and these are created with the TransactionMaker Class.
1. report the balance after each transaction.

### Camel Sprint: 8 Aug
The budget calculator should:
1. have a formatted output ReportLine class that combines the Transactions and Balance.
1. read/write input/output to a file.
1. have a balance that updates after every transaction.

### Dragonfly Sprint: 15 Aug
The budget calculator should:
1. have Gradle as its build automation tool.
1. have a Travis CI status shield visible in README.md, to show passing status on Github.
1. make use of FlipTable library to display data in a formatted table.

### Eagle Sprint: 5 Sept
The budget calculator should:
1. have its table headers displayed in specific order: Date, TransactionType, Amount, Budget, Description.
1. make use of file IO: read/write/append from/to a file.

### Frog Sprint: 12 Sept
The budget calculator should:
1. have improved documentation with details of individual sprint requirements.
1. take input and make it persistent, then when called again without arguments have it print a report of all the previous persistent data. Use a dot folder in $HOME/.moneymaker, where a data file resides, using the JSON format.


#### Improvement notice:
- The budget calculator should display the date in and ISO 8601 date format (YYYY-MM-DD)

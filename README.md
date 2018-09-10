[![Build Status](https://travis-ci.org/perrymant/moneymaker.svg)](https://travis-ci.org/perrymant/moneymaker)
![GitHub](https://img.shields.io/github/license/perrymant/moneymaker.svg)


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
# A Budget Calculator

### Requirements:
1. user input (hardcoded)
    1. String date
    1. String description
    1. int amount
    1. int outgoing
1. display to user
    1. int balance projection
 Default considerations: seed data, testing, documentation.
 
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

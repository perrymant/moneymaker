# Engineering design

This document seeks to convey how the commands flow through the code, and will highlight the public methods available.
Additionally, the details of external resources will also be given.

### The basic outline of the Moneymaker app is that a user can:
- make a `transaction`
- generate a `report` to view transactions

#### An overview:
The transactions are stored and retrieved to and from the user's folder on their local drive at the location "~/.moneymaker". However, it is the filename that decides which account is being used to store transactions - therefor the system could (to be fulfilled on a future sprint) implement the possibility of allowing the user to choose the account, and view all historical transactions. At the moment, transactions can only be added to the file - there is no method of deleting transactions.  Furthermore, a report can be generated from these stored transactions for the user to view historic transactions and their balance. If no choice is made, or an erroneous choice is selected, then the application will print out a help file with the list of commands (to be implemented on a future sprint).

## User requesting `transaction`:
When `Main` is called, it starts the `Application` class, where a choice may be made to create a `transaction`. When a transaction is made by an `amount`, the application will determine if it is a deposit or withdrawal (inferred via the presence of a negative sign). The transaction may include a `time` (in ISO 8601 date format [YYYY-MM-DD]) and a `description`. A running `budget` is then calculated after each transaction.

This should force you to consider which methods on which class is required to record transactions - which I think we might be missing in this design no

A diagram that illustrates the logic flow when a user records a transaction is as follows:
![Moneymaker CD2 UML](moneymaker-CD2-v1.png "Moneymaker CD2 UML")

## User requesting `report`:

If a `report` is called for, then the `ReportLine` class will concatenate the Transaction and Balance instances of all transactions and display these in a table. The instances of the `Account` class can be read and written from and to the filesystem using the `read` and `write` methods respectively.

In more detail then, the class diagram that displays the logic flow when the user requests a report is as follows:
![Moneymaker CD1 UML](moneymaker-CD1-v1.png "Moneymaker CD1 UML")


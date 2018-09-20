The budget calculator should have a way of adding transactions to an account. 

The following requests should be implemented:

| Request            | CLI command                                            |
|:-------------------|:-------------------------------------------------------|
| Make a deposit:    | $java moneymaker -debit <amount> <description> <date>  |
| Make a withdrawal: | $java moneymaker -credit <amount> <description> <date> |
| Check balance:     | $java moneymaker -log                                  |

If no parameters are given to `$java moneymaker` then the application will display all the possible commands in the format:

```
Error: no arguments given to Moneymaker
NAME:
    moneymaker -- a budget calculator.
SYNOPSIS:
    moneymaker [-debit | -credit][<amount>][<description>][<date>]
    moneymaker [-log]
DESCRIPTION:
    moneymaker is able to take credit and debit transactions, 
    and then display these as a report.
OPTIONS:
    -credit [amount] [description] [date]
        To add credit you must add a description. 
        If no date is provided then the current date will be used.
    -debit [amount] [description] [date]
        To perform a debit you must add a description. 
        If no date is provided then the current date will be used.
    -log
        The log command will print out all transactions in a table
EXAMPLES:
    $java moneymaker -credit 125 "Got paid" 2018-01-01
    $java moneymaker -credit 125 "Got paid" 2018-01-01
    $java moneymaker -debit 72 "Paid bill" 
    
    $java moneymaker -log
    
    Moneymaker output:
      ╔════════════╤══════════════════╤════════╤═════════╤═════════════╗
      ║ Time       │ Transaction Type │ Amount │ Balance │ Description ║
      ╠════════════╪══════════════════╪════════╪═════════╪═════════════╣
      ║ 2018-01-01 │ CREDIT           │ 125    │ 125     │ Got paid    ║
      ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢
      ║ 2018-01-01 │ CREDIT           │ 125    │ 250     │ Got paid    ║
      ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢
      ║ 2018-01-02 │ DEBIT            │ 72     │ 178     │ Paid bill   ║
      ╚════════════╧══════════════════╧════════╧═════════╧═════════════╝

HISTORY:
     more info at https://github.com/perrymant/moneymaker
```
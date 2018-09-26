# Product design

Please see the accompanying [Engineering Design](engineering-design.md).

The budget calculator should have a way of adding transactions to an account.

The following requests should be implemented:

| Request              | CLI command                                            |
|:---------------------|:-------------------------------------------------------|
| Account transaction: | `moneymaker transaction <amount> <description> <date>` |
| Check balance:       | `moneymaker report`                                    |
| Help                 | `moneymaker help`                                      |

Notes:
- The amount can be positive and negative. 
- A description **must** be included and surrounded by quotation marks.
- the date **must** be given in the format `YYYY-MM-DD`
- If no arguments, or erroneous arguments are given to `moneymaker` then the application will display:

>Error: Invalid argument: 
`moneymaker help` 
>for more info.


The `help` documentation:
```
moneymaker help
NAME:
    moneymaker -- a budget calculator.
SYNOPSIS:
    moneymaker [transaction] [<amount>]["<description>"][<date>]
    moneymaker [report]
    moneymaker [help]
DESCRIPTION:
    moneymaker is able to take credit and debit transactions,
    and then display these as a report.
OPTIONS:
    transaction [<amount>]["<description>"][<date>]
        To add credit you must add a description.
        If no date is provided then the current date will be used.
    report
        The report command will print out all transactions in a table.
    help
        This documentation.
EXAMPLES:
    moneymaker transaction 125 "Got paid" 2018-01-01
    moneymaker transaction 125 "Got paid" 2018-01-01
    moneymaker transaction -72 "Paid bill"
    moneymaker report

    *** Output ***
      ╔════════════╤══════════════════╤════════╤═════════╤═════════════╗
      ║ Time       │ Transaction Type │ Amount │ Balance │ Description ║
      ╠════════════╪══════════════════╪════════╪═════════╪═════════════╣
      ║ 2018-01-01 │ CREDIT           │ 125    │ 125     │ Got paid    ║
      ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢
      ║ 2018-01-01 │ CREDIT           │ 125    │ 250     │ Got paid    ║
      ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢
      ║ 2018-01-02 │ DEBIT            │ 72     │ 178     │ Paid bill   ║
      ╚════════════╧══════════════════╧════════╧═════════╧═════════════╝
```

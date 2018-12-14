# Product design

Please see the accompanying [Engineering Design](engineering-design.md).

The budget calculator should have a way of adding transactions to an account.

The following requests should be implemented:

| Request              | CLI command                                                |
|:---------------------|:-----------------------------------------------------------|
| Account transaction: | `moneymaker transaction <amount> <description> <dateTime>` |
| Check balance:       | `moneymaker report`                                        |
| Help                 | `moneymaker help`                                          |

Notes:
- The amount can be positive and negative. 
- A description **must** be included and surrounded by quotation marks.
- the dateTime **must** be given in the format `YYYY-MM-DDTHH:MM:SSZ`
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
    moneymaker [transaction] [<amount>]["<description>"][<dateTime>]
    moneymaker [report]
    moneymaker [help]
DESCRIPTION:
    moneymaker is able to take credit and debit transactions,
    and then display these as a report.
OPTIONS:
    transaction [<amount>]["<description>"][<dateTime>]
        To add credit you must add a description.
        If no dateTime is provided then the current dateTime will be used.
    report
        The report command will print out all transactions in a table.
    help
        This documentation.
EXAMPLES:
    moneymaker transaction 125 "Got paid" 2018-01-01T00:00:01Z
    moneymaker transaction 125 "Got paid" 2018-01-01T00:00:01Z
    moneymaker transaction -72 "Paid bill"
    moneymaker report

    *** Output ***
    ╔════════════╤══════════════════╤════════╤═════════╤═════════════╗
    ║ DateTime   │ Transaction Type │ Amount │ Balance │ Description ║
    ╠════════════╪══════════════════╪════════╪═════════╪═════════════╣
    ║ 2018-01-04 │ CREDIT           │ £1.25  │ £1.25   │ Got paid    ║
    ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢
    ║ 2018-01-02 │ DEBIT            │ £0.72  │ £0.53   │ Paid bill   ║
    ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢
    ║ 2018-01-01 │ CREDIT           │ £1.25  │ £1.78   │ Got paid    ║
    ╚════════════╧══════════════════╧════════╧═════════╧═════════════╝
```

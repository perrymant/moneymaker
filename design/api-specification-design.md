# api-specification-design
Personal notes about REST API design [here](https://github.com/perrymant/learning-notes/blob/master/17-rest-api-design.md)

## HTTP Headers for all methods:
Content-Type: application/json
Accept: application/json

## 1. help
The user asks for `help` and obtains the help document.

#### Request
| Method | URL |
|--------|-----|
| GET   | api/help/ |

#### Response

- 200  Response will be an object containing the `help documentation statement`:

`{
    status : "success",
    data : {
        "help" : "---help documentation statement---"
     }
}`

- 400  ">Error: Invalid argument: `moneymaker help` >for more info.":

`{
    "status" : "fail",
    "data" : { "Error" : "Error: Invalid argument:\nmoneymaker help \nfor more info." }
}`

- 500  "Something went wrong. Please try again later.":

`{
    "status" : "error",
    "message" : "Unable to communicate with database"
}`


- Note: The `help documentation statement` for status code 200:

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
        ║ 2018-01-02 │ DEBIT            │ £0.72  │ £1.78   │ Paid bill   ║
        ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢
        ║ 2018-01-01 │ CREDIT           │ £1.25  │ £2.50   │ Got paid    ║
        ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢
        ║ 2018-01-01 │ CREDIT           │ £1.25  │ £1.25   │ Got paid    ║
        ╚════════════╧══════════════════╧════════╧═════════╧═════════════╝
```

## 2. report
The user asks for `report` and obtains the report of their account.

#### Request
| Method | URL |
|--------|-----|
| GET   | api/report/ |

#### Response
- 200: a `report statement` will be sent:

`{
    status : "success",
    data : {
        "report" : "---report statement---"
     }
}`

- 400:  ">Error: Invalid argument: `moneymaker help` >for more info.":

`{
    "status" : "fail",
    "data" : { "Error" : "Error: Invalid argument:\nmoneymaker help \nfor more info." }
}`

- 500:  "Something went wrong. Please try again later.":

`{
    "status" : "error",
    "message" : "Unable to communicate with database"
}`

`report statement` for status code 200:

## 3. transaction
The user makes a transaction and sends it to update their account.

#### Request
| Method | URL |
|--------|-----|
| PUT   | api/transaction-amount-description-date/ |

#### Response

- 200: A `transaction statement` will be sent:
`{
    status : "success",
    data : {
           "transactions": [
             {
               "description": ...,
               "date": ...,
               "amount": ...,
               "transactionType": ...,
               "balance": ...,
             },
             ...
           ]
           }
}`

- 400:  ">Error: Invalid argument: `moneymaker help` >for more info.":

`{
    "status" : "fail",
    "data" : { "Error" : "Error: Invalid argument:\nmoneymaker help \nfor more info." }
}`

- 500:  "Something went wrong. Please try again later.":

`{
    "status" : "error",
    "message" : "Unable to communicate with database"
}`




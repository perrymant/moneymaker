# api-specification-design
Personal notes about REST API design [here](https://github.com/perrymant/learning-notes/blob/master/17-rest-api-design.md)

## 1. report
The `report` request obtains a report of their account.

#### Request
| Method | URL         |
|--------|-------------|
| GET    | api/report  |

#### Response
- 200: a `report statement` will be sent:

```json
{
    "data" : {
        "report" : "---report statement-(see below)---"
     }
}
```

An example `report statement` for status code 200 :
```
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

- 500:  "Something went wrong. Please try again later.":

```json
{
    "status" : "error",
    "message" : "Something went wrong. Please try again later."
}
```



## 2. transaction
A `transaction` request sends it to update their account.

#### Request
| Method | URL             |
|--------|-----------------|
| POST   | api/transaction |

#### Response

- 200: A `transaction statement` will be sent:
```json
{
  "transactions": [...]
}
```

- 400:  ">Error: Invalid argument: `moneymaker help` >for more info.":

```json
{
    "status" : "fail",
    "data" : { "Error" : "Error: amount missing" }
}
```

- 500:  "Something went wrong. Please try again later.":

```json
{
    "status" : "error",
    "message" : "Unable to communicate with database"
}
```




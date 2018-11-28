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
```
{
"data" : {
    "report" : [
                  {
                    "date": "ISO8601 format",
                    "amount": "in GBP pence",
                    "balance": "in GBP pence",
                    "description": "short text",
                  },
                  ...
                ]
         }
}
```

- 500:  "Something went wrong. Please try again later.":
```json
{
    "message" : "Something went wrong. Please try again later."
}
```

## 2. transaction
A `transaction` request is sent to append a new transaction to an account.

#### Request
| Method | URL             |
|--------|-----------------|
| POST   | api/transaction |

#### Response

- 200: A `transaction statement` will be sent:
```
{
"transaction": {
    "date": "ISO 8601 format YYYY-MM-DD",
    "amount": "in GBP pence",
    "description": "short text",
  }
}
```

- 400:  "The request contains bad syntax or cannot be completed.":
```json
{
    "data" : { "Error" : "The request contains bad syntax or cannot be completed." }
}
```

- 500:  "Something went wrong. Please try again later.":
```json
{
    "message" : "Something went wrong. Please try again later."
}
```




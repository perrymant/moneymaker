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
  "report": [
    {
      "date": "2018-11-28T17:34:45Z",
      "amount": 1234,
      "balance": 12345678,
      "description": "blah"
    }
  ]
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
```json
{
  "transaction": {
    "date": "2018-11-28T17:34:45Z",
    "amount": 1234,
    "description": "blah"
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
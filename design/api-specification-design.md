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
{
"report": [
  {
    "date": ...,
    "amount": ...,
    "balance": ...,
    "description": ...,
  },
  ...
]
}
```

- 500:  "The server failed to fulfill an apparently valid request.":

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
    "date": ...,
    "amount": ...,
    "description": ...,
  }
}
```

- 400:  "The request contains bad syntax or cannot be fulfilled.":

```json
{
    "data" : { "Error" : "The request contains bad syntax or cannot be fulfilled." }
}
```

- 500:  "The server failed to fulfill an apparently valid request.":

```json
{
    "message" : "The server failed to fulfill an apparently valid request."
}
```




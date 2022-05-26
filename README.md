# API
### Register
Request </p>
Method: **POST** <p>
_URL: **/v1/users/register**_

Request body: <p>
```json
{
  "firstname": "Valerii",
  "lastname": "Nikitin",
  "phone-numbers": ["0667842311"],
  "email-addresses": ["vn@gmail.com"],
  "username": "vampir666",
  "password": "12345",
  "notifications": [
    {
      "app": "telegram",
      "frequency": 3
    },
    {
      "app": "viber",
      "frequency": 6
    }
  ],
  "location-id": 55
}
```
Response body</p>

HTTP status: **200** <p>
```json
{
  "id": 13
}
```
### Authorization
Request </p>
Method: **POST** <p>
_URL: **v1/users/auth**_

Request body: <p>
```json
{
  "username": "Bogdan1980",
  "password": "12345"
}
```
Response body</p>

HTTP status: **200** <p>
```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCb2dkYW4xOTgwIiwiZXhwIjoxNjU0MjAzNjAwfQ.tu8Dv5U6MRN6hFMnoI5AXQ0htUZVe0Xd9iF6Iy9mohL3tZqRkNKcszcLqqCWeebXp4h4mBJvipLmtzRubbZYUg"
}
```

## Advertisements
### Create
Request </p>
Method: **POST** <p>
_URL: **v1/advertisements**_

Request body: <p>
```json
{
  "pet-name": "Jerry",
  "signs": ["black spot", "white color"],
  "age": 2,
  "type": "FOUND | LOST | OBSERVED",
  "location": {
    "city": "Kyiv",
    "district": "Solomenskiy",
    "street": "Shevchenka"
  },
  "date": {
    "day": 13,
    "month": 5,
    "year": 2021
  }
}
```
Response body</p>

HTTP status: **200** <p>
```json
{
  "id": 13
}
```

### Get
Request </p>
Method: **GET** <p>
_URL: **v1/advertisements**_
Request body:
```json
{
    "pov": "OWNER | VIEWER",
    "paged": {
      "current": 2,
      "size": 6
    }
  }
```

Response body</p>
HTTP status: **200** <p>
```json
{
  "ids": [
    13,
    15,
    19
  ]
}
```

### Get by ID
Request </p>
Method: **GET** <p>
_URL: **/v1/advertisements/{advertisementId}**_

Response body</p>
HTTP status: **200** <p>
```json
{
  "pet-name": "Jerry",
  "signs": ["black spot", "white color"],
  "age": 2,
  "type": "FOUND | LOST | OBSERVED",
  "location-id": 56,
  "date": {
    "day": 13,
    "month": 5,
    "year": 2021
  }
}
```
HTTP status: **404** <p>
```json
{
  "error-id": 1,
  "error-msg": "Not found"
}
```

### Delete by ID
Request </p>
Method: **DELETE** <p>
_URL: **/v1/advertisements/{advertisementId}**_

Response body</p>
HTTP status: **200** <p>
```json
{
  "msg": "Ok"
}
```

### Update by ID
Request </p>
Method: **PUT** <p>
_URL: **/v1/advertisements/{advertisementId}**_

Request body: <p>
```json
{
  "pet-name": "Jerry",
  "signs": ["black spot", "white color"],
  "age": 2,
  "type": "FOUND | LOST | OBSERVED",
  "location": {
    "city": "Kyiv",
    "district": "Solomenskiy",
    "street": "Shevchenka"
  },
  "date": {
    "day": 13,
    "month": 5,
    "year": 2021
  }
}
```
Response body</p>

HTTP status: **200** <p>
```json
{
  "id": 13
}
```

## User


### Delete by ID
Request </p>
Method: **DELETE** <p>
_URL: **/v1/users/{userId}**_

Response body</p>
HTTP status: **200** <p>
```json
{
  "msg": "Ok"
}
```

### Update by ID
Request </p>
Method: **PUT** <p>
_URL: **/v1/users/{userId}**_

Request body: <p>
```json
{
  "firstname": "Valerii",
  "lastname": "Nikitin",
  "phone-numbers": ["0667842311"],
  "email-addresses": ["vn@gmail.com"],
  "username": "vampir666",
  "password": "12345",
  "notifications": {
    "apps": ["Telegram", "Viber", "Email"],
    "frequency": 3
  },
  "location-id": 55
}
```
Response body</p>

HTTP status: **200** <p>
```json
{
  "id": 13
}
```

### Get by ID
Request </p>
Method: **GET** <p>
_URL: **/v1/users/{userId}**_

Response body</p>
HTTP status: **200** <p>
```json
{
  "firstname": "Valerii",
  "lastname": "Nikitin",
  "phone-numbers": ["0667842311"],
  "email-addresses": ["vn@gmail.com"],
  "username": "vampir666",
  "password": "12345",
  "notifications": {
    "apps": ["Telegram", "Viber", "Email"],
    "frequency": 3
  },
  "location-id": 55
}
```
HTTP status: **404** <p>
```json
{
  "error-id": 1,
  "error-msg": "Not found"
}
```

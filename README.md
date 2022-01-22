# API

## Advertisements
### Create
Request </p>
Method: **POST** <p>
_URL: **/advertisements**_

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
  },
  "owner-id": 11
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
_URL: **/advertisements**_

Response body</p>
HTTP status: **200** <p>
```json
{
  "advertisement-ids": [
    13,
    15,
    19
  ],
  "params": {
    "pov": "OWNER | VIEWER",
    "paged": {
      "current": 2,
      "size": 6
    }
  }
}
```

### Get by ID
Request </p>
Method: **GET** <p>
_URL: **/advertisements/{advertisementId}**_

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
  },
  "owner-id": 11
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
_URL: **/advertisements/{advertisementId}**_

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
_URL: **/advertisements/{advertisementId}**_

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
  },
  "owner-id": 11
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
### Create
Request </p>
Method: **POST** <p>
_URL: **/users**_

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

### Delete by ID
Request </p>
Method: **DELETE** <p>
_URL: **/users/{userId}**_

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
_URL: **/advertisements/{advertisementId}**_

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
_URL: **/users/{userId}**_

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

## Messenger
### Create chat
TODO

### Send message
TODO

### Get messages


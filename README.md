---
title: Restaurant Management System
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.23"

---

# Restaurant Management System

# Authentication

- HTTP Authentication, scheme: bearer

# Restaurant-Management-System/Auth

## POST login-user

POST /api/v1/auth/login

> Body Parameters

```json
{
  "email": "b@b.com",
  "password": "12345678"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» email|body|string| yes |none|
|» password|body|string| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## POST register

POST /api/v1/auth/register

> Body Parameters

```json
{
  "name": "user",
  "phoneNumber": "0000000000",
  "email": "customer@rest.com",
  "password": "12345678"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» phoneNumber|body|string| yes |none|
|» email|body|string| yes |none|
|» password|body|string| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## PUT resetpass

PUT /api/v1/auth/resetpass

> Body Parameters

```json
{
  "name": "user",
  "phoneNumber": "0000000000",
  "email": "customer@rest.com",
  "password": "987654321"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» phoneNumber|body|string| yes |none|
|» email|body|string| yes |none|
|» password|body|string| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

# Restaurant-Management-System/Admin

## GET getAllUser

GET /api/v1/admin/users

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## GET getUser

GET /api/v1/admin/10

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## DELETE delete

DELETE /api/v1/admin/16

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## POST create-staff

POST /api/v1/admin

> Body Parameters

```json
{
  "name": "aaa",
  "phoneNumber": "0000000000",
  "email": "b@b.com",
  "password": "12345678",
  "role": "MANAGER"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» phoneNumber|body|string| yes |none|
|» email|body|string| yes |none|
|» password|body|string| yes |none|
|» role|body|string| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

# Restaurant-Management-System/Category

## POST post

POST /api/v1/admin/category

> Body Parameters

```yaml
name: five
description: dhfasjhdfkshjdf
image: string

```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» description|body|string| yes |none|
|» image|body|string(binary)| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## PUT update

PUT /api/v1/admin/category

> Body Parameters

```yaml
name: up
description: updated
image: string
id: "1"

```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» description|body|string| yes |none|
|» image|body|string(binary)| yes |none|
|» id|body|string| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## GET getAll

GET /api/v1/admin/category

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## DELETE delete

DELETE /api/v1/admin/category/4

> Body Parameters

```yaml
name: two
description: oneone
image: string

```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» description|body|string| yes |none|
|» image|body|string(binary)| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## GET get

GET /api/v1/admin/category/1

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

# Restaurant-Management-System/Food

## POST create

POST /api/v1/admin/food

> Body Parameters

```yaml
name: dsfffdsa11
description: zeze
image: string
price: "20"
categoryId: "2"
foodCode: F002

```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» description|body|string| yes |none|
|» image|body|string(binary)| yes |none|
|» price|body|string| yes |none|
|» categoryId|body|string| yes |none|
|» foodCode|body|string| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## PUT update

PUT /api/v1/admin/food

> Body Parameters

```yaml
name: up
description: updated
image: string
price: "20"
categoryId: "1"
foodCode: F005
id: "1"

```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» description|body|string| yes |none|
|» image|body|string(binary)| yes |none|
|» price|body|string| yes |none|
|» categoryId|body|string| yes |none|
|» foodCode|body|string| yes |none|
|» id|body|string| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## GET getByName

GET /api/v1/admin/food/1/food/p

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## GET getAll

GET /api/v1/admin/food/1/foods

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## DELETE delete

DELETE /api/v1/admin/food/2

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

# Restaurant-Management-System/Orders

## GET getAll

GET /api/v1/admin/order

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## POST post

POST /api/v1/admin/order

> Body Parameters

```json
{
  "orderCode": "O003",
  "foodCodeList": [
    "F001",
    "F002"
  ],
  "user_id": 18,
  "bill": 69.12
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» orderCode|body|string| yes |none|
|» foodCodeList|body|[string]| yes |none|
|» user_id|body|integer| yes |none|
|» bill|body|number| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## PUT update

PUT /api/v1/admin/order

> Body Parameters

```json
{
  "orderCode": "O003",
  "foodCodeList": [
    "F003",
    "F005"
  ],
  "user_id": 18,
  "bill": 59.12
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» orderCode|body|string| yes |none|
|» foodCodeList|body|[string]| yes |none|
|» user_id|body|integer| yes |none|
|» bill|body|number| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## GET getByCode

GET /api/v1/admin/order/ordr_O002

> Body Parameters

```json
{
  "orderCode": "O003",
  "foodCodeList": [
    "F001",
    "F002"
  ],
  "user_id": 18,
  "bill": 69.12
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» orderCode|body|string| yes |none|
|» foodCodeList|body|[string]| yes |none|
|» user_id|body|integer| yes |none|
|» bill|body|number| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## DELETE delete

DELETE /api/v1/admin/order/3

> Body Parameters

```json
{
  "orderCode": "O003",
  "foodCodeList": [
    "F001",
    "F002"
  ],
  "user_id": 18,
  "bill": 69.12
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» orderCode|body|string| yes |none|
|» foodCodeList|body|[string]| yes |none|
|» user_id|body|integer| yes |none|
|» bill|body|number| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

# Restaurant-Management-System/Reservation

## POST post

POST /api/v1/reservation

> Body Parameters

```json
{
  "reservationCode": "RSV001",
  "amountOfPeople": 3,
  "slotTime": "2020-05-30T09:45:15",
  "user_id": 21
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» reservationCode|body|string| yes |none|
|» amountOfPeople|body|integer| yes |none|
|» slotTime|body|string| yes |none|
|» user_id|body|integer| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## PUT update

PUT /api/v1/reservation

> Body Parameters

```json
{
  "reservationCode": "RSV001",
  "amountOfPeople": 10,
  "slotTime": "2020-05-30T09:45:15",
  "user_id": 21
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» reservationCode|body|string| yes |none|
|» amountOfPeople|body|integer| yes |none|
|» slotTime|body|string| yes |none|
|» user_id|body|integer| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## GET getAll

GET /api/v1/reservation

> Body Parameters

```json
{
  "reservationCode": "RSV001",
  "amountOfPeople": 5,
  "slotTime": "2019-04-28T14:45:15",
  "user_id": 21
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» reservationCode|body|string| yes |none|
|» amountOfPeople|body|integer| yes |none|
|» slotTime|body|string| yes |none|
|» user_id|body|integer| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## GET getByCode

GET /api/v1/reservation/res_RSV002

> Body Parameters

```json
{
  "reservationCode": "RSV001",
  "amountOfPeople": 10,
  "slotTime": "2020-05-30T09:45:15",
  "user_id": 21
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» reservationCode|body|string| yes |none|
|» amountOfPeople|body|integer| yes |none|
|» slotTime|body|string| yes |none|
|» user_id|body|integer| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

## DELETE delete

DELETE /api/v1/reservation/4

> Body Parameters

```json
{
  "reservationCode": "RSV001",
  "amountOfPeople": 5,
  "slotTime": "2019-04-28T14:45:15",
  "user_id": 21
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» reservationCode|body|string| yes |none|
|» amountOfPeople|body|integer| yes |none|
|» slotTime|body|string| yes |none|
|» user_id|body|integer| yes |none|

> Response Examples

> 200 Response



### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Success|Inline|

### Responses Data Schema

# Data Schema


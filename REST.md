# Progamozói dokumentáció - REST

## Előszó
Az REST API a http://localhost:8080/api/ endpointon keresztül érhető el.

Az alábbi HTTP request típusokkal operál:
- GET
- PUT
- POST
- DELETE

Az API-on keresztül az alábbi műveletek érhetőek el:

## Place

### GET /api/places/
Visszaadja az összes nyílvántartott helyet.
#### Kivételek:
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
[
    {
        "id": 1,
        "name": "ExamplePlace",
        "googleCode": "ABC123",
        "longitude": 1.0,
        "latitude": -1.0,
        "organization": null
    }
]
```

### GET /api/places/{id}
Visszaadja az adott ID-jú hely adatait.
#### Path Paraméterek:
- id : ID

#### Kivételek:
- Hibás ID esetén Bad Request hibakódoit küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
GET localhost:8080/api/places/1
```

```
{
    "id": 1,
    "name": "ExamplePlace",
    "googleCode": "ABC123",
    "longitude": 1.0,
    "latitude": -1.0,
    "organization": null
}
```

### POST /api/places/
Létrehoz egy nyílvántartandó helyet.
#### Paraméterek:
- name : Név
- googleCode : Google Térkép kód
- longitude : Hosszúsági koordináta
- latitude: Szélességi koordináta
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
POST localhost:8080/api/places/?name=ExamplePlace&googleCode=ABC123&longitude=1&latitude=-1
```

```
{
    "id": 1,
    "name": "ExamplePlace",
    "googleCode": "ABC123",
    "longitude": 1.0,
    "latitude": -1.0,
    "organization": null
}
```

## Organization

### GET /api/organizations/
Visszaadja az összes nyílvántartott szervezetet.
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.


Példa:

```
GET localhost:8080/api/organizations
```

```
[
    {
        "id": 2,
        "name": "ExampleOrganization",
        "teams": [],
        "headQuarter": null
    }
]
```

### GET /api/organizations/{id}
Visszaadja az adott ID-jú szervezet adatait.
#### Path Paraméterek:
- id : ID

#### Kivételek:
- Hibás ID esetén Bad Request hibakódoit küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
GET localhost:8080/api/organizations/2
```

```
{
    "id": 2,
    "name": "ExampleOrganization",
    "teams": [],
    "headQuarter": null
}
```

### PUT /api/organizations/
Létrehoz egy nyílvántartandó szervezetet.
#### Paraméterek:
- name : Név
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
PUT localhost:8080/api/organizations/?name=ExampleOrganization
```

```
{
    "id": 2,
    "name": "ExampleOrganization",
    "teams": [],
    "headQuarter": null
}
```

### POST /api/organizations/{id}/hq
Beállítja az adott szervezet telephelyét.
#### Path Paraméterek:
- id : Szervezet ID
#### Paraméterek:
- place_id : Hely ID
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
POST localhost:8080/api/organizations/2/hq?place_id=1
```

```
{
    "id": 2,
    "name": "ExampleOrganization",
    "teams": [],
    "headQuarter": {
        "id": 1,
        "name": "ExamplePlace",
        "googleCode": "ABC123",
        "longitude": 1.0,
        "latitude": -1.0,
        "organization": null
    }
}
```

## AppUser

### GET /api/appusers/
Visszaadja az összes nyílvántartott felhasználót.
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.


Példa:

```
GET localhost:8080/api/appusers
```

```
[
    {
        "id": 3,
        "email": "gj@example.com",
        "username": "gipszjakab",
        "password": "gj2",
        "events": [],
        "todos": [],
        "team": null
    }
]
```

### GET /api/appusers/{id}
Visszaadja az adott ID-jú felhasználó adatait.
#### Path Paraméterek:
- id : ID

#### Kivételek:
- Hibás ID esetén Bad Request hibakódoit küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
GET localhost:8080/api/appusers/3
```

```
{
        "id": 3,
        "email": "gj@example.com",
        "username": "gipszjakab",
        "password": "gj2",
        "events": [],
        "todos": [],
        "team": null
}
```

### PUT /api/appusers/
Létrehoz egy felhasználót.
#### Paraméterek:
- email : Email cím
- username : Név
- password : Jelszó
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Egy már nyílvátartásban felhasználónév vagy email regisztrálása nem lehetséges. Ez esetben Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
PUT localhost:8080/api/appusers?username=gipszjakab&password=gj2&email=gjakab@example.com
```

```
{
        "id": 3,
        "email": "gj@example.com",
        "username": "gipszjakab",
        "password": "gj2",
        "events": [],
        "todos": [],
        "team": null
}
```

### POST /api/appusers/{id}
Módosítja az adott felhasználó adatait.
#### Path Paraméterek:
- id : Felhasználó ID
#### Paraméterek:
- email : Új emailcím
- username : Új felhasználónév
- password : Új jelszó
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
POST localhost:8080/api/appusers/2?username=gipszjakab&email=gj2@example.com&password=gj3
```

```
{
    "id": 3,
    "email": "gj2@example.com",
    "username": "gipszjakab",
    "password": "gj3",
    "events": [],
    "todos": [],
    "team": null
}
```

## Team

## Event

## Todo
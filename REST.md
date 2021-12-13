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
- Hibás ID esetén Bad Request hibakódot küldünk.
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
- Hibás ID esetén Bad Request hibakódot küldünk.
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
- Hibás ID esetén Bad Request hibakódot küldünk.
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

### GET /api/teams
Visszaadja az összes nyilvántartott csapatot (team)

Példa:
```
GET localhost:8080/api/teams
```

```
[
    {
        "id": 28,
        "name": "TesztTeam",
        "adminAppUsers": [
            {
                "id": 25,
                "email": "teszt@elek.bme.hu",
                "username": "tesztelek",
                "password": null,
                "events": null,
                "todos": null,
                "team": null
            }
        ],
        "appUsers": [],
        "organization": {
            "id": 26,
            "name": "TesztSzervezet",
            "teams": null,
            "headQuarter": {
                "id": 27,
                "name": "tesz hely",
                "googleCode": "ABC123",
                "longitude": 111.0,
                "latitude": 222.0,
                "organization": null
            }
        }
    }
]
```

### GET /api/teams/{id}
Visszaadja az adott ID-jú csapat adatait.
#### Path paraméterek:
 - id : ID
#### Kivételek:
- Hibás ID esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
{
    "id": 28,
    "name": "GipszTeam",
    "adminAppUsers": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "appUsers": [],
    "organization": {
        "id": 26,
        "name": "TesztSzervezet",
        "teams": null,
        "headQuarter": {
            "id": 27,
            "name": "tesz hely",
            "googleCode": "ABC123",
            "longitude": 111.0,
            "latitude": 222.0,
            "organization": null
        }
    }
}
```




### PUT /api/teams
Létrehoz egy csapatot.
#### Paraméterek:
 - name : csapat neve
 - creator_id : a létrehozó felhasználó ID-ja
 - organization_id : létrehozó szervezet ID-ja

#### Kivételek:
 - Hibás ID-k illetve már foglalt csapatnév esetén Bad Request hibakódot küldünk.
 - Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
PUT localhost:8080/api/teams?name=TesztTeam2&creator_id=25&organization_id=26
```

```
{
        "id": 28,
        "name": "TesztTeam",
        "adminAppUsers": [
            {
                "id": 25,
                "email": "teszt@elek.bme.hu",
                "username": "tesztelek",
                "password": null,
                "events": null,
                "todos": null,
                "team": null
            }
        ],
        "appUsers": [],
        "organization": {
            "id": 26,
            "name": "TesztSzervezet",
            "teams": null,
            "headQuarter": {
                "id": 27,
                "name": "tesz hely",
                "googleCode": "ABC123",
                "longitude": 111.0,
                "latitude": 222.0,
                "organization": null
            }
        }
    }
```

### POST /api/teams/{id}/join
Csapathoz való csatlakozás
#### Path paraméterek:
 - id : csapat ID-ja
#### Paraméterek:
 - user_id : csatlakozó felhasználó ID-ja
#### Kivételek:
- Hibás ID-k esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/teams/28/join?user_id=29
```

```
{
    "id": 28,
    "name": "TesztTeam",
    "adminAppUsers": [
        {
            "id": 25,
            "email": "teszt@elek.bme.hu",
            "username": "tesztelek",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "appUsers": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "organization": {
        "id": 26,
        "name": "TesztSzervezet",
        "teams": null,
        "headQuarter": {
            "id": 27,
            "name": "tesz hely",
            "googleCode": "ABC123",
            "longitude": 111.0,
            "latitude": 222.0,
            "organization": null
        }
    }
}
```

### POST /api/teams/{id}/rename
Csapat átnevezése
#### Path paraméterek:
- id : csapat ID-ja
#### Paraméterek:
- name : csapat új neve
#### Kivételek:
- Hibás ID esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/teams/28/rename?name=GipszTeam
```

```
{
    "id": 28,
    "name": "GipszTeam",
    "adminAppUsers": [
        {
            "id": 25,
            "email": "teszt@elek.bme.hu",
            "username": "tesztelek",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "appUsers": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "organization": {
        "id": 26,
        "name": "TesztSzervezet",
        "teams": null,
        "headQuarter": {
            "id": 27,
            "name": "tesz hely",
            "googleCode": "ABC123",
            "longitude": 111.0,
            "latitude": 222.0,
            "organization": null
        }
    }
}
```

### POST /api/teams/{id}/leave
Csapat elhagyása
#### Path paraméterek:
- id : csapat ID-ja
#### Paraméterek:
- user_id : a csapatot elhagyó felhasználó ID-ja
#### Kivételek:
- Hibás ID vagy ha a falhsználó nem tagja a csapatnak, akkor Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/teams/28/leave?user_id=29
```

```
{
    "id": 28,
    "name": "GipszTeam",
    "adminAppUsers": [
        {
            "id": 25,
            "email": "teszt@elek.bme.hu",
            "username": "tesztelek",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "appUsers": [],
    "organization": {
        "id": 26,
        "name": "TesztSzervezet",
        "teams": null,
        "headQuarter": {
            "id": 27,
            "name": "tesz hely",
            "googleCode": "ABC123",
            "longitude": 111.0,
            "latitude": 222.0,
            "organization": null
        }
    }
}
```


### POST /api/teams/{id}/admin/add
Admin felvétele a csoportba
#### Path paraméterek:
- id : csapat ID-ja
#### Paraméterek:
- user_id : a felveendő admin ID-ja
#### Kivételek:
- Hibás ID esetén Bad Request hibakódoit küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/teams/28/admin/add?user_id=29
```

```
{
    "id": 28,
    "name": "GipszTeam",
    "adminAppUsers": [
        {
            "id": 25,
            "email": "teszt@elek.bme.hu",
            "username": "tesztelek",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        },
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "appUsers": [],
    "organization": {
        "id": 26,
        "name": "TesztSzervezet",
        "teams": null,
        "headQuarter": {
            "id": 27,
            "name": "tesz hely",
            "googleCode": "ABC123",
            "longitude": 111.0,
            "latitude": 222.0,
            "organization": null
        }
    }
}
```


### POST /api/teams/{id}/admin/remove
Admin eltávolítása a csapatból
#### Path paraméterek:
- id : csapat ID-ja
#### Paraméterek:
- user_id : a eltávolítandó admin ID-ja
#### Kivételek:
- Hibás ID vagy ha nem adminja a csapatnak, akkor Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/teams/28/admin/remove?user_id=25
```

```
{
    "id": 28,
    "name": "GipszTeam",
    "adminAppUsers": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "appUsers": [],
    "organization": {
        "id": 26,
        "name": "TesztSzervezet",
        "teams": null,
        "headQuarter": {
            "id": 27,
            "name": "tesz hely",
            "googleCode": "ABC123",
            "longitude": 111.0,
            "latitude": 222.0,
            "organization": null
        }
    }
}
```


## Event

### GET /api/events
Visszaadja az összes eseményt (event)

Példa:
```
GET localhost:8080/api/events
```

```
[
    {
        "id": 30,
        "name": "GipszEvent",
        "team": {
            "id": 28,
            "name": "GipszTeam",
            "adminAppUsers": null,
            "appUsers": null,
            "organization": {
                "id": 26,
                "name": "TesztSzervezet",
                "teams": null,
                "headQuarter": {
                    "id": 27,
                    "name": "tesz hely",
                    "googleCode": "ABC123",
                    "longitude": 111.0,
                    "latitude": 222.0,
                    "organization": null
                }
            }
        },
        "time": null,
        "creator": {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        },
        "todos": [],
        "participants": [
            {
                "id": 29,
                "email": "gipsz@jakab.hu",
                "username": "gipszjakab",
                "password": null,
                "events": null,
                "todos": null,
                "team": null
            }
        ]
    }
]
```

### GET /api/events/{id}
Visszaadja az adott ID-jú esemény adatait
#### Path paraméterek:
 - id : az esemény Id-ja
#### Kivételek:
- Hibás ID esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
GET localhost:8080/api/events/30
```

```
{
    "id": 30,
    "name": "GipszEvent",
    "team": {
        "id": 28,
        "name": "GipszTeam",
        "adminAppUsers": null,
        "appUsers": null,
        "organization": {
            "id": 26,
            "name": "TesztSzervezet",
            "teams": null,
            "headQuarter": {
                "id": 27,
                "name": "tesz hely",
                "googleCode": "ABC123",
                "longitude": 111.0,
                "latitude": 222.0,
                "organization": null
            }
        }
    },
    "time": null,
    "creator": {
        "id": 29,
        "email": "gipsz@jakab.hu",
        "username": "gipszjakab",
        "password": null,
        "events": null,
        "todos": null,
        "team": null
    },
    "todos": [],
    "participants": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ]
}
```


### POST /api/events
Létrehoz egy eseményt
#### Paraméterek:
 - name : esemény neve
 - team_id : csapat ID-ja, melyhez az esemény rendelve lesz
 - creator_id : az eseményt létrehozó felhasználó ID-ja
#### Kivételek:
 - Hibás ID-k illetve olyan létrehozó ID-ja esetén aki nem tagja a csapatnak, akkor Bad Request hibakódot küldünk.
 - Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/events?name=GipszEvent&team_id=28&creator_id=29
```

```
{
    "id": 30,
    "name": "GipszEvent",
    "team": {
        "id": 28,
        "name": "GipszTeam",
        "adminAppUsers": null,
        "appUsers": null,
        "organization": {
            "id": 26,
            "name": "TesztSzervezet",
            "teams": null,
            "headQuarter": {
                "id": 27,
                "name": "tesz hely",
                "googleCode": "ABC123",
                "longitude": 111.0,
                "latitude": 222.0,
                "organization": null
            }
        }
    },
    "time": null,
    "creator": {
        "id": 29,
        "email": "gipsz@jakab.hu",
        "username": "gipszjakab",
        "password": null,
        "events": null,
        "todos": null,
        "team": null
    },
    "todos": [],
    "participants": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ]
}
```


### POST /api/events/{id}/participant/add
Részvevő felvétele az eseménybe
#### Path paraméterek:
 - id : esemény ID-ja
#### Paraméterek:
 - user_id : csatlakozó felhasználó ID-ja
#### Kivételek:
 - Hibás ID-k esetén Bad Request hibakódot küldünk.
 - Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/events/30/participant/add?user_id=25
```

```
{
    "id": 30,
    "name": "GipszEvent",
    "team": {
        "id": 28,
        "name": "GipszTeam",
        "adminAppUsers": null,
        "appUsers": null,
        "organization": {
            "id": 26,
            "name": "TesztSzervezet",
            "teams": null,
            "headQuarter": {
                "id": 27,
                "name": "tesz hely",
                "googleCode": "ABC123",
                "longitude": 111.0,
                "latitude": 222.0,
                "organization": null
            }
        }
    },
    "time": null,
    "creator": {
        "id": 29,
        "email": "gipsz@jakab.hu",
        "username": "gipszjakab",
        "password": null,
        "events": null,
        "todos": null,
        "team": null
    },
    "todos": [],
    "participants": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        },
        {
            "id": 25,
            "email": "teszt@elek.bme.hu",
            "username": "tesztelek",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ]
}
```


### POST /api/events/{id}/participant/remove
Részvevő eltávolítása az eseményből
#### Path paraméterek:
 - id : esemény ID-ja
#### Paraméterek:
 - user_id : eltávolítandó felhasználó ID-ja
#### Kivételek:
 - Hibás ID-k esetén Bad Request hibakódot küldünk.
 - Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/events/30/participant/remove?user_id=25
```

```
{
    "id": 30,
    "name": "GipszEvent",
    "team": {
        "id": 28,
        "name": "GipszTeam",
        "adminAppUsers": null,
        "appUsers": null,
        "organization": {
            "id": 26,
            "name": "TesztSzervezet",
            "teams": null,
            "headQuarter": {
                "id": 27,
                "name": "tesz hely",
                "googleCode": "ABC123",
                "longitude": 111.0,
                "latitude": 222.0,
                "organization": null
            }
        }
    },
    "time": null,
    "creator": {
        "id": 29,
        "email": "gipsz@jakab.hu",
        "username": "gipszjakab",
        "password": null,
        "events": null,
        "todos": null,
        "team": null
    },
    "todos": [],
    "participants": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ]
}
```


### POST /app/events/{id}/time
Időpont beállítása az eseményhez
#### Path paraméterek:
 - id : esemény ID-ja
#### Paraméterek:
 - year : év
 - month : hónap
 - day : nap
 - hour : óra
 - minute : perc
#### Kivételek:
 - Hibás ID-k esetén Bad Request hibakódot küldünk.
 - Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
POST localhost:8080/api/events/30/time?year=2021&month=12&day=21&hour=9&minute=43
```

```
{
    "id": 30,
    "name": "GipszEvent",
    "team": {
        "id": 28,
        "name": "GipszTeam",
        "adminAppUsers": null,
        "appUsers": null,
        "organization": {
            "id": 26,
            "name": "TesztSzervezet",
            "teams": null,
            "headQuarter": {
                "id": 27,
                "name": "tesz hely",
                "googleCode": "ABC123",
                "longitude": 111.0,
                "latitude": 222.0,
                "organization": null
            }
        }
    },
    "time": "2021-12-21T09:43:00",
    "creator": {
        "id": 29,
        "email": "gipsz@jakab.hu",
        "username": "gipszjakab",
        "password": null,
        "events": null,
        "todos": null,
        "team": null
    },
    "todos": [],
    "participants": [
        {
            "id": 29,
            "email": "gipsz@jakab.hu",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ]
}
```

### DELETE /api/events/{id}
Törli az adott ID-jú eseményt
#### Path paraméterek:
 - id : esemény ID
#### Kivételek:
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:
```
DELETE localhost:8080/api/events/30
```

```
200 OK
```


## Todo

### GET /api/todos/
Visszaadja az összes nyílvántartott teendőt.
#### Kivételek:
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
GET localhost:8080/api/todos
```

```
[
    {
        "id": 5,
        "name": "Get more milk",
        "description": null,
        "leaders": [],
        "event": {
            "id": 4,
            "name": "House Party",
            "team": {
                "id": 3,
                "name": "Test Team A",
                "adminAppUsers": null,
                "appUsers": null,
                "organization": {
                    "id": 2,
                    "name": "Example Organization",
                    "teams": null,
                    "headQuarter": {
                        "id": 1,
                        "name": "ExamplePlace",
                        "googleCode": "ABC123",
                        "longitude": 1.0,
                        "latitude": -1.0,
                        "organization": null
                    }
                }
            },
            "time": null,
            "creator": {
                "id": 3,
                "email": "gj@example.com",
                "username": "gipszjakab",
                "password": null,
                "events": null,
                "todos": null,
                "team": null
            },
            "todos": null,
            "participants": null
        }
    }
]
```

### GET /api/todos/{id}
Visszaadja az adott ID-jú teendő adatait.
#### Path Paraméterek:
- id : ID

#### Kivételek:
- Hibás ID esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
GET localhost:8080/api/todos/5
```

```
{
    "id": 5,
    "name": "Get more milk",
    "description": null,
    "leaders": [],
    "event": {
        "id": 4,
        "name": "House Party",
        "team": {
            "id": 3,
            "name": "Test Team A",
            "adminAppUsers": null,
            "appUsers": null,
            "organization": {
                "id": 2,
                "name": "Example Organization",
                "teams": null,
                "headQuarter": {
                    "id": 1,
                    "name": "ExamplePlace",
                    "googleCode": "ABC123",
                    "longitude": 1.0,
                    "latitude": -1.0,
                    "organization": null
                }
            }
        },
        "time": null,
        "creator": {
            "id": 3,
            "email": "gj@example.com",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        },
        "todos": null,
        "participants": null
    }
}
```

### POST /api/todos/
Létrehoz egy új teendőt.
#### Paraméterek:
- name : Teendő neve
- event_id : Esemény ID-je
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
POST localhost:8080/api/todos?name=Get more milk&event_id=16
```

```
{
    "id": 5,
    "name": "Get more milk",
    "description": null,
    "leaders": [],
    "event": {
        "id": 4,
        "name": "House Party",
        "team": {
            "id": 3,
            "name": "Test Team A",
            "adminAppUsers": null,
            "appUsers": null,
            "organization": {
                "id": 2,
                "name": "Example Organization",
                "teams": null,
                "headQuarter": {
                    "id": 1,
                    "name": "ExamplePlace",
                    "googleCode": "ABC123",
                    "longitude": 1.0,
                    "latitude": -1.0,
                    "organization": null
                }
            }
        },
        "time": null,
        "creator": {
            "id": 3,
            "email": "gj@example.com",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        },
        "todos": null,
        "participants": null
    }
}
```

### POST /api/todos/{id}/addleader
Hozzáad egy felhasználót a teendőhöz
#### Path Paraméterek:
- id : Teendő ID
#### Paraméterek:
- user_id : Felhasználó ID-je
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Ha az adott felhasználó nem tartozik a teendő eseményéhez, akkor Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
POST localhost:8080/api/todos/5/addleader?user_id=3
```

```
{
    "id": 5,
    "name": "Get more milk",
    "description": null,
    "leaders": [
        {
            "id": 3,
            "email": "gj2@example.com",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        }
    ],
    "event": {
        "id": 4,
        "name": "House Party",
        "team": {
            "id": 3,
            "name": "Test Team A",
            "adminAppUsers": null,
            "appUsers": null,
            "organization": {
                "id": 2,
                "name": "Example Organization",
                "teams": null,
                "headQuarter": {
                    "id": 1,
                    "name": "ExamplePlace",
                    "googleCode": "ABC123",
                    "longitude": 1.0,
                    "latitude": -1.0,
                    "organization": null
                }
            }
        },
        "time": null,
        "creator": {
            "id": 3,
            "email": "gj@example.com",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        },
        "todos": null,
        "participants": null
    }
}
```

### POST /api/todos/{id}/removeleader
Eltávolít egy felhasználót a teendőhöz
#### Path Paraméterek:
- id : Teendő ID
#### Paraméterek:
- user_id : Felhasználó ID-je
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Ha az adott felhasználó nem tartozik a teendőhöz, akkor Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
POST localhost:8080/api/todos/5/removeleader?user_id=3
```

```
{
    "id": 5,
    "name": "Get more milk",
    "description": null,
    "leaders": [],
    "event": {
        "id": 4,
        "name": "House Party",
        "team": {
            "id": 3,
            "name": "Test Team A",
            "adminAppUsers": null,
            "appUsers": null,
            "organization": {
                "id": 2,
                "name": "Example Organization",
                "teams": null,
                "headQuarter": {
                    "id": 1,
                    "name": "ExamplePlace",
                    "googleCode": "ABC123",
                    "longitude": 1.0,
                    "latitude": -1.0,
                    "organization": null
                }
            }
        },
        "time": null,
        "creator": {
            "id": 3,
            "email": "gj@example.com",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        },
        "todos": null,
        "participants": null
    }
}
```

### POST /api/todos/{id}/description
Módosítja a teendő leírását.
#### Path Paraméterek:
- id : Teendő ID
#### Paraméterek:
- text : A leírás szövege.
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
POST localhost:8080/api/todos/5/description?text=Go to the supermaket and get some milk.
```

```
{
    "id": 5,
    "name": "Get more milk",
    "description": "Go to the supermaket and get some milk.",
    "leaders": [],
    "event": {
        "id": 4,
        "name": "House Party",
        "team": {
            "id": 3,
            "name": "Test Team A",
            "adminAppUsers": null,
            "appUsers": null,
            "organization": {
                "id": 2,
                "name": "Example Organization",
                "teams": null,
                "headQuarter": {
                    "id": 1,
                    "name": "ExamplePlace",
                    "googleCode": "ABC123",
                    "longitude": 1.0,
                    "latitude": -1.0,
                    "organization": null
                }
            }
        },
        "time": null,
        "creator": {
            "id": 3,
            "email": "gj@example.com",
            "username": "gipszjakab",
            "password": null,
            "events": null,
            "todos": null,
            "team": null
        },
        "todos": null,
        "participants": null
    }
}
```

### DELETE /api/todos/{id}
Törli az adott teendőt.
#### Path Paraméterek:
- id : Teendő ID
#### Kivételek:
- Paraméterhiány esetén Bad Request hibakódot küldünk.
- Szerver hiba esetén Internal Server Error hibakódot küldünk.

Példa:

```
DELETE localhost:8080/api/todos/5
```

```
200 OK
```
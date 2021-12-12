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

## Organization

## AppUser

## Team

## Event

## Todo
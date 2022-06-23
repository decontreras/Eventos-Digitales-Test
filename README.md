## Prueba tecnica lider
El proyecto se encuentra dockerizado, si desea correrlo sin docker debe tener instalado mysql y java-jdk-8

## arrancar proyecto con docker
```bash
docker-compose up
```

## curl ejemplo, creación usuario completo
```bash
curl --location --request POST 'localhost:6868/api/usuarios' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "usuario uno",
    "lastName": "usuario uno",
    "complete": true
}'
```

## curl ejemplo, consulta usuarios
```bash
curl --location --request GET 'localhost:6868/api/usuarios'
```

## curl ejemplo, edición de usuario
```bash
curl --location --request PUT 'localhost:6868/api/usuarios/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "usuario dos",
    "lastName": "usuario dos",
    "complete": true
}'
```
## curl ejemplo, consulta proyectos
```bash
curl --location --request GET 'localhost:6868/api/proyectos'
```

## curl ejemplo, invertir
```bash
curl --location --request POST 'localhost:6868/api/inversiones' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user_id": 2,
    "proyect_id": 1,
    "amount": 1000000
}
'
```

## curl ejemplo, consulta inversiones invertir
```bash
curl --location --request GET 'localhost:6868/api/inversiones'
```
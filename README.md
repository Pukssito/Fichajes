# Fichajes JWT

Esta aplicación proporciona una API REST para registrar horas de entrada y salida de empleados.

## Características

- Registro y autenticación de usuarios mediante JWT.
- Endpoints protegidos con Spring Security.
- Persistencia en base de datos PostgreSQL.
- Registro de fichajes (entradas, salidas y pausas).
- Eliminación de usuarios solo para administradores.

## Endpoints principales

### Autenticación

- `POST /api/auth/register` &ndash; Registrar nuevo usuario.
- `POST /api/auth/login` &ndash; Iniciar sesión y obtener token JWT.
- `DELETE /api/auth/delete/{id}` &ndash; Eliminar usuario (requiere rol `ADMIN`).

### Fichajes

- `POST /api/fichajes/fichar` &ndash; Registrar un nuevo fichaje con la hora actual de Madrid.
- `GET /api/fichajes/usuario/{id}` &ndash; Obtener usuario y sus fichajes por ID.
- `GET /api/fichajes/email/{email}` &ndash; Listar fichajes de un usuario por email.

## Ejecución con Docker

La aplicación incluye un `Dockerfile` y un `docker-compose.yml` que levanta la base de datos PostgreSQL y el backend de Spring Boot.

Para construir y arrancar todo el entorno:

```bash
docker compose up --build
```

La API quedará disponible en `http://localhost:8080` y la base de datos en `localhost:5432`.

## Compilación manual

Si se desea ejecutar sin Docker se puede compilar el proyecto con Maven:

```bash
mvn package
java -jar target/*.jar
```

Asegúrese de tener una base de datos PostgreSQL configurada según los valores del archivo `src/main/resources/application.properties`.


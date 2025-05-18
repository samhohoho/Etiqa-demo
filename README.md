# Etiqa assessment

[![Unit Tests](https://github.com/samhohoho/Etiqa-demo/actions/workflows/unit-tests.yml/badge.svg?event=push)](https://github.com/samhohoho/Etiqa-demo/actions/workflows/unit-tests.yml)

## Technologies and frameworks

- Java 21
- Spring boot 3
- Postgres
- GitHub Actions

## Local development setup

1. Get the latest source code.
2. Setup local Postgres using Docker container.

```bash
docker run -d \
  --name etiqa-demo \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin \
  -p 5555:5432 \
  postgres:latest
```

3. Go to the root folder and run the Spring Boot application.

```bash
cd /path/to/etiqa-demo/
mvn spring-boot:run
```

## You might want to explore

1. `http://localhost:8080/swagger-ui/index.html` for REST API document.

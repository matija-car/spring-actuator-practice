# Spring Boot Actuator Practice

A hands-on practice project for learning Spring Boot Actuator — covers health checks, custom metrics, info endpoints, and securing actuator endpoints with Spring Security.

## What this project demonstrates

- **Custom Health Indicator** - a manually implemented `HealthIndicator` bean contributing to the `/actuator/health` endpoint
- **Custom Info Contributor** - a manually implemented `InfoContributor` bean, combined with static `info.*` properties
- **Custom Metrics** - a Micrometer `Counter` tracking calls to a custom `/hello` endpoint
- **Spring Security** - Basic Auth protecting sensitive actuator endpoints (`env`, `beans`, `configprops`), while `health` and `info` remain public
- **Separate Management Port** - actuator endpoints run on a different port than the application itself, simulating a production setup where monitoring endpoints are not publicly exposed

## How to run

```bash
mvn spring-boot:run
```

The application starts on port `8080`, and actuator endpoints are exposed on port `9001`.

## Endpoints

| Endpoint | Port | Auth required |
|---|---|---|
| `/hello` | 8080 | No |
| `/actuator/health` | 9001 | No |
| `/actuator/info` | 9001 | No |
| `/actuator/env` | 9001 | Yes |
| `/actuator/beans` | 9001 | Yes |
| `/actuator/metrics/hello.request.counter` | 9001 | Yes |

**Basic Auth credentials (local/demo only):**
- Username: `admin`
- Password: `admin123`

## Tech stack

- Java 17
- Spring Boot 4.1.0
- Spring Boot Actuator
- Spring Security
- Micrometer
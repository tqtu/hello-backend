# Hello Backend API

A Spring Boot REST API application with Docker and Docker Compose setup.

## Project Overview

This is a simple Hello Backend application that demonstrates a basic REST API with two endpoints:
- **Health Check**: `/api/health` - Returns API status
- **Users**: `/api/users` - Returns example users with fake data

## Features

- Spring Boot 4.0.5
- RESTful API endpoints
- Docker containerization
- Docker Compose orchestration
- Health check endpoint
- Structured response DTOs

## Prerequisites

- Docker and Docker Compose installed
- Or: Java 17+ and Maven 3.9+

## Running the Application

### Using Docker Compose (Recommended)

```bash
docker-compose up --build
```

The API will be available at `http://localhost:8080`

### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Endpoints

### 1. Health Check
Check if the API is running and get status information.

**Endpoint**: `GET /api/health`

**Response** (200 OK):
```json
{
  "status": "UP",
  "message": "Hello Backend API is running!",
  "timestamp": "2024-04-02T12:34:56"
}
```

**Usage**:
```bash
curl http://localhost:8080/api/health
```

### 2. Get Users
Returns a list of example users with fake data for testing purposes.

**Endpoint**: `GET /api/users`

**Response** (200 OK):
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "username": "john_doe",
    "active": true
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "email": "jane@example.com",
    "username": "jane_smith",
    "active": true
  },
  {
    "id": 3,
    "name": "Bob Johnson",
    "email": "bob@example.com",
    "username": "bob_johnson",
    "active": false
  },
  {
    "id": 4,
    "name": "Alice Williams",
    "email": "alice@example.com",
    "username": "alice_williams",
    "active": true
  },
  {
    "id": 5,
    "name": "Charlie Brown",
    "email": "charlie@example.com",
    "username": "charlie_brown",
    "active": false
  }
]
```

**Usage**:
```bash
curl http://localhost:8080/api/users
```

## Project Structure

```
hello-backend/
├── src/
│   ├── main/
│   │   ├── java/com/interview/hellobackend/
│   │   │   ├── controller/
│   │   │   │   └── HelloController.java
│   │   │   ├── dto/
│   │   │   │   ├── HealthResponse.java
│   │   │   │   └── UserResponse.java
│   │   │   └── HelloBackendApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/interview/hellobackend/
├── Dockerfile
├── docker-compose.yml
├── .dockerignore
├── pom.xml
└── README.md
```

## Docker Configuration

### Dockerfile
Multi-stage build process:
1. **Build stage**: Compiles the Maven project
2. **Runtime stage**: Runs the JAR in a lightweight JRE container

### docker-compose.yml
Services:
- **hello-backend**: The main Spring Boot application
  - Port: 8080
  - Health check enabled
  - Restart policy: unless-stopped
  - Network: hello-network

## Building Docker Image Manually

```bash
docker build -t hello-backend:latest .
```

## Running Docker Container Manually

```bash
docker run -p 8080:8080 hello-backend:latest
```

## Stopping the Application

### If using Docker Compose:
```bash
docker-compose down
```

### If using Docker directly:
```bash
docker stop hello-backend-app
```

## Troubleshooting

### Check if the application is running:
```bash
curl http://localhost:8080/api/health
```

### View Docker logs:
```bash
docker-compose logs -f hello-backend
```

### View Docker container status:
```bash
docker ps
```

## Technologies Used

- **Spring Boot**: 4.0.5
- **Java**: 17
- **Maven**: 3.9
- **Docker**: Latest
- **Docker Compose**: 3.8

## Notes

- The health check endpoint is useful for monitoring and load balancer configuration
- The users endpoint returns fake data for demonstration and testing
- The application is configured to run on port 8080
- Docker image uses Alpine Linux for minimal size

## License

This project is part of the interview preparation series.


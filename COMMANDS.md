# 📋 Command Reference - Hello Backend API

## 🚀 Quick Start Commands

### START THE APPLICATION

#### Option 1: Docker Compose (Recommended)
```bash
cd /Users/tuqt/Mac_katalon_backup/Private/Local/hello-backend
docker-compose up --build
```

#### Option 2: Use Startup Script
```bash
cd /Users/tuqt/Mac_katalon_backup/Private/Local/hello-backend
chmod +x startup.sh
./startup.sh
```

#### Option 3: Direct Java Execution
```bash
cd /Users/tuqt/Mac_katalon_backup/Private/Local/hello-backend
mvn clean package -DskipTests
java -jar target/hello-backend-0.0.1-SNAPSHOT.jar
```

#### Option 4: Maven Spring Boot Plugin
```bash
cd /Users/tuqt/Mac_katalon_backup/Private/Local/hello-backend
mvn clean install
mvn spring-boot:run
```

---

## 🧪 Test API Endpoints

### Test Health Endpoint
```bash
curl http://localhost:8080/api/health
```

### Test Users Endpoint (Basic)
```bash
curl http://localhost:8080/api/users
```

### Test Users Endpoint (Pretty Print)
```bash
curl http://localhost:8080/api/users | python3 -m json.tool
```

### Test with jq (if installed)
```bash
curl http://localhost:8080/api/users | jq .
```

### Check HTTP Status Code
```bash
curl -w "HTTP Status: %{http_code}\n" -o /dev/null http://localhost:8080/api/health
```

### View Response Headers
```bash
curl -I http://localhost:8080/api/health
```

---

## 🛠️ Build & Compilation

### Clean and Compile
```bash
cd /Users/tuqt/Mac_katalon_backup/Private/Local/hello-backend
mvn clean compile
```

### Build Package (without tests)
```bash
mvn clean package -DskipTests
```

### Build Package (with tests)
```bash
mvn clean package
```

### Run Tests
```bash
mvn test
```

### Install Dependencies
```bash
mvn install
```

### Check Dependency Tree
```bash
mvn dependency:tree
```

---

## 🐳 Docker Commands

### Build Docker Image Manually
```bash
cd /Users/tuqt/Mac_katalon_backup/Private/Local/hello-backend
docker build -t hello-backend:latest .
```

### Run Docker Container (Manual)
```bash
docker run -p 8080:8080 hello-backend:latest
```

### List Running Containers
```bash
docker ps
```

### List All Containers
```bash
docker ps -a
```

### View Container Logs
```bash
docker logs -f hello-backend-app
```

### Stop Container
```bash
docker stop hello-backend-app
```

### Remove Container
```bash
docker rm hello-backend-app
```

### Remove Image
```bash
docker rmi hello-backend:latest
```

---

## 🐳 Docker Compose Commands

### Start with Auto-build
```bash
docker-compose up --build
```

### Start (use existing image)
```bash
docker-compose up
```

### Start in Background
```bash
docker-compose up -d --build
```

### Stop Services
```bash
docker-compose down
```

### View Logs
```bash
docker-compose logs
```

### View Logs (Follow)
```bash
docker-compose logs -f
```

### View Service Logs
```bash
docker-compose logs -f hello-backend
```

### Restart Service
```bash
docker-compose restart hello-backend
```

### Remove All (containers, volumes, networks)
```bash
docker-compose down -v
```

---

## 📊 Test the API with Scripts

### Run Bash Test Script
```bash
cd /Users/tuqt/Mac_katalon_backup/Private/Local/hello-backend
chmod +x api-test.sh
./api-test.sh
```

---

## 🧹 Cleanup Commands

### Stop Docker Compose
```bash
docker-compose down
```

### Remove All Docker Resources
```bash
docker-compose down -v
docker rmi hello-backend
```

### Clean Maven Build
```bash
mvn clean
```

### Remove Target Directory
```bash
rm -rf target/
```

### Stop Java Process (if running directly)
```bash
pkill -f "hello-backend"
```

---

## 🔍 Troubleshooting Commands

### Check Port 8080 in Use
```bash
lsof -i :8080
```

### Kill Process on Port 8080
```bash
kill -9 <PID>
```

### Check Docker Daemon Status
```bash
docker ps
```

### Verify API Health
```bash
curl http://localhost:8080/api/health
```

### View Application Logs
```bash
docker-compose logs -f hello-backend
```

### Check Disk Space
```bash
df -h
```

### Check Docker Image Size
```bash
docker images hello-backend
```

---

## 📝 File Operations

### View Application Properties
```bash
cat src/main/resources/application.properties
```

### View Dockerfile
```bash
cat Dockerfile
```

### View docker-compose.yml
```bash
cat docker-compose.yml
```

### View Controller Code
```bash
cat src/main/java/com/interview/hellobackend/controller/HelloController.java
```

### View pom.xml
```bash
cat pom.xml
```

---

## 📖 Documentation Commands

### View QUICKSTART
```bash
cat QUICKSTART.md
```

### View README
```bash
cat README_API.md
```

### View Implementation Summary
```bash
cat IMPLEMENTATION_SUMMARY.md
```

### View Getting Started
```bash
cat GETTING_STARTED.md
```

### Open README in Editor
```bash
nano QUICKSTART.md
# or
vim QUICKSTART.md
# or
code QUICKSTART.md
```

---

## 🎯 Complete Workflow

### Full Development Cycle
```bash
# 1. Navigate to project
cd /Users/tuqt/Mac_katalon_backup/Private/Local/hello-backend

# 2. Build the project
mvn clean package -DskipTests

# 3. Start with Docker
docker-compose up --build

# 4. In another terminal, test
curl http://localhost:8080/api/health
curl http://localhost:8080/api/users | python3 -m json.tool

# 5. Stop when done
docker-compose down
```

---

## 🔄 Common Development Tasks

### Make Code Changes
```bash
# 1. Edit Java files
# 2. Rebuild
mvn clean compile

# 3. Restart application
docker-compose down
docker-compose up --build
```

### Update Configuration
```bash
# 1. Edit application.properties
# 2. Rebuild and restart
mvn clean package -DskipTests
docker-compose restart
```

### Update pom.xml Dependencies
```bash
# 1. Edit pom.xml
# 2. Resolve dependencies
mvn dependency:resolve

# 3. Rebuild
mvn clean package -DskipTests
```

---

## 💡 Tips & Tricks

### Quick Health Check
```bash
curl -s http://localhost:8080/api/health | jq .status
```

### One-liner to test both endpoints
```bash
echo "Health:" && curl -s http://localhost:8080/api/health | jq . && echo "Users:" && curl -s http://localhost:8080/api/users | jq length
```

### Monitor Real-time Logs
```bash
docker-compose logs -f --tail=50
```

### Rebuild without stopping container
```bash
docker-compose up --build --no-deps --detach hello-backend
```

### Check What Changed
```bash
git status
git diff
```

---

## 📞 Quick Reference Summary

| Task | Command |
|------|---------|
| **Start Application** | `docker-compose up --build` |
| **Test Health** | `curl http://localhost:8080/api/health` |
| **Test Users** | `curl http://localhost:8080/api/users \| python3 -m json.tool` |
| **Stop Application** | `docker-compose down` |
| **View Logs** | `docker-compose logs -f` |
| **Build Project** | `mvn clean package -DskipTests` |
| **Run Tests** | `mvn test` |
| **Clean Build** | `mvn clean` |
| **Check Status** | `docker ps` |
| **Rebuild Image** | `docker-compose up --build` |

---

**Last Updated:** April 2, 2026  
**Version:** 1.0.0


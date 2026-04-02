#!/bin/bash
# startup.sh - Quick startup script for the Hello Backend API

set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "$SCRIPT_DIR"

# Colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${BLUE}╔════════════════════════════════════╗${NC}"
echo -e "${BLUE}║   Hello Backend API - Startup      ║${NC}"
echo -e "${BLUE}╚════════════════════════════════════╝${NC}\n"

# Check if Docker is available
if ! command -v docker &> /dev/null; then
    echo -e "${YELLOW}⚠️  Docker not found. Building with Maven instead...${NC}\n"

    echo -e "${BLUE}Building with Maven...${NC}"
    mvn clean package -DskipTests

    echo -e "\n${GREEN}✓ Build complete!${NC}"
    echo -e "${BLUE}Starting application...${NC}\n"

    java -jar target/hello-backend-0.0.1-SNAPSHOT.jar
else
    echo -e "${GREEN}✓ Docker detected${NC}"
    echo -e "${BLUE}Starting with Docker Compose...${NC}\n"

    docker-compose up --build
fi


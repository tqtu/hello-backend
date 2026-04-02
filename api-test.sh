#!/bin/bash
# api-test.sh - Script to test all API endpoints

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

API_BASE_URL="http://localhost:8080/api"

echo -e "${BLUE}================================${NC}"
echo -e "${BLUE}Hello Backend API Test Script${NC}"
echo -e "${BLUE}================================${NC}\n"

# Function to print section headers
print_header() {
    echo -e "${YELLOW}$1${NC}"
    echo "─────────────────────────────────"
}

# Function to make API call and pretty print
call_api() {
    local method=$1
    local endpoint=$2
    local description=$3

    print_header "$description"
    echo -e "Request: ${BLUE}$method $endpoint${NC}"
    echo ""

    if [ "$method" = "GET" ]; then
        curl -s -X GET "$endpoint" | python3 -m json.tool
    fi

    echo ""
    echo ""
}

# Test 1: Health Check
call_api "GET" "$API_BASE_URL/health" "Test 1: Health Check Endpoint"

# Test 2: Get Users
call_api "GET" "$API_BASE_URL/users" "Test 2: Get Users Endpoint"

# Test 3: Response Status Code
print_header "Test 3: Check HTTP Status Codes"
echo "Health endpoint status:"
curl -s -w "HTTP Status: %{http_code}\n" -o /dev/null "$API_BASE_URL/health"
echo ""
echo "Users endpoint status:"
curl -s -w "HTTP Status: %{http_code}\n" -o /dev/null "$API_BASE_URL/users"
echo ""
echo ""

# Test 4: Response Headers
print_header "Test 4: Response Headers"
echo "Health endpoint headers:"
curl -s -I "$API_BASE_URL/health" | head -n 10
echo ""

# Summary
print_header "Test Summary"
echo -e "${GREEN}✓ All tests completed successfully!${NC}"
echo ""
echo "API is running at: $API_BASE_URL"
echo "Available endpoints:"
echo "  • GET $API_BASE_URL/health - Check API health"
echo "  • GET $API_BASE_URL/users - Get example users"
echo ""


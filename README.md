# MCS Order Service Documentation

## Overview

The MCS Order Service is a Spring Boot application designed to manage the ordering process for the Youkoso Store. It handles everything from product orders to transaction management. The service is built to efficiently handle user requests, manage order data, and ensure a smooth transaction flow.

## Features

- **Order Creation**: Allows customers to add products to their cart and initiate an order.
- **Order Processing**: Manages the processing of orders, including quantity validations and stock adjustments.
- **Payment Simulation**: Simulates the payment process for the orders made.

## Prerequisites

Before you can run the MCS Order Service, you need to have the following installed:

- Maven 3.6 or newer
- Spring Boot
- Java 21

## How to run the application

1. **Clone the repository**:
   ```bash
   git clone https://github.com/tk-adpro/mcs-order
   cd mcs-order
   ```

2. **Build the application:**
   ```bash
   ./gradlew clean build
   ```

3. **Run the application:**
   ```bash
   ./gradlew bootRun
   ```

## How to Test 

1. **Run the test using gradlew:**
    ```bash
    ./gradlew test
   ```


## Service API Endpoints

1. [Order Service Readme](./src/main/java/id/ac/ui/cs/advprog/eshop/mcsorder/order/README-Order.md).
2. [Payment Service Readme](./src/main/java/id/ac/ui/cs/advprog/eshop/mcsorder/payment/README-Payment.md).

## Monitoring with Grafana and Prometheus

To monitor the MCS Order Service using Prometheus and Grafana, follow these steps:

1. Start Prometheus and Grafana using Docker:

    ```bash
    docker-compose up -d
    ```

2. Access Prometheus:
   1. Open your browser and navigate to http://localhost:9090.
  
3.	Access Grafana:
  - Open your browser and navigate to http://localhost:3000.
     - Default login credentials: admin / admin
     - Add Prometheus as a data source:
     - Navigate to Configuration > Data Sources.
     - Click Add data source and select Prometheus.
     - Set the URL to http://prometheus:9090 and click Save & Test.
  
4. Create or Import Grafana Dashboards:
    - Create a new dashboard or import existing dashboards to visualize the metrics collected by Prometheus.

## Documentation

Swagger:
   ```sh
   http://localhost:8080/swagger-ui/
   ```

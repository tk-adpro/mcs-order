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

## How to run the application

1. **Clone the repository**:
   ```bash
   git clone https://yourrepositoryurl.com/mcs-order-service.git
   cd mcs-order
   ```

## How to Test 


## API Endpoints

### Create Order
- **Endpoint**: `POST /api/orders`
- **Description**: Allows customers to add products to their cart and create an order.

### Get Order
- Endpoint: `GET /api/orders/{orderId}`
- Description: Retrieves the current status and details of a specific order.
- Required Parameters:
  - orderId: The ID of the order to retrieve.

### List Orders
- **Endpoint**: `GET /api/orders`
- **Description**: Retrieves a list of all orders.

### Delete Order
- **Endpoint**: `DELETE /api/orders/{orderId}`
- **Description**: Deletes a specific order based on the order ID provided.
- **Required Parameters**:
  - `orderId`: The ID of the order to delete.

### Update Order
- **Endpoint**: `PUT /api/orders/{orderId}`
- **Description**: Updates the details of an existing order.
- **Required Parameters**:
  - `orderId`: The ID of the order to update.

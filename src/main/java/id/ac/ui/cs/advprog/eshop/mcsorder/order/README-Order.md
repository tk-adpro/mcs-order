# Order Service 

## API Endpoint

### Create Order

- **Endpoint**: `POST /api/orders`
- **Description**: Allows customers to add products to their cart and create an order.
- **Contoh penggunaan:**
  ```bash
  curl -X POST http://localhost:8080/api/orders \
     -H "Content-Type: application/json" \
     -d '{
           "customerName": "John Doe",
           "items": [
             {
               "productId": 1,
               "quantity": 2
             },
             {
               "productId": 2,
               "quantity": 1
             }
           ]
         }'
  ```

### Get Order

- **Endpoint**: `GET /api/orders/{orderId}`
- **Description**: Retrieves the current status and details of a specific order.
- **Required Parameters**:
  - `orderId`: The ID of the order to retrieve.
- **Contoh penggunaan:**
  ```bash
  curl -X GET http://localhost:8080/api/orders/{orderId}
  ```

### List Orders

- **Endpoint**: `GET /api/orders`
- **Description**: Retrieves a list of all orders.
- **Contoh penggunaan:**
  ```bash
  curl -X GET http://localhost:8080/api/orders
  ```

### Delete Order

- **Endpoint**: `DELETE /api/orders/{orderId}`
- **Description**: Deletes a specific order based on the order ID provided.
- **Required Parameters**:
  - `orderId`: The ID of the order to delete.
- **Contoh penggunaan:**
  ```bash
  curl -X DELETE http://localhost:8080/api/orders/{orderId}
  ```

### Update Order

- **Endpoint**: `PUT /api/orders/{orderId}`
- **Description**: Updates the details of an existing order.
- **Required Parameters**:
  - `orderId`: The ID of the order to update.
- **Contoh penggunaan:**
  ```bash
  curl -X PUT http://localhost:8080/api/orders/{orderId} \
     -H "Content-Type: application/json" \
     -d '{
           "customerName": "Jane Doe",
           "items": [
             {
               "productId": 1,
               "quantity": 3
             },
             {
               "productId": 3,
               "quantity": 2
             }
           ]
         }'
  ```
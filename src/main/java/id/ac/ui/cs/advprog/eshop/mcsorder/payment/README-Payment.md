# Payment Service

## API Endpoint

### Get Payment

- **Endpoint**: `GET /api/payments/{paymentId}`
- **Description**: Retrieves the details of a specific payment.
- **Path Parameters**:
  - `paymentId`: The ID of the payment to retrieve.
- **Contoh penggunaan:**
  ```bash
  curl -X GET http://localhost:8080/api/payments/{paymentId}
  ```

### List Payments

- **Endpoint**: `GET /api/payments`
- **Description**: Retrieves a list of all payments.
- **Contoh penggunaan:**
  ```bash
  curl -X GET http://localhost:8080/api/payments
  ```

### Delete Payment

- **Endpoint**: `DELETE /api/payments/{paymentId}`
- **Description**: Deletes a specific payment based on the payment ID provided.
- **Path Parameters**:
  - `paymentId`: The ID of the payment to delete.
- **Contoh penggunaan:**
  ```bash
  curl -X DELETE http://localhost:8080/api/payments/{paymentId}
  ```

### Update Payment

- **Endpoint**: `PUT /api/payments/{paymentId}`
- **Description**: Updates the details of an existing payment.
- **Path Parameters**:
  - `paymentId`: The ID of the payment to update.
- **Contoh penggunaan:**
  ```bash
  curl -X PUT http://localhost:8080/api/payments/{paymentId} \
     -H "Content-Type: application/json" \
     -d '{
           "orderId": 1,
           "amount": 150.00,
           "paymentMethod": "CREDIT_CARD",
           "status": "PENDING",
           "validationStatus": "PENDING"
         }'
  ```
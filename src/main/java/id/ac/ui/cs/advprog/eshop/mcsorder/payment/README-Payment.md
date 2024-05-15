# Payment Service

## API Endpoint

### Get Payment

- **Endpoint**: `GET /api/payments/{paymentId}`
- **Description**: Retrieves the details of a specific payment.
- **Path Parameters**:
  - `paymentId`: The ID of the payment to retrieve.

### List Payments

- **Endpoint**: `GET /api/payments`
- **Description**: Retrieves a list of all payments.

### Delete Payment

- **Endpoint**: `DELETE /api/payments/{paymentId}`
- **Description**: Deletes a specific payment based on the payment ID provided.
- **Path Parameters**:
  - `paymentId`: The ID of the payment to delete.

### Update Payment

- **Endpoint**: `PUT /api/payments/{paymentId}`
- **Description**: Updates the details of an existing payment.
- **Path Parameters**:
  - `paymentId`: The ID of the payment to update.
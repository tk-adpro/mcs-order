# Order Service 

## API Endpoint

### Create Order

- **Endpoint**: `POST /api/orders`
- **Description**: Allows customers to add products to their cart and create an order.

### Get Order

- **Endpoint**: `GET /api/orders/{orderId}`
- **Description**: Retrieves the current status and details of a specific order.
- **Required Parameters**:
  - `orderId`: The ID of the order to retrieve.

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
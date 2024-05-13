// OrderRequest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.order.dto;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;

public class OrderRequest {
    private String customerName;
    private List<OrderItem> items;

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}

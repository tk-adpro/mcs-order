// OrderRequest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.dto;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.OrderItem;

import java.util.List;

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

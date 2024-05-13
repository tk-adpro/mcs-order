// PaymentRequest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.payment.dto;

public class PaymentRequest {
    private Long orderId;
    private double amount;
    private String status;

    // Getters and setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

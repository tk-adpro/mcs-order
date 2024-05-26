// PaymentRequest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.payment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRequest {
    private String status;

    @NotNull(message = "Order ID cannot be null")
    private Long orderId;

    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    private double amount;

    @NotBlank(message = "Payment method cannot be blank")
    private String paymentMethod;

    @NotBlank(message = "Payment details cannot be blank")
    private String paymentDetails;

}

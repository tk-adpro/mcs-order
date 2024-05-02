package id.ac.ui.cs.advprog.eshop.mcsorder.model;
import lombok.Getter; 
import lombok.Setter;

/**
 * Payment Model
 */
@Getter @Setter
public class Payment {
    private Long id;
    private Long orderId;
    private Double amount;
    private String paymentMethod;
    private String status;
}

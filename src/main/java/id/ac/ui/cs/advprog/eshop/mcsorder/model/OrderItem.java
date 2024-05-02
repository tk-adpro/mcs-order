package id.ac.ui.cs.advprog.eshop.mcsorder.model;
import lombok.Getter; 
import lombok.Setter;


@Getter @Setter
public class OrderItem {
    private Long id;
    private Order order;
    private Long productId;
    private Integer quantity;
    private Double price;
}

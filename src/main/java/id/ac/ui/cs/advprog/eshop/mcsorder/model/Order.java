package id.ac.ui.cs.advprog.eshop.mcsorder.model;

import lombok.Getter; 
import lombok.Setter;
import java.util.Date;
import java.util.List;

/**
 * Order Model
 */
@Getter @Setter
public class Order {
    private Long id;
    private Long customerId;
    private List<OrderItem> items;
    private Double total;
    private Date orderDate;
}

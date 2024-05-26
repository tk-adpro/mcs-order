// OrderRequest.java

package id.ac.ui.cs.advprog.eshop.mcsorder.order.dto;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.mcsorder.order.model.OrderItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequest {
    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    @NotNull(message = "Items cannot be null")
    private List<OrderItem> items;

}

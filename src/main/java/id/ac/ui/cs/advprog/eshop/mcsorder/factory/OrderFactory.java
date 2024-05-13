// OrderFactory.java

package id.ac.ui.cs.advprog.eshop.mcsorder.factory;

import id.ac.ui.cs.advprog.eshop.mcsorder.model.Order;
import id.ac.ui.cs.advprog.eshop.mcsorder.model.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

// TODO: Parameternya bisa diubah, tergantung kebutuhan
public class OrderFactory {

    public static Order createOrder(String customerName, List<OrderItem> items) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setItems(items);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }
}

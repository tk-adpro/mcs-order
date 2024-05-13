package id.ac.ui.cs.advprog.eshop.mcsorder.observer;

public class CustomerNotifier implements OrderStatusObserver {
    private String customerEmail;

    public CustomerNotifier(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public void update(String status) {
        System.out.println("Notifying " + customerEmail + " about order status: " + status);
    }
}

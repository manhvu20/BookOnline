package bookonline.ejb;

import javax.ejb.Stateless;
import bookonline.interfaces.OrderManagement;

@Stateless
public class OrderManagementBean implements OrderManagement {

    @Override
    public void confirmOrder() {
        System.out.println("Order confirmed. Redirecting to payment details page..."); 
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order cancelled. Redirecting back to cart..."); 
    }
}

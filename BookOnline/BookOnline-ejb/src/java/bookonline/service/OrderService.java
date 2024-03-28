package bookonline.service;

import bookonline.interfaces.OrderManagement;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderService {

    @EJB
    private OrderManagement orderManagement;

    public void confirmOrder() {
        orderManagement.confirmOrder();
    }

    public void cancelOrder() {
        orderManagement.cancelOrder();
    }
}

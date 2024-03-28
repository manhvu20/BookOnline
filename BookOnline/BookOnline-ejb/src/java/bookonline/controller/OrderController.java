package bookonline.controller;

import bookonline.interfaces.OrderManagement;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OrderController {

    @EJB
    private OrderManagement orderManagement;

    public String confirmOrder() {
        orderManagement.confirmOrder();
        return "order-confirmation";
    }

    public String cancelOrder() {
        orderManagement.cancelOrder();
        return "cart";
    }
}

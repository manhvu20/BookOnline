package bookonline.service;

import bookonline.entity.CartItem;
import bookonline.interfaces.CartManagement;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CartService {

    @EJB
    private CartManagement cartManagement;

    public List<CartItem> getCartItems() {
        return cartManagement.getCartItems();
    }

    public void addToCart(Long bookId, int quantity) {
        cartManagement.addToCart(bookId, quantity);
    }

    public void updateCartItem(Long itemId, int quantity) {
        cartManagement.updateCartItem(itemId, quantity);
    }

    public void removeCartItem(Long itemId) {
        cartManagement.removeCartItem(itemId);
    }

    public double getTotalPrice() {
        return cartManagement.getTotalPrice();
    }
}

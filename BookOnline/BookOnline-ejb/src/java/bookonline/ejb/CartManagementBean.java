package bookonline.ejb;

import bookonline.entity.CartItem;
import bookonline.interfaces.CartManagement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class CartManagementBean implements CartManagement {
    private static final List<CartItem> cartItems = new ArrayList<>();

    @Override
    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    @Override
    public void addToCart(Long bookId, int quantity) {

    }

    @Override
    public void updateCartItem(Long itemId, int quantity) {
        CartItem item = findCartItemById(itemId);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }

    @Override
    public void removeCartItem(Long itemId) {
        CartItem item = findCartItemById(itemId);
        if (item != null) {
            cartItems.remove(item);
        }
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getBook().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    private CartItem findCartItemById(Long itemId) {
        for (CartItem item : cartItems) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }
}


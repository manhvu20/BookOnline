package bookonline.interfaces;

import bookonline.entity.CartItem;
import java.util.List;

public interface CartManagement {
    List<CartItem> getCartItems();
    void addToCart(Long bookId, int quantity);
    void updateCartItem(Long itemId, int quantity);
    void removeCartItem(Long itemId);
    double getTotalPrice();
}

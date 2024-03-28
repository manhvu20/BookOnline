package bookonline.controller;

import bookonline.entity.Book;
import bookonline.entity.CartItem;
import bookonline.interfaces.CartManagement;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CartController implements Serializable {

    @EJB
    private CartManagement cartManagement;

    @ManagedProperty(value = "#{bookController}")
    private BookController bookController;

    public List<CartItem> getCartItems() {
        return cartManagement.getCartItems();
    }

    public double getTotalPrice() {
        return cartManagement.getTotalPrice();
    }

    public void setBookController(BookController bookController) {
        this.bookController = bookController;
    }

    public String addToCart(Long bookId, int quantity) {
        Book book = findBookById(bookId);
        if (book != null) {
            cartManagement.addToCart(bookId, quantity);
        }
        return "cart";
    }

    public String updateCartItem(Long itemId, int quantity) {
        cartManagement.updateCartItem(itemId, quantity);
        return "cart";
    }

    public String removeCartItem(Long itemId) {
        cartManagement.removeCartItem(itemId);
        return "cart";
    }

    private Book findBookById(Long id) {
        List<Book> allBooks = bookController.getAllBooks();
        for (Book book : allBooks) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}

package bookonline.controller;

import bookonline.entity.Book;
import bookonline.interfaces.BookManagement;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BookController {

    @EJB
    private BookManagement bookManagement;

    public List<Book> getAllBooks() {
        return bookManagement.getAllBooks();
    }
}

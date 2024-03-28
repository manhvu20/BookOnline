package bookonline.service;

import bookonline.entity.Book;
import bookonline.interfaces.BookManagement;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BookService {

    @EJB
    private BookManagement bookManagement;

    public List<Book> getAllBooks() {
        return bookManagement.getAllBooks();
    }

    public void addBook(Book book) {
        bookManagement.addBook(book);
    }

    public void deleteBook(Long bookId) {
        bookManagement.deleteBook(bookId);
    }

    public void updateBook(Book book) {
        bookManagement.updateBook(book);
    }

    public Book getBookById(Long bookId) {
        return bookManagement.getBookById(bookId);
    }
}

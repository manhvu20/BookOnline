package bookonline.interfaces;

import bookonline.entity.Book;
import java.util.List;

public interface BookManagement {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
}

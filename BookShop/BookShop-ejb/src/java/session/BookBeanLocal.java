package session;

import entities.Book;    
import java.util.List;
import javax.ejb.Local;

@Local
public interface BookBeanLocal {
    List<Book> findAll();
    
    void insert(Book book);
    
    void delete(String bookId);
    
    void update(Book book);
}


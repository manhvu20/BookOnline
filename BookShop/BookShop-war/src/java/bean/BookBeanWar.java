package bean;

import entities.Book;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import session.BookBeanLocal;

@ManagedBean(name="bookBean")
public class BookBeanWar implements Serializable{
    
    @EJB
    private BookBeanLocal bookSessionBean;
    private final Book book;
    
    public BookBeanWar(){
      this.book = new Book();  
    }
 
    public List<Book> getBookList(){
        return bookSessionBean.findAll();
    }
    public void insert(){
        bookSessionBean.insert(book);
    }
    public Book getBook(){
        return book;
    }
    public void delete(String bookId){
        bookSessionBean.delete(bookId);
    }
}


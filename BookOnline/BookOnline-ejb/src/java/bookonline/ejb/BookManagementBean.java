package bookonline.ejb;

import bookonline.entity.Book;
import bookonline.interfaces.BookManagement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BookManagementBean implements BookManagement {
    private static final List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1L, "Book 1", "Author 1", 20.0, 10));
        bookList.add(new Book(2L, "Book 2", "Author 2", 30.0, 15));
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookList);
    }

    @Override
    public Book getBookById(Long id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public void updateBook(Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(book.getId())) {
                bookList.set(i, book);
                break;
            }
        }
    }

    @Override
    public void deleteBook(Long id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                bookList.remove(i);
                break;
            }
        }
    }
}

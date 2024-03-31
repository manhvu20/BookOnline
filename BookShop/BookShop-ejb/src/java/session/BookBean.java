package session;

import entities.Book;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class BookBean implements BookBeanLocal {
        private static final Logger LOGGER = Logger.getLogger(BookBean.class.getName());

    @Override
    public List<Book> findAll() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EBookShop-ejbPU");
        EntityManager em = factory.createEntityManager();
        Query q = em.createNamedQuery("Book.findAll", Book.class);  
        return q.getResultList();
    }

    @Override
    public void insert(Book book) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EBookShop-ejbPU");
        EntityManager em = factory.createEntityManager();
        book.setId(UUID.randomUUID().toString());
        LOGGER.info(book.toString());
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    @Override
    public void delete(String bookId) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EBookShop-ejbPU");
        EntityManager em = factory.createEntityManager();
        Book bookFind = em.find(Book.class, bookId);

        em.getTransaction().begin();
        em.remove(bookFind);
        em.getTransaction().commit(); 
    }

    @Override
    public void update(Book book) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EBookShop-ejbPU");
        EntityManager em = factory.createEntityManager();
        Book bookFind = em.find(Book.class, book.getId());
        em.getTransaction().begin();
        bookFind.setTitle(book.getTitle());
        em.getTransaction().commit(); 
    }
}


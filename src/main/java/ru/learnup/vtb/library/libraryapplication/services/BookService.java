package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import ru.learnup.vtb.library.libraryapplication.annotations.Loggable;
import ru.learnup.vtb.library.libraryapplication.events.SearchBookEvent;
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.repository.JpaBookRepository;
import ru.learnup.vtb.library.libraryapplication.repository.entities.AuthorEntity;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;
import ru.learnup.vtb.library.libraryapplication.repository.interfaces.BookRepository;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BookService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;
    private JpaBookRepository repository;
    private TransactionTemplate txTemplate;

    @Autowired
    public BookService(Logger logger, JpaBookRepository repository, TransactionTemplate txTemplate) {
        this.logger = logger;
        this.repository = repository;
        this.txTemplate = txTemplate;
    }

    public void printAll() {

        repository.findAll().forEach(System.out::println);
    }

    public void printAllLike(String pattern) {
        for (BookEntity bookEntity : repository.getMyFilteredResult(pattern)) {
            System.out.println(bookEntity);
        }
    }

    public void demo() {
       txTemplate.executeWithoutResult((status) -> {
           try {
               final BookEntity newBook = repository.save(
                       new BookEntity(null, "123", new AuthorEntity(1L, "NULL", Collections.emptyList()))
               );
               newBook.setName("Мцыри");
               repository.save(newBook);
           } catch (Exception err) {
               System.out.println(err);
               status.setRollbackOnly();
           }
       });
    }

    public void save(Book book) {
        repository.save(
                new BookEntity(null, book.getName(), new AuthorEntity(null, book.getAuthor().getName(), null)));
    }

    public void delete(long bookId) {
        repository.deleteById(bookId);
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getSimpleName() + " успешно создан");
    }

    @PreDestroy
    public void ustroyDestroy() {
        System.out.println(this.getClass().getSimpleName() + " готовится к уничтожению");
    }

    public void error() {
        throw new RuntimeException("Упс!");
    }

    public List<BookEntity> getAll() {
        return repository.findAll();
    }
}

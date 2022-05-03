package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BookService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;
    private JpaBookRepository repository;

    @Autowired
    public BookService(Logger logger, JpaBookRepository repository) {
        this.logger = logger;
        this.repository = repository;
    }

    public void printAll() {

        repository.findAll().forEach(System.out::println);
    }

    public void printAllLike(String pattern) {
        for (BookEntity bookEntity : repository.getMyFilteredResult(pattern)) {
            System.out.println(bookEntity);
        }
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 2,
            rollbackFor = {IOException.class, FileNotFoundException.class, EOFException.class}
    )
    public void demo(AuthorEntity authorEntity) {
           try {
               final BookEntity newBook = repository.save(
                       new BookEntity(null, "999", authorEntity)
               );
               newBook.setName("222");
               repository.save(newBook);

//               Thread.sleep(3000);
           } catch (Exception err) {
               System.out.println(err);
           }
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

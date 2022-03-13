package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.learnup.vtb.library.libraryapplication.annotations.Loggable;
import ru.learnup.vtb.library.libraryapplication.events.SearchBookEvent;
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;
import ru.learnup.vtb.library.libraryapplication.repository.interfaces.BookRepository;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class BookService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;
    private BookRepository repository;

    @Autowired
    public BookService(Logger logger, BookRepository repository) {
        this.logger = logger;
        this.repository = repository;
    }

    public void printAll() {

        repository.getAll().forEach(System.out::println);
    }

    public void save(Book book) {
        repository.save(
                new BookEntity(null, book.getName(), book.getAuthor()));
    }

    public void delete(long bookId) {
        repository.delete(bookId);
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

    @Loggable
    public Book getBookByName(String bookName) {
/*
        logger.print(ctx.getMessage("hello", new Object[]{"ВТБ"}, Locale.ITALY));
        logger.print(ctx.getMessage("searchBook", new Object[]{name}, Locale.US) );
        logger.print(ctx.getMessage("searchBook", new Object[]{name}, Locale.ITALY) );
        logger.print(ctx.getMessage("searchBook", new Object[]{name}, Locale.FRANCE));
        logger.print(ctx);
*/
        ctx.publishEvent(
                new SearchBookEvent(
                        new SearchBookEvent.Info(bookName)));
        return new Book(bookName, "default");
    }

    public void error() {
        throw new RuntimeException("Упс!");
    }
}

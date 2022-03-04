package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.learnup.vtb.library.libraryapplication.annotations.Loggable;
import ru.learnup.vtb.library.libraryapplication.events.SearchBookEvent;
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Locale;

@Service
public class BookService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;

    @Autowired
    public BookService(Logger logger) {
        this.logger = logger;
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

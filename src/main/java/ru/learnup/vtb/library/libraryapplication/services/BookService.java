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
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Locale;

@Service
@Scope("prototype")
public class BookService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;
    private MessageSource messageSource;

    @Autowired
    public BookService(Logger logger, MessageSource messageSource) {
        this.logger = logger;
        this.messageSource = messageSource;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    @PostConstruct
    public void init(){
        System.out.println(this.getClass().getSimpleName() + " успешно создан");
    }

    @PreDestroy
    public void ustroyDestroy(){
        System.out.println(this.getClass().getSimpleName() + " готовится к уничтожению");
    }

    public Book getBookByName(String name) {
        logger.print(messageSource.getMessage("searchBook", new Object[0], Locale.US) + name);
        logger.print(messageSource.getMessage("searchBook", new Object[0], Locale.ITALY) + name);
        logger.print(messageSource.getMessage("searchBook", new Object[0], Locale.FRANCE) + name);
        logger.print(ctx);
        return new Book(name, "default");
    }
}

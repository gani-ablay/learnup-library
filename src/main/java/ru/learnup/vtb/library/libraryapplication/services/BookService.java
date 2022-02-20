package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

@Service
public class BookService {

    private Logger logger;

    @Autowired
    public BookService(@Qualifier("consoleLogger") Logger logger) {
        this.logger = logger;
    }

    public Book getBookByName(String name) {
        logger.print("Находим книгу " + name);
        return new Book(name, "default");
    }
}

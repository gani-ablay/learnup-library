package ru.learnup.vtb.library.libraryapplication.services;

import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;


public class BookService {

    private Logger logger;

    public BookService(Logger logger) {
        this.logger = logger;
    }

    public Book getBookByName(String name) {
        logger.print("Находим книгу " + name);
        return new Book(name, "default");
    }
}

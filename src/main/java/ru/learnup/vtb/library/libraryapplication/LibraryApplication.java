package ru.learnup.vtb.library.libraryapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.services.AuthorService;
import ru.learnup.vtb.library.libraryapplication.services.BookService;

@SpringBootApplication
@EntityScan({"ru.learnup.vtb.library.libraryapplication.repository.entities"})
public class LibraryApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);

        final BookService bookService = ctx.getBean(BookService.class);

/*
        bookService.printAllLike("Ка%");

        bookService.printAllLike("%ро%");
*/

        final AuthorService authorService = ctx.getBean(AuthorService.class);
        authorService.printAll();

    }

}

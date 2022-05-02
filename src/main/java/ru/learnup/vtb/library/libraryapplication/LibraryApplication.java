package ru.learnup.vtb.library.libraryapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.repository.entities.AuthorEntity;
import ru.learnup.vtb.library.libraryapplication.services.AuthorService;
import ru.learnup.vtb.library.libraryapplication.services.BookService;

import java.util.Collections;

@SpringBootApplication
@EntityScan({"ru.learnup.vtb.library.libraryapplication.repository.entities"})
@EnableCaching
public class LibraryApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);

        final BookService bookService = ctx.getBean(BookService.class);

/*
        bookService.printAllLike("Ка%");

        bookService.printAllLike("%ро%");
*/

/*
        ctx.getBean(AuthorService.class).saveNew(
                new AuthorEntity(null, "Александр Пушкин", Collections.emptyList())
        );
*/

        for (int i = 0; i < 3; i++) {
            System.out.println(ctx.getBean(AuthorService.class).getByName("Александр Пушкин"));
            System.out.println("===");
        }


    }

}

package ru.learnup.vtb.library.libraryapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.library.libraryapplication.services.BookService;

import java.io.EOFException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EntityScan({"ru.learnup.vtb.library.libraryapplication.repository.entities"})
@EnableCaching
public class LibraryApplication {

    public static void main(String[] args) throws EOFException {
        final ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);

        final BookService bookService = ctx.getBean(BookService.class);

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()-> {
            bookService.rename(41L, "Новое имя 1");
        });
        executorService.execute(()-> {
            bookService.rename(41L, "Новое имя 2");
        });
    }

}

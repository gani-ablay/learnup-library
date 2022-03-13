package ru.learnup.vtb.library.libraryapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.services.BookService;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);

        final BookService bookService = ctx.getBean(BookService.class);

        System.out.println("До добавления: ");
        bookService.printAll();

        bookService.save(new Book("Том Сойер","Марк Твен"));

        System.out.println("\n\nПосле добавления: ");
        bookService.printAll();

        bookService.delete(14);

        System.out.println("\n\nПосле удаления: ");
        bookService.printAll();


    }

}

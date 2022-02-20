package ru.learnup.vtb.library.libraryapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.library.libraryapplication.services.BookService;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);

		//((BookService) ctx.getBean("ololoService")).getBookByName("Мастер и Маргарита");
		ctx.getBean(BookService.class).getBookByName("Мастер и Маргарита");
	}

}

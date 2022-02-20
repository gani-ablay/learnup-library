package ru.learnup.vtb.library.libraryapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.learnup.vtb.library.libraryapplication.services.BookService;
import ru.learnup.vtb.library.libraryapplication.services.ConsoleLogger;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

@Configuration
//@Import({LoggerConfig.class})
public class GeneralConfig {

//    @Bean("ololoService")
    @Bean
    public BookService bookService(Logger logger) {
        return new BookService(logger);
    }
}

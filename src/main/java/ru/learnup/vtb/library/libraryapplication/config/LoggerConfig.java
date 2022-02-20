package ru.learnup.vtb.library.libraryapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.learnup.vtb.library.libraryapplication.services.ConsoleLogger;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

@Configuration
public class LoggerConfig {

    @Bean
    public Logger logger(){
        return new ConsoleLogger();
    }
}

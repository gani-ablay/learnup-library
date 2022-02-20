package ru.learnup.vtb.library.libraryapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.learnup.vtb.library.libraryapplication.services.ConsoleLogger;
import ru.learnup.vtb.library.libraryapplication.services.EmailLogger;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

@Configuration
//@Profile("!logger")
public class LoggersConfig {

    @Bean
    @Profile("console")
    public Logger consoleLogger(){
        return new ConsoleLogger();
    }

    @Bean
    @Profile("!console")
    public Logger emailLogger(){
        return new EmailLogger();
    }
}

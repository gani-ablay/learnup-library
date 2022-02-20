package ru.learnup.vtb.library.libraryapplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import ru.learnup.vtb.library.libraryapplication.services.ConsoleLogger;
import ru.learnup.vtb.library.libraryapplication.services.EmailLogger;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

@Configuration
//@Profile("!logger")
public class LoggersConfig {

    @Bean
    @Scope("prototype")
    @Profile("!console")
    public Logger consoleLogger(@Value("${myConfig.logger.console.prefix:default}")String prefix){
        return new ConsoleLogger(prefix);
    }

    @Bean
    @Profile("console")
    public Logger emailLogger(){
        return new EmailLogger();
    }
}

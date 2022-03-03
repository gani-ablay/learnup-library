package ru.learnup.vtb.library.libraryapplication.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class GeneralConfig {

    @Bean
    public MessageSource messageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("msgs");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}

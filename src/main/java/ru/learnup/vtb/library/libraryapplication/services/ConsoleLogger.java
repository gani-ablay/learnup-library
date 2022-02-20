package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

@Component
@Profile("console")
public class ConsoleLogger implements Logger {
    @Override
    public void print(Object obj) {
        System.out.println(obj);
    }
}

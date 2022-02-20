package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.stereotype.Component;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

@Component
public class ConsoleLogger implements Logger {
    @Override
    public void print(Object obj) {
        System.out.println(obj);
    }
}

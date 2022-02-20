package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

@Component
@Primary
public class EmailLogger implements Logger {
    @Override
    public void print(Object obj) {
        System.out.println("Email: " + obj);
    }
}
package ru.learnup.vtb.library.libraryapplication.services;

import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void print(Object obj) {
        System.out.println(obj);
    }
}

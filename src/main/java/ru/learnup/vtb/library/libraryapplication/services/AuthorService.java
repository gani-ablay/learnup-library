package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.learnup.vtb.library.libraryapplication.model.Book;
import ru.learnup.vtb.library.libraryapplication.repository.JpaAuthorRepository;
import ru.learnup.vtb.library.libraryapplication.repository.JpaBookRepository;
import ru.learnup.vtb.library.libraryapplication.repository.entities.AuthorEntity;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;
import ru.learnup.vtb.library.libraryapplication.services.interfaces.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AuthorService {

    private JpaAuthorRepository repository;

    @Autowired
    public AuthorService(JpaAuthorRepository repository) {
        this.repository = repository;
    }

    public void printAll() {

        repository.findAll().forEach(System.out::println);
    }


}

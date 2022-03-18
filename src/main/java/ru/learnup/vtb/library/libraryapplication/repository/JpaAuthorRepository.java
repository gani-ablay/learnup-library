package ru.learnup.vtb.library.libraryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.vtb.library.libraryapplication.repository.entities.AuthorEntity;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;

import java.util.List;

public interface JpaAuthorRepository extends JpaRepository<AuthorEntity, Long> {

}

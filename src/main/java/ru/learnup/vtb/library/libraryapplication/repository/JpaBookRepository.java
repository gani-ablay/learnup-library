package ru.learnup.vtb.library.libraryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;

import java.util.List;

public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {

    void deleteById(Long id);

    List<BookEntity> findAllByNameLikeOrderById(String namePattern);

    @Query(name = "book.findlikename")
    List<BookEntity> getMyFilteredResult(String pattern);
}

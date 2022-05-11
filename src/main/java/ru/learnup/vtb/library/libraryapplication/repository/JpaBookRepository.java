package ru.learnup.vtb.library.libraryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;

import javax.persistence.LockModeType;
import java.util.List;

public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {

    void deleteById(Long id);

    List<BookEntity> findAllByNameLikeOrderById(String namePattern);

    @Query(name = "book.findlikename")
    List<BookEntity> getMyFilteredResult(String pattern);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("from BookEntity b where b.id = :id")
    BookEntity getForUpdate(Long id);
}

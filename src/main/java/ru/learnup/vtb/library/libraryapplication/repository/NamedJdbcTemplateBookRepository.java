package ru.learnup.vtb.library.libraryapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;
import ru.learnup.vtb.library.libraryapplication.repository.interfaces.BookRepository;

import java.util.*;

import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;


@Repository
@Profile("jdbc-named")
public class NamedJdbcTemplateBookRepository implements BookRepository {

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public NamedJdbcTemplateBookRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Collection<BookEntity> getAll() {
        List<BookEntity> result = new ArrayList<>();
        String sql = "SELECT * FROM books;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql, emptyMap());

        while (sqlRowSet.next()) {
            final long id = sqlRowSet.getLong("id");
            final String name = sqlRowSet.getString("name");
            final String author = sqlRowSet.getString("author");
            result.add(new BookEntity(id, name, author));
        }
        return result;
    }

    @Override
    public boolean save(BookEntity book) {
        String sql = "INSERT INTO books(name, author) VALUES(:bookName, :author);";

        Map<String, Object> params = new HashMap<>();
        params.put("bookName", book.getName());
        params.put("author", book.getAuthor());

        return jdbc.update(
                sql,
                params) == 1;
    }

    @Override
    public boolean delete(long bookId) {
        String sql = "DELETE FROM books WHERE id = :id;";
        return jdbc.update(
                sql,
                singletonMap("id", bookId)) == 1;
    }
}

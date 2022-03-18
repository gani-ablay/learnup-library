/*
package ru.learnup.vtb.library.libraryapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;
import ru.learnup.vtb.library.libraryapplication.repository.interfaces.BookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ru.learnup.vtb.library.libraryapplication.repository.Config.*;


@Repository
@Profile("jdbc-template")
public class JdbcTemplateBookRepository implements BookRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcTemplateBookRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Collection<BookEntity> getAll() {
        List<BookEntity> result = new ArrayList<>();
        String sql = "SELECT * FROM books;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql);

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
        String sql = "INSERT INTO books(name, author) VALUES(?, ?);";

        return jdbc.update(
                sql,
                book.getName(),
                book.getAuthor()) == 1;
    }

    @Override
    public boolean delete(long bookId) {
        String sql = "DELETE FROM books WHERE id = ?;";
        return jdbc.update(sql, bookId) == 1;
    }
}
*/

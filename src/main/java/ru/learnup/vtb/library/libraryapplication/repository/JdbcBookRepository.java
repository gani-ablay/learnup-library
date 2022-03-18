/*
package ru.learnup.vtb.library.libraryapplication.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.learnup.vtb.library.libraryapplication.repository.entities.BookEntity;
import ru.learnup.vtb.library.libraryapplication.repository.interfaces.BookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ru.learnup.vtb.library.libraryapplication.repository.Config.*;


@Repository
@Profile("jdbc")
public class JdbcBookRepository implements BookRepository {

    private Connection connection;

    public JdbcBookRepository() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Collection<BookEntity> getAll() {
        List<BookEntity> result = new ArrayList<>();
        String sql = "SELECT * FROM books;";
        try (Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                final long id = resultSet.getLong("id");
                final String name = resultSet.getString("name");
                final String author = resultSet.getString("author");
                result.add(new BookEntity(id, name, author));
            }

            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(BookEntity book) {
        String sql = "INSERT INTO books(name, author) VALUES(?, ?);";
        try (final PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());

            final int rowsCount = statement.executeUpdate();

            final ResultSet generatedKeys = statement.getGeneratedKeys();

            generatedKeys.next();
            final long createId = generatedKeys.getLong(1);
            System.out.println("--------------" + createId);

            return rowsCount == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(long bookId) {
        String sql = "DELETE FROM books WHERE id = ?;";
        try (final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, bookId);

            return statement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
*/

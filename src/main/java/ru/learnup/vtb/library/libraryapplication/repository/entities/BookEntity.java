package ru.learnup.vtb.library.libraryapplication.repository.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    private Long id;
    private String name;
    private String author;

    @Override
    public String toString() {
        return String.format("%s %s (%d)", author, name, id);
    }
}

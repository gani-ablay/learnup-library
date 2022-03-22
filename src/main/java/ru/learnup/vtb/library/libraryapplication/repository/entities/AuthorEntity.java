package ru.learnup.vtb.library.libraryapplication.repository.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
@NamedEntityGraph(
        name = "author-with-books",
        attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode("name"),
                @NamedAttributeNode(value = "books", subgraph = "author-books")
        },

        subgraphs = {
                @NamedSubgraph(name = "author-books", attributeNodes = {
                        @NamedAttributeNode("id"),
                        @NamedAttributeNode("name"),
                        @NamedAttributeNode("author")
                })
        }
)
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator", sequenceName = "authors_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 64)
    private String name;

    @OneToMany(mappedBy = "author")
    private Collection<BookEntity> books;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s (%d)\n", name, id));
        for (BookEntity book : books) {
            sb.append(book).append("\n");
        }

        return sb.toString();
    }
}

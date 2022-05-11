package ru.learnup.vtb.library.libraryapplication.repository.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(name = "book.findlikename", query = "from BookEntity b where b.name like :pattern", lockMode =  LockModeType.PESSIMISTIC_WRITE)
})
/*
@Cacheable
@org.hibernate.annotations.Cache(include = "all", region = "book.id", usage = CacheConcurrencyStrategy.READ_ONLY)
*/
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "books_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 64)
    private String name;

    @JoinColumn(name = "author_id")
    @ManyToOne
    private AuthorEntity author;

    @Override
    public String toString() {
        return String.format("%s %s (%d)", author.getName(), name, id);
    }
}

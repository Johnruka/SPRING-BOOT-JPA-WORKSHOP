package se.lexicon.springbootjpaworkshop1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int authorId;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    private String name;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    Set<Book> writtenBooks = new HashSet<>();


    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


    }

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book was null");
        if (writtenBooks.contains(book)) throw new IllegalArgumentException("Book already exists.");
        writtenBooks.add(book);
        book.getAuthors().add(this);
    }


    public void removeBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book was null");
        if (!writtenBooks.contains(book)) throw new IllegalArgumentException("Book does not exist.");
        writtenBooks.remove(book);
        book.getAuthors().remove(this);
    }
}

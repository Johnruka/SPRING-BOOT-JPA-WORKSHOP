package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = {"authors", "bookLoans"})
@EqualsAndHashCode(exclude = {"authors", "bookLoans"})

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booId;
    private String isbn;
    @Setter
    private String title;
    @Setter
    private int maxLoanDays;

    @Setter
    private boolean available = true;

    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    Set<Author> authors = new HashSet<>();

    @Setter
    @OneToMany(mappedBy = "book")
    private Set<BookLoan> bookLoans = new HashSet<>();


    public Book(String title, int maxLoanDays) {
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.isbn = generateIsbn();
    }
        private String generateIsbn () {
            return java.util.UUID.randomUUID().toString();
        }
    }

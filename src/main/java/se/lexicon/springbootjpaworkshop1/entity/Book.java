package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
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
    private int id;
    private String isbn;
    @Setter
    private String title;
    @Setter
    private int maxLoanDays;

    @Setter
    private boolean available = true;

    @OneToMany(mappedBy = "book")
    @Setter
    private Set<BookLoan> bookLoans = new HashSet<>();

    @ManyToMany(mappedBy = "writtenBooks")
    private List<Author> authors;

    public void lendBook() {
        this.available = false;
    }

    public void returnBook() {
        this.available = true;
        }
    }

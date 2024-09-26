package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booId;

    @Setter
    @Column(nullable = false)
    private String isbn;

    @Setter
    @Column(unique = true, nullable = false)
    private String title;

    @Setter
    private boolean available = true;

    @Setter
    @Column(nullable = false)
    private int maxLoanDays;

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

    private String generateIsbn() {
        return java.util.UUID.randomUUID().toString();


    }

    public void addAuthor(Author author){
        if(author == null) throw new IllegalArgumentException("Author was null");
        if(authors.contains(author)) throw new IllegalArgumentException("Author already exists.");
        authors.add(author);
    }

    public void addBookLoan(BookLoan bookLoan){
        if(bookLoan == null) throw new IllegalArgumentException("BookLoan was null");
        if(bookLoans.contains(bookLoan)) throw new IllegalArgumentException("BookLoan already exists.");
        if(!available) throw new IllegalArgumentException("Book is not available.");
        bookLoans.add(bookLoan);
    }


    public void removeAuthor(Author author){
        if(author == null) throw new IllegalArgumentException("Author was null");
        if(!authors.contains(author)) throw new IllegalArgumentException("Author does not exist.");
        authors.remove(author);
        author.getWrittenBooks().remove(this);
    }


    public void removeBookLoan(BookLoan bookLoan){
        if(bookLoan == null) throw new IllegalArgumentException("BookLoan was null");
        if(!bookLoans.contains(bookLoan)) throw new IllegalArgumentException("BookLoan does not exist.");
        bookLoans.remove(bookLoan);
    }
}






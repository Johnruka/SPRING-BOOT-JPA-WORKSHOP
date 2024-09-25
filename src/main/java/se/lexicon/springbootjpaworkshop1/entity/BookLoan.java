package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Column(nullable = false)
    private LocalDate LoanDate;

    @Column(nullable = false)
    private boolean returned;

    @ManyToOne
    @JoinColumn
    private AppUser borrower;

    @ManyToOne
    @JoinColumn
    private Book book;

    public BookLoan(Book book, AppUser appUser) {
        this.borrower = appUser;
        this.book = book;
        this.LoanDate = LocalDate.now();
        this.returned = false;


    }
}

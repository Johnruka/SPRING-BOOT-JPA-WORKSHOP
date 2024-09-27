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
    private int loanId;

    @Setter
    @Column(nullable = false, updatable = false)
    private LocalDate loanDate;

    @Setter
    @Column(nullable = false, updatable = false)
    private LocalDate dueDate;

    @Setter
    @Column(nullable = false)
    private boolean returned;

    @ManyToOne
    @Setter
    private AppUser borrower;

    @ManyToOne
    @Setter
    private Book book;


    public BookLoan(LocalDate loanDate, AppUser borrower, Book book) {
        this.loanDate = LocalDate.now();
        this.borrower = borrower;
        this.book = book;

    }


}





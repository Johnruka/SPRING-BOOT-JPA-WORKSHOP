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

    @Setter
    @ManyToOne(cascade = CascadeType.ALL)

    private AppUser borrower;

    @Setter
    @ManyToOne(cascade = CascadeType.ALL)

    private Book book;

    public BookLoan(Book book, AppUser appUser) {
        this.borrower = appUser;
        this.book = book;
        this.loanDate = LocalDate.now();
        this.dueDate = LocalDate.now().plusDays(book.getMaxLoanDays());
        this.returned = false;

    }

    public void returnBook() {
        this.borrower = null;
        this.book = null;
    }

    public void calculateDueDate(){
        this.dueDate = this.loanDate.plusDays(book.getMaxLoanDays());
    }


}


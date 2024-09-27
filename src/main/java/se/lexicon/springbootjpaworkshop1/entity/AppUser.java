package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 100)
    @Setter
    private String username;

    @Column(nullable = false, length = 100)
    @Setter
    private String password;

    @Column(nullable = false, length = 25)
    private LocalDate regDate;

    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Details userdetails;

    @Setter
    @OneToMany(mappedBy = "borrower")
    private Set<BookLoan> loans = new HashSet<>();

    @OneToMany(mappedBy = "borrower")
    private List<BookLoan> bookLoans = new ArrayList<>();

    public void addBookLoan(BookLoan bookLoan) {
        bookLoans.add(bookLoan);
        bookLoan.setBorrower(this);
    }

    public void removeBookLoan(BookLoan bookLoan) {
        bookLoans.remove(bookLoan);
        bookLoan.setBorrower(null);
    }

    public AppUser(String firstName, String lastName, String email, Details userdetails) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userdetails = userdetails;
    }


    }


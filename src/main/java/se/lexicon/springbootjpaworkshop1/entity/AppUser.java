package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString //(exclude = "regDate")
@Entity //(username = "_AppUser")
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

    public AppUser(String firstName, String lastName, String email, Details userdetails) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userdetails = userdetails;
    }

    public void addLoan(BookLoan loan) {
        if (loan == null) throw new IllegalArgumentException("Loan was null");
        if (loans.contains(loan)) throw new IllegalArgumentException("Loan already exists.");
        loans.add(loan);
        loan.getBook().setAvailable(false);
    }
}

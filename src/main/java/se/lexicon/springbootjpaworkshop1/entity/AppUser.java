package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString //(exclude = "regDate")
//@Data

@Entity //(username = "_AppUser")
//@Table(username = " ")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    @Setter
    private String username;

    @Column(nullable = false, length = 100)
    @Setter
    private String password;
    @Column(nullable = false, length = 100)
    @Setter
    private Details userDetails;


    private LocalDateTime regDate;


    @Setter
    @OneToOne
    @JoinColumn(name = "details_id")
    private Details details;

    public AppUser(String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.regDate = LocalDateTime.now();
    }
}

package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


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

    @Column(nullable = false, length = 100)
    private LocalDateTime regDate;


    @Setter
    @OneToOne
    @JoinColumn(name = "details_id")
    private Details userdetails;

    public AppUser(String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.regDate = LocalDateTime.now();
    }
}

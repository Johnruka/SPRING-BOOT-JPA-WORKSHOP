package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false)
    private LocalDate birthDate;



    public Details(String email, LocalDate birtDate, String name) {
        this.email = email;
        this.birthDate = birtDate;
        this.name = name;


        }
    }


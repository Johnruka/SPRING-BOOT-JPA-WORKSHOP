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



        @OneToOne(mappedBy = "details")
        AppUser appUser;

        //Constructor
        // Bypassing the birthDate field for now!
    public Details(String name, String email) {
            this.email = email;
            this.name = name;


        }
    }


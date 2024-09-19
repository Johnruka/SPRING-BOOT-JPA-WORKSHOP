package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    private LocalDateTime birthDate;

    public Details(String email, String name) {
        this.email = email;
        this.name = name;


    }
}

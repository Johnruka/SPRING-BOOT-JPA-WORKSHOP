package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        this.birthDate =

    }
}

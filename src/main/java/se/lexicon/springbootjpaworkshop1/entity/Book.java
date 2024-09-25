package se.lexicon.springbootjpaworkshop1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String isbn;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private int maxLoanDays;


    }







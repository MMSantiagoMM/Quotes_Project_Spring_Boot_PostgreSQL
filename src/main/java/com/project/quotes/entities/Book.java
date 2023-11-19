package com.project.quotes.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",nullable = false)
    private Writer writer;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Publisher publisher;

    private Integer pag;

    private LocalDate date;
}

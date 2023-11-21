package com.project.quotes.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_writer",referencedColumnName = "id")
    private Writer writer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_publisher", referencedColumnName = "id")
    private Publisher publisher;

    private Integer pag;

    private LocalDate datePublication;

    public Book() {
    }

    public Book(Long id, String name, Writer writer, Publisher publisher, Integer pag, LocalDate datePublication) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.publisher = publisher;
        this.pag = pag;
        this.datePublication = datePublication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer_id) {
        this.writer = writer_id;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher_id) {
        this.publisher = publisher_id;
    }

    public Integer getPag() {
        return pag;
    }

    public void setPag(Integer pag) {
        this.pag = pag;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }
}

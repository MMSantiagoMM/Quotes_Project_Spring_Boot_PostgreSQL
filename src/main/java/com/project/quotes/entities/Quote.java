package com.project.quotes.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Integer pag;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",nullable = false)
    private Book book;

    public Quote() {
    }

    public Quote(Long id, String content, Integer pag, Book book) {
        this.id = id;
        this.content = content;
        this.pag = pag;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPag() {
        return pag;
    }

    public void setPag(Integer pag) {
        this.pag = pag;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

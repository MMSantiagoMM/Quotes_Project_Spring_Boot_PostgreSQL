package com.project.quotes.dto;

public class QuoteDTO {

    private String content;
    private Integer pag;
    private Long book;
    private Long category;


    public QuoteDTO() {
    }

    public QuoteDTO(String content, Integer pag, Long book, Long category) {
        this.content = content;
        this.pag = pag;
        this.book = book;
        this.category = category;
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

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}

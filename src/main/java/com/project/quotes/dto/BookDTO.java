package com.project.quotes.dto;



import java.time.LocalDate;

public class BookDTO {


    private String name;

    private Long writer_id;

    private Long publisher_id;

    private Integer pag;

    private LocalDate date;

    public BookDTO() {
    }

    public BookDTO(String name, Long writer_id, Long publisher_id, Integer pag, LocalDate date) {
        this.name = name;
        this.writer_id = writer_id;
        this.publisher_id = publisher_id;
        this.pag = pag;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(Long writer_id) {
        this.writer_id = writer_id;
    }

    public Long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }

    public Integer getPag() {
        return pag;
    }

    public void setPag(Integer pag) {
        this.pag = pag;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

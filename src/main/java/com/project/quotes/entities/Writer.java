package com.project.quotes.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Writers")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    private Boolean isAlive;
    private String century;

    public Writer() {
    }

    public Writer(Long id, String name, String nationality,
                  Boolean isAlive, String century) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.isAlive = isAlive;
        this.century = century;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public String getCentury() {
        return century;
    }

    public void setCentury(String century) {
        this.century = century;
    }
}

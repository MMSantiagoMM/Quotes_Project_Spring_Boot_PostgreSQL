package com.project.quotes.dto;

public class WriterDTO {

    private String name;
    private String nationality;
    private Boolean isAlive;
    private String century;

    public WriterDTO() {
    }

    public WriterDTO(String name, String nationality, Boolean isAlive, String century) {
        this.name = name;
        this.nationality = nationality;
        this.isAlive = isAlive;
        this.century = century;
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

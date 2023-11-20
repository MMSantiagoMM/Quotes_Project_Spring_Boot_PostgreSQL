package com.project.quotes.exeptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(Long id){
        super("Book with the id: " + id + " was not found");
    }
}

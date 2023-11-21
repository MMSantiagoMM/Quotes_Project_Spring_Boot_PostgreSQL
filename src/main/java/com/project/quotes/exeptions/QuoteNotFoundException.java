package com.project.quotes.exeptions;

public class QuoteNotFoundException extends RuntimeException{
    public QuoteNotFoundException(Long id){
        super("Quote with id: " + id + " was not found");
    }
}

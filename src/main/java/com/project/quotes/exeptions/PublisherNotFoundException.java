package com.project.quotes.exeptions;

public class PublisherNotFoundException extends RuntimeException{
    public PublisherNotFoundException(Long id){
        super("Publisher with id: " + id + " was not found");
    }
}

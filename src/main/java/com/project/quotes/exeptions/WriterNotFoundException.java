package com.project.quotes.exeptions;

import com.project.quotes.repositories.WriterRepository;

public class WriterNotFoundException extends RuntimeException{
    public WriterNotFoundException(Long id){
        super("The writer with the id: " + id + " was not found");
    }

}

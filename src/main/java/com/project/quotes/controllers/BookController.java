package com.project.quotes.controllers;

import com.project.quotes.dto.BookDTO;
import com.project.quotes.entities.Book;
import com.project.quotes.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Book> create (@RequestBody BookDTO newBook){
        Book book = service.create(newBook);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}

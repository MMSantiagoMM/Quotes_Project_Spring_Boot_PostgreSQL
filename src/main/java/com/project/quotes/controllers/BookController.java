package com.project.quotes.controllers;

import com.project.quotes.dto.BookDTO;
import com.project.quotes.entities.Book;
import com.project.quotes.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    ResponseEntity<List<Book>> getAll(){
        List<Book> books = service.getAll();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Book> getOne(@PathVariable Long id){
        return service.getOne(id).map(book -> new ResponseEntity<>(book,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDTO updatedBook){
        return service.update(id,updatedBook)
                .map(book -> new ResponseEntity<>(book,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete (@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

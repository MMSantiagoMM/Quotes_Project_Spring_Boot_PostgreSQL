package com.project.quotes.controllers;

import com.project.quotes.dto.QuoteDTO;
import com.project.quotes.entities.Quote;
import com.project.quotes.services.QuoteService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quotes")
public class QuoteController {

    private final QuoteService service;


    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Quote> create(@RequestBody QuoteDTO newQuote){
        Quote quote = service.create(newQuote);
        return new ResponseEntity<>(quote, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Quote>> getAll(){
        List<Quote> quotes = service.getAll();
        return new ResponseEntity<>(quotes,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Quote> getOne(@PathVariable Long id){
        return service.getOne(id)
                .map(quote -> new ResponseEntity<>(quote,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    ResponseEntity<Quote> update (@PathVariable Long id, @RequestBody QuoteDTO updatedQuote){
        return service.update(id,updatedQuote)
                .map(quote -> new ResponseEntity<>(quote,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete (@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

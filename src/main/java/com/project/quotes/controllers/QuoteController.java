package com.project.quotes.controllers;

import com.project.quotes.dto.QuoteDTO;
import com.project.quotes.entities.Quote;
import com.project.quotes.services.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

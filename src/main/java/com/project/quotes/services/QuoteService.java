package com.project.quotes.services;

import com.project.quotes.dto.QuoteDTO;
import com.project.quotes.entities.Quote;
import com.project.quotes.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    private final QuoteRepository repository;
    private final CategoryService categoryService;
    private final BookService bookService;



    public QuoteService(QuoteRepository repository, CategoryService categoryService,
                        BookService bookService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.bookService = bookService;

    }

    public Quote create(QuoteDTO newQuote){
        Quote quote = new Quote();
        quote.setContent(newQuote.getContent());
        quote.setPag(newQuote.getPag());
        quote.setBook(bookService.getOne(newQuote.getBook()).get());
        quote.setCategory(categoryService.getOne(newQuote.getCategory()).get());
        return repository.save(quote);
    }


}

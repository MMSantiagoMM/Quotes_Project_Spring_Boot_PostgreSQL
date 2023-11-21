package com.project.quotes.services;

import com.project.quotes.dto.QuoteDTO;
import com.project.quotes.entities.Quote;
import com.project.quotes.exeptions.QuoteNotFoundException;
import com.project.quotes.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Quote> getAll(){
        return repository.findAll();
    }

    public Optional<Quote> getOne(Long id){
        return Optional.of(repository.findById(id))
                .orElseThrow(()-> new QuoteNotFoundException(id));
    }

    public Optional<Quote> update(Long id, QuoteDTO updatedQuote){
        return Optional.of(repository.findById(id)
                .map(quote -> {
                    quote.setContent(updatedQuote.getContent());
                    quote.setPag(updatedQuote.getPag());
                    quote.setBook(bookService.getOne(updatedQuote.getBook()).get());
                    quote.setCategory(categoryService.getOne(updatedQuote.getCategory()).get());
                    return repository.save(quote);
                }).orElseThrow(()-> new QuoteNotFoundException(id)));
    }

    public Boolean delete (Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }


}

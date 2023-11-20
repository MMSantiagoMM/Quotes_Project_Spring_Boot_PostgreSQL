package com.project.quotes.services;

import com.project.quotes.dto.BookDTO;
import com.project.quotes.entities.Book;
import com.project.quotes.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;
    private final WriterService writerService;
    private final PublisherService publisherService;

    public BookService(BookRepository repository, WriterService writerService, PublisherService publisherService) {
        this.repository = repository;
        this.writerService = writerService;
        this.publisherService = publisherService;
    }


    public Book create(BookDTO newBook){
        Book book = new Book();
        book.setName(newBook.getName());
        book.setWriter(writerService.getOne(newBook.getWriter_id()).get());
        book.setPublisher(publisherService.getOne(newBook.getPublisher_id()).get());
        book.setPag(newBook.getPag());
        book.setDatePublication(newBook.getDate());
        repository.save(book);
        return book;
    }
}

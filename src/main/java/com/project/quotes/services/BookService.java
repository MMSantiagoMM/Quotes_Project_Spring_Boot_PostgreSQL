package com.project.quotes.services;

import com.project.quotes.dto.BookDTO;
import com.project.quotes.entities.Book;
import com.project.quotes.exeptions.BookNotFoundException;
import com.project.quotes.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;
    private final WriterService writerService;
    private final PublisherService publisherService;

    public BookService(BookRepository repository, WriterService writerService,
                       PublisherService publisherService) {
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

    public List<Book> getAll(){
        return repository.findAll();
    }

    public Optional<Book> getOne (Long id){
        return Optional.of(repository.findById(id))
                .orElseThrow(()-> new BookNotFoundException(id));
    }

    public Optional<Book> update(Long id, BookDTO updatedBook){
        return Optional.of(repository.findById(id)
                .map(book -> {
                    book.setName(updatedBook.getName());
                    book.setWriter(writerService.getOne(updatedBook.getWriter_id()).get());
                    book.setPublisher(publisherService.getOne(updatedBook.getPublisher_id()).get());
                    book.setPag(updatedBook.getPag());
                    book.setDatePublication(updatedBook.getDate());
                    return repository.save(book);
                }).orElseThrow(()-> new BookNotFoundException(id)));
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

package com.project.quotes.controllers;

import com.project.quotes.dto.PublisherDTO;
import com.project.quotes.entities.Publisher;
import com.project.quotes.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Publisher> insert(@RequestBody PublisherDTO newPublisher){
        Publisher publisher = service.create(newPublisher);
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Publisher>> getAll(){
        List<Publisher> publishers = service.getAll();
        return new ResponseEntity<>(publishers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Publisher> getOne(@PathVariable Long id){
        return service.getOne(id).map(publisher -> new ResponseEntity<>(publisher,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    ResponseEntity<Publisher> update(@PathVariable Long id, @RequestBody PublisherDTO updatePublisher){
        return service.update(id,updatePublisher)
                .map(publisher -> new ResponseEntity<>(publisher, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete (@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}

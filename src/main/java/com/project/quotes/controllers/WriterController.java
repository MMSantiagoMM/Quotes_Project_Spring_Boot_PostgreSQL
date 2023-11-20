package com.project.quotes.controllers;

import com.project.quotes.dto.WriterDTO;
import com.project.quotes.entities.Writer;
import com.project.quotes.services.WriterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("writers")
public class WriterController {

    private final WriterService service;


    public WriterController(WriterService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Writer> insert (@RequestBody WriterDTO newWriter){
        Writer writer = service.create(newWriter);
        return new ResponseEntity<>(writer, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Writer>> getAll(){
        List<Writer> writers = service.getAll();
        return new ResponseEntity<>(writers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Writer> getOne(@PathVariable Long id){
        return service.getOne(id).map(
                writer -> new ResponseEntity<>(writer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    ResponseEntity<Writer> update (@PathVariable Long id, @RequestBody WriterDTO newWriter){
        return service.edit(id,newWriter)
                .map(writer -> new ResponseEntity<>(writer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

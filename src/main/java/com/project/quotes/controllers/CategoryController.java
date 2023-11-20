package com.project.quotes.controllers;

import com.project.quotes.dto.CategoryDTO;
import com.project.quotes.entities.Category;
import com.project.quotes.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Category> insert(@RequestBody CategoryDTO newCategory){
        Category category = service.insert(newCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Category>> getAll(){
        List<Category> categories = service.getAll();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> getOne (@PathVariable Long id){
        return service.getOne(id).map(category -> new ResponseEntity<>(category,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    ResponseEntity<Category> update(@PathVariable Long id, @RequestBody CategoryDTO updatedCategory){
        return service.update(id,updatedCategory).map(category -> new ResponseEntity<>(
                category,HttpStatus.OK))
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

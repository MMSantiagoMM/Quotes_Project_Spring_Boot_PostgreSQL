package com.project.quotes.services;

import com.project.quotes.dto.CategoryDTO;
import com.project.quotes.entities.Category;
import com.project.quotes.exeptions.CategoryNotFoundException;
import com.project.quotes.exeptions.WriterNotFoundException;
import com.project.quotes.mappers.CategoryMapper;
import com.project.quotes.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;


    public CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Category insert (CategoryDTO newCategory){
        return repository.save(mapper.categoryDtoToCategory(newCategory));
    }

    public List<Category> getAll(){
        return repository.findAll();
    }

    public Optional<Category> getOne(Long id){
        return Optional.of(repository.findById(id)).orElseThrow(
                ()-> new CategoryNotFoundException(id));
    }

    public Optional<Category> update (Long id, CategoryDTO updatedCategory){
        return Optional.of(repository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            return repository.save(category);
        }).orElseThrow(()-> new WriterNotFoundException(id)));
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

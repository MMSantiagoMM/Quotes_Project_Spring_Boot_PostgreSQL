package com.project.quotes.services;

import com.project.quotes.dto.PublisherDTO;
import com.project.quotes.entities.Publisher;
import com.project.quotes.exeptions.PublisherNotFoundException;
import com.project.quotes.mappers.PublisherMapper;
import com.project.quotes.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository repository;
    private final PublisherMapper mapper;


    public PublisherService(PublisherRepository repository, PublisherMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Publisher create(PublisherDTO newPublisher){
        return repository.save(mapper.publisherDtoToPublisher(newPublisher));
    }

    public List<Publisher> getAll(){
        return repository.findAll();
    }

    public Optional<Publisher> getOne(Long id){
        return Optional.of(repository.findById(id))
                .orElseThrow(()-> new PublisherNotFoundException(id));
    }

    public Optional<Publisher> update(Long id, PublisherDTO updatedPublisher){
        return Optional.of(repository.findById(id)
                .map(publisher->{
                    publisher.setName(updatedPublisher.getName());
                    publisher.setCity(updatedPublisher.getCity());
                    return repository.save(publisher);
                }).orElseThrow(()->new PublisherNotFoundException(id)));
    }

    public Boolean delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }


}

package com.project.quotes.services;

import com.project.quotes.dto.WriterDTO;
import com.project.quotes.entities.Writer;
import com.project.quotes.exeptions.WriterNotFoundException;
import com.project.quotes.mappers.WriterMapper;
import com.project.quotes.repositories.WriterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterService {

    private final WriterRepository repository;
    private final WriterMapper mapper;


    public WriterService(WriterRepository repository, WriterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Writer create (WriterDTO newWriter){
        return repository.save(mapper.writerDTOToWriter(newWriter));
    }

    public List<Writer> getAll (){
        return repository.findAll();
    }

    public Optional<Writer> getOne(Long id){
        return Optional.of(repository.findById(id)).
                orElseThrow(()-> new WriterNotFoundException(id));
    }

    public Optional<Writer> edit(Long id,WriterDTO updatedWriter){
        return Optional.of(repository.findById(id).map(writer -> {
            //writer = mapper.writerDTOToWriter(updatedWriter);
            writer.setName(updatedWriter.getName());
            writer.setNationality(updatedWriter.getNationality());
            writer.setAlive(updatedWriter.getAlive());
            writer.setCentury(updatedWriter.getCentury());
            return repository.save(writer);
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

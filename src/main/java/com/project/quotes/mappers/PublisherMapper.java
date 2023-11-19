package com.project.quotes.mappers;


import com.project.quotes.dto.PublisherDTO;
import com.project.quotes.entities.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    Publisher publisherDtoToPublisher(PublisherDTO publisherDTO);
}

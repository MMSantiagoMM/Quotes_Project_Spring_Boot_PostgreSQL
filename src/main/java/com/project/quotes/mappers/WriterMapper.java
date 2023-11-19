package com.project.quotes.mappers;


import com.project.quotes.dto.WriterDTO;
import com.project.quotes.entities.Writer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WriterMapper {

    WriterMapper INSTANCE = Mappers.getMapper(WriterMapper.class);

    Writer writerDTOToWriter(WriterDTO writerDTO);
}

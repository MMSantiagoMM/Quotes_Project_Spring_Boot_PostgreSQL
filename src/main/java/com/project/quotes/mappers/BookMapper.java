package com.project.quotes.mappers;

import com.project.quotes.dto.BookDTO;
import com.project.quotes.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);


    Book bookDTOToBook(BookDTO bookDTO);
}

package com.project.quotes.mappers;


import com.project.quotes.dto.QuoteDTO;
import com.project.quotes.entities.Quote;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuoteMapper {

    QuoteMapper INSTANCE = Mappers.getMapper(QuoteMapper.class);

    Quote quoteDtoToQuote(QuoteDTO quoteDTO);
}

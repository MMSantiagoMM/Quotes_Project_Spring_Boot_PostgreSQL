package com.project.quotes.mappers;

import com.project.quotes.dto.CategoryDTO;
import com.project.quotes.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryDtoToCategory(CategoryDTO categoryDTO);
}

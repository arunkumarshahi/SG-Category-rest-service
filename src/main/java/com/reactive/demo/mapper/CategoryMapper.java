package com.reactive.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.reactive.demo.dto.CategoryDTO;
import com.reactive.demo.model.Category;

@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	@Mapping(source = "name", target = "categoryName")
	CategoryDTO categoryToCategoryDTO(Category category);

	@Mapping(source = "categoryName", target = "name")
	Category categoryDTOToCategory(CategoryDTO categoryDTO);

}

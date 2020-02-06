package com.reactive.demo.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.reactive.demo.dto.CategoryDTO;
import com.reactive.demo.mapper.CategoryMapper;
import com.reactive.demo.model.Category;
import com.reactive.demo.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;
//	private final CategoryMapper categoryMapper;

	public CategoryServiceImpl( CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
//		this.categoryMapper = mapper;
	}

	@Override
	public List<CategoryDTO> categoryList() {
		return categoryRepository.findAll().stream().map(CategoryMapper.INSTANCE::categoryToCategoryDTO)
				.collect(Collectors.toList());

	}

	@Override
	public CategoryDTO getCategory(String name) {
		Category category=categoryRepository.findByName(name);
		log.info("category :::"+category);
		return CategoryMapper.INSTANCE.categoryToCategoryDTO(category);

	}

}

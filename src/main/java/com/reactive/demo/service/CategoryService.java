package com.reactive.demo.service;

import java.util.List;

import com.reactive.demo.dto.CategoryDTO;

public interface CategoryService {
	public List<CategoryDTO> categoryList();

	public CategoryDTO getCategory(String name);
}

package com.reactive.demo.dto;

import lombok.Data;

@Data
public class CategoryDTO {

	public CategoryDTO(String name) {
		this.categoryName = name;
	}

	public CategoryDTO() {

	}

	private Long id;
	private String categoryName;
	private String category_url;

}

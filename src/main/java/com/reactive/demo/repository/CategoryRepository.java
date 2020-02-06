package com.reactive.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactive.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Category findByName(String name);
}

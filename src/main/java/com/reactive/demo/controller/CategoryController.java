package com.reactive.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.demo.dto.CategoryDTO;
import com.reactive.demo.dto.CategoryListDTO;
import com.reactive.demo.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CategoryController {

	private final CategoryService service;

	public CategoryController(CategoryService service) {
		this.service = service;
	}

//	@GetMapping("/name/{name}")
//	public CategoryDTO getCategoryByName(@PathVariable String name) {
//		log.info("input param ::"+name);
//		return service.getCategory(name);
//	}
//	
//	@GetMapping("/")
//	public List<CategoryDTO> getAllCategory() {
//		log.info("input param ::");
//		return service.categoryList();
//	}
//}

	@GetMapping("/name/{name}")
	public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
		log.info("input param ::" + name);

		return new ResponseEntity<CategoryDTO>(service.getCategory(name), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<CategoryListDTO> getAllCategory() {

		CategoryListDTO categoryListDTO = new CategoryListDTO();
		categoryListDTO.setCategories(service.categoryList());
		return new ResponseEntity<CategoryListDTO>(categoryListDTO, HttpStatus.OK);
	}

}

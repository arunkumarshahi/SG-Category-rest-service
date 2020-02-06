package com.reactive.demo.boot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.reactive.demo.dto.CategoryDTO;
import com.reactive.demo.mapper.CategoryMapper;
import com.reactive.demo.model.Category;
import com.reactive.demo.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CategoryBoot implements CommandLineRunner {
	private CategoryRepository categoryRepository;

	public CategoryBoot(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		String[] categoryName= {"Fried","Dried","Exotic","Nuts"};
		 List<String> list = Arrays.asList(categoryName);          
	     list.forEach(category->{this.categoryRepository.save(new Category(category));});
	     log.info("Total records = "+categoryRepository.count());
	     List<CategoryDTO> categoryDTOList=new ArrayList<CategoryDTO>();
	     categoryRepository.findAll().forEach(category->{categoryDTOList.add(CategoryMapper.INSTANCE.categoryToCategoryDTO(category));});

	     categoryDTOList.stream().forEach(System.out::println);	
	     
		
	}

}

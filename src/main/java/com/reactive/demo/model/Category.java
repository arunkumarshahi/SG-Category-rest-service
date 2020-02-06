package com.reactive.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Category {

	public Category(String name) {
		this.name = name;
	}

	public Category() {

	}

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String category_url;

}

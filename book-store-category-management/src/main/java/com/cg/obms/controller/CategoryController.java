package com.cg.obms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;
import com.cg.obms.service.CategoryService;


@CrossOrigin("*")
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("category")
	public ResponseEntity<List<Category>> listCategories() throws CategoryException{
		
		List<Category> list = categoryService.listAllCategories();
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
}

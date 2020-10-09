package com.cg.obms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obms.entity.Book;
import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;
import com.cg.obms.service.CategoryService;

@CrossOrigin("*")
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("category/view")
	public ResponseEntity<List<Category>> listCategories() throws CategoryException {

		List<Category> list = categoryService.listAllCategories();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@PostMapping("category/create")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException {

		Category newCategory = categoryService.createCategory(category);

		return new ResponseEntity<>(newCategory, HttpStatus.OK);

	}

	@GetMapping("category/search/{cid}")
	public ResponseEntity<Category> searchCategory(@PathVariable("cid") int categoryId) throws CategoryException {

		Category category = categoryService.searchCategory(categoryId);

		return new ResponseEntity<>(category, HttpStatus.OK);

	}

	@DeleteMapping("category/delete/{cid}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("cid") int categoryId) throws CategoryException {
		
		Category category = categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(category, HttpStatus.OK);

	}

	@PutMapping("category/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException {

		Category updatedCategory = categoryService.updateCategory(category);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);

	}
	
	@GetMapping("category/books/{cid}")
	public ResponseEntity<List<Book>> listBooksInCategory(@PathVariable("cid") int categoryId) throws CategoryException {

		List<Book> list = categoryService.listOfBooksInCategory(categoryId);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}

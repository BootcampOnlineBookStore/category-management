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

/************************************************************************************
 *          @author         TARUN KUMAR BANDARU
 *          
 *          Description     It is a Rest Controller class that provides the 
 *          				adding of a new category, updating a category, 
 *          				deleting a category, searching a category, list  
 *          				all the categories and list all books in a category. 
 *                                                 
 *         Version          1.0
 *         
 *         Created Date    	06-OCT-2020
 ************************************************************************************/

@CrossOrigin("*")
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	
	/************************************************************************************
	* Method		:	listAllCategories
	* Description	:	To List all the categories that are created
	* @returns		:	ResponseEntity<List<Category>>       
	* @throws		:	CategoryException when list is empty            
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	06-OCT-2020	                           		 
	************************************************************************************/
	@GetMapping("category/view")
	public ResponseEntity<List<Category>> listAllCategories() throws CategoryException {

		List<Category> list = categoryService.listAllCategories();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	
	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To List all the categories that are created
	* @returns		:	ResponseEntity<Category>      
	* @throws		:	CategoryException when an existing category is again created             
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@PostMapping("category/create")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException {

		Category newCategory = categoryService.createCategory(category);

		return new ResponseEntity<>(newCategory, HttpStatus.OK);

	}
	
	
	/************************************************************************************
	* Method		:	searchCategory
	* Description	:	To search an existing category
	* @returns		:	ResponseEntity<Category>              
	* @throws		:	CategoryException when an non existing category is searched    
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@GetMapping("category/search/{cid}")
	public ResponseEntity<Category> searchCategory(@PathVariable("cid") int categoryId) throws CategoryException {

		Category category = categoryService.searchCategory(categoryId);

		return new ResponseEntity<>(category, HttpStatus.OK);

	}

	
	/************************************************************************************
	* Method		:	deleteCategory
	* Description	:	To delete an existing category
	* @returns		:	Category              
	* @throws		:	CategoryException when an non existing category is deleted     
	* Created By	:	TARUN KUMAR BANDARU                               
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@DeleteMapping("category/delete/{cid}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("cid") int categoryId) throws CategoryException {
		
		Category category = categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(category, HttpStatus.OK);

	}

	
	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To update the categories that is already created
	* @returns		:	Category  
	* @throws		:	CategoryException when an existing category is again updated                
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	08-OCT-2020	                           		 
	************************************************************************************/
	@PutMapping("category/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException {

		Category updatedCategory = categoryService.updateCategory(category);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);

	}
	
	
	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To List all the books in a category
	* @returns		:	ResponseEntity<List<Book>>         
	* @throws		:	CategoryException when list is empty            
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	08-OCT-2020	                           		 
	************************************************************************************/
	@GetMapping("category/books/{cid}")
	public ResponseEntity<List<Book>> listBooksInCategory(@PathVariable("cid") int categoryId) throws CategoryException {

		List<Book> list = categoryService.listOfBooksInCategory(categoryId);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}

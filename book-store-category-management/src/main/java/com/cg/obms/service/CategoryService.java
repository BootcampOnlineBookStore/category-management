package com.cg.obms.service;

import java.util.List;

import com.cg.obms.entity.Book;
import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

/************************************************************************************
 *			@author         TARUN KUMAR BANDARU
 *          
 *          Description     It is a Service interface that provides the adding of  
 *          				a new category, updating a category, deleting a category, 
 *          				search a category and list all categories and list all 
 *          				books in a category. 
 *                                                 
 *         	Version          1.0
 *         
 *         	Created Date    	06-OCT-2020
 ************************************************************************************/
public interface CategoryService {
	
	public List<Category> listAllCategories() throws CategoryException;

	public Category createCategory(Category category) throws CategoryException;

	public Category searchCategory(int categoryId) throws CategoryException;

	public Category deleteCategory(int categoryId) throws CategoryException;

	public Category updateCategory(Category category) throws CategoryException;

	public List<Book> listOfBooksInCategory(int categoryId) throws CategoryException;

}

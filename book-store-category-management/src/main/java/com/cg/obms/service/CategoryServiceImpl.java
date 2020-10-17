package com.cg.obms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.obms.dao.CategoryDao;
import com.cg.obms.entity.Book;
import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

/************************************************************************************
 *          @author         TARUN KUMAR BANDARU
 *          
 *          Description     It is a Service implementation class that 
 *          				provides the adding of a new category, updating a 
 *          				category, deleting a category, search a category and 
 *          				list all categories and list all books in a category. 
 *                                                 
 *         Version          1.0
 *         
 *         Created Date    	06-OCT-2020
 ************************************************************************************/

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	static String message="ID NOT FOUND";

	
	/************************************************************************************
	* Method		:	listAllCategories
	* Description	:	To List all the categories that are created
	* @returns		:	List<Category>       
	* @throws		:	CategoryException when list is empty            
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	06-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public List<Category> listAllCategories() throws CategoryException {

		List<Category> list = categoryDao.listAllCategories();
		if(list.isEmpty())
		{
			 throw new CategoryException("Empty Record");
		}
		return list;
	}
	

	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To List all the categories that are created
	* @returns		:	Category        
	* @throws		:	CategoryException when an existing category is again created             
	* Created By	:	TARUN KUMAR BANDARUu                                
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public Category createCategory(Category category) throws CategoryException {
		
		List<Category> list = categoryDao.listAllCategories();
		List<String> categoryList = list.stream().map(c->c.getCategoryName()).collect(Collectors.toList());
		if(categoryList.contains(category.getCategoryName())) {
			throw new CategoryException("Category exists");
		}

		return categoryDao.createCategory(category);
	}
	

	/************************************************************************************
	* Method		:	searchCategory
	* Description	:	To search an existing category
	* @returns		:	Category               
	* @throws		:	CategoryException when an non existing category is searched    
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public Category searchCategory(int categoryId) throws CategoryException {
		
		Category category = categoryDao.searchCategory(categoryId); 
		if(category == null)
			throw new CategoryException(categoryId+" "+message);
		return category;
	}
	

	/************************************************************************************
	* Method		:	deleteCategory
	* Description	:	To delete an existing category
	* @returns		:	Category              
	* @throws		:	CategoryException when an non existing category is deleted     
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public Category deleteCategory(int categoryId) throws CategoryException {

		Category category = categoryDao.searchCategory(categoryId); 
		if(category == null)
			throw new CategoryException(categoryId+" "+message);
		return categoryDao.deleteCategory(categoryId);
	}
	
	
	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To update the categories that is already created
	* @returns		:	Category  
	* @throws		:	CategoryException when an existing category is again updated                
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	08-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public Category updateCategory(Category category) throws CategoryException {

		List<Category> list = categoryDao.listAllCategories();
		List<String> categoryList = list.stream().map(c->c.getCategoryName()).collect(Collectors.toList());
		if(categoryList.contains(category.getCategoryName())) {
			throw new CategoryException("Category already exists");
		}
		
		return categoryDao.updateCategory(category);
	}

	
	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To List all the books in a category
	* @returns		:	List<Book>         
	* @throws		:	CategoryException when list is empty            
	* Created By	:	TARUN KUMAR BANDARU                              
	* Created Date	:	08-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public List<Book> listOfBooksInCategory(int categoryId) throws CategoryException {
		
		List<Book> list = categoryDao.listOfBooksInCategory(categoryId);
		if(list.isEmpty()){
			 throw new CategoryException("No books in this category");
		}
		return list;
	}

}

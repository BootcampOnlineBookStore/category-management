package com.cg.obms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.obms.entity.Book;
import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

/************************************************************************************
 *          @author         TARUN KUMAR BANDARU
 *          Description     It is a Data access object class implementation that 
 *          				provides the adding of a new category, updating a 
 *          				category, delete a category, search a category and list
 *          				all categories and list all books in a category. 
                                        
 *         Version          1.0
 *         Created Date    	06-OCT-2020
 ************************************************************************************/

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	EntityManager entityManager;


	/************************************************************************************
	* Method		:	listAllCategories
	* Description	:	To List all the categories that are created
	* @returns		:	List<Category>                   
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	06-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public List<Category> listAllCategories() throws CategoryException {
		String query = "Select c from Category c";
		TypedQuery<Category> typedQuery = entityManager.createQuery(query, Category.class);
		return typedQuery.getResultList();
	}

	
	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To List all the categories that are created
	* @returns		:	Category                   
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public Category createCategory(Category category) throws CategoryException {
		entityManager.persist(category);
		return category;
	}
	
	
	/************************************************************************************
	* Method		:	searchCategory
	* Description	:	To search an existing category
	* @returns		:	Category                   
	* Created By	:	TARUN KUMAR BANDARU                               
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public Category searchCategory(int categoryId) throws CategoryException {
		Category category = entityManager.find(Category.class, categoryId);
		return category;
	}
	

	/************************************************************************************
	* Method		:	deleteCategory
	* Description	:	To delete an existing category
	* @returns		:	Category                   
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	07-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public Category deleteCategory(int categoryId) throws CategoryException {
		Category category = entityManager.find(Category.class, categoryId);
		if (category != null)
			entityManager.remove(category);
		return category;
	}
	
	

	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To update the categories that is already created
	* @returns		:	Category                   
	* Created By	:	TARUN KUMAR BANDARU                                
	* Created Date	:	08-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public Category updateCategory(Category category) throws CategoryException {
		entityManager.merge(category);
		return category;
	}
	
	
	/************************************************************************************
	* Method		:	createCategory
	* Description	:	To List all the books in a category
	* @returns		:	List<Book>                  
	* Created By	:	TARUN KUMAR BANDARU                              
	* Created Date	:	08-OCT-2020	                           		 
	************************************************************************************/
	@Override
	public List<Book> listOfBooksInCategory(int categoryId) throws CategoryException {
		String query="Select b from Book b where b.category.categoryId=:id";
		TypedQuery<Book> typedQuery = entityManager.createQuery(query,Book.class);
		return typedQuery.setParameter("id",categoryId).getResultList();
	}

}

package com.cg.obms.dao;

import java.util.List;

import com.cg.obms.entity.Book;
import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

public interface CategoryDao {

	public List<Category> listAllCategories() throws CategoryException;

	public Category createCategory(Category category) throws CategoryException;

	public Category searchCategory(int categoryId) throws CategoryException;

	public Category deleteCategory(int categoryId) throws CategoryException;

	public Category updateCategory(Category category) throws CategoryException;
	
	public List<Book> listOfBooksInCategory(int categoryId) throws CategoryException;

}

package com.cg.obms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.obms.dao.CategoryDao;
import com.cg.obms.entity.Book;
import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	static String message="ID NOT FOUND";

	@Override
	public List<Category> listAllCategories() throws CategoryException {

		List<Category> list = categoryDao.listAllCategories();
		if(list.isEmpty())
		{
			 throw new CategoryException("Empty Record");
		}
		return list;
	}

	@Override
	public Category createCategory(Category category) throws CategoryException {

		return categoryDao.createCategory(category);
	}

	@Override
	public Category searchCategory(int categoryId) throws CategoryException {
		
		Category category = categoryDao.searchCategory(categoryId); 
		if(category == null)
			throw new CategoryException(categoryId+" "+message);
		return category;
	}

	@Override
	public Category deleteCategory(int categoryId) throws CategoryException {

		Category category = categoryDao.searchCategory(categoryId); 
		if(category == null)
			throw new CategoryException(categoryId+" "+message);
		return category;
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {

		return categoryDao.updateCategory(category);
	}

	@Override
	public List<Book> listOfBooksInCategory(int categoryId) throws CategoryException {
		
		List<Book> list = categoryDao.listOfBooksInCategory(categoryId);
		if(list.isEmpty())
		{
			 throw new CategoryException("Empty Record");
		}
		return list;
	}

}

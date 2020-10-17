package com.cg.book;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.obms.dao.CategoryDao;
import com.cg.obms.entity.Book;
import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

@SpringBootTest
class BookStoreCategoryManagementApplicationTests {

	@Autowired
	CategoryDao categoryDao;
	
	@Test
	void testSearchCategoryByExsistingId() throws CategoryException{
		Category category = categoryDao.searchCategory(1001);
		assertNotNull(category);
	}
	
	@Test
	void testSearchCategoryByNonExsistingId() throws CategoryException{
		Category category = categoryDao.searchCategory(100);
		assertNull(category);
	}
	
	@Test
	void testViewAllCategories() throws CategoryException{
		List<Category> list = categoryDao.listAllCategories();
		assertNotNull(list);
				
	}
	
	@Test
	void testViewAllBooksInCategory() throws CategoryException{
		List<Book> list = categoryDao.listOfBooksInCategory(1001);
		assertNotNull(list);
				
	}
	
	@Test
	void testDeleteExsistingId() throws CategoryException{
		Category category = categoryDao.deleteCategory(1060);
		assertNotNull(category);
				
	}
	
}

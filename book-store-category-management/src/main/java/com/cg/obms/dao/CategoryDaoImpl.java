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

//data access object interface implementation
@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Category> listAllCategories() throws CategoryException {
		String query = "Select c from Category c";
		TypedQuery<Category> typedQuery = entityManager.createQuery(query, Category.class);
		return typedQuery.getResultList();
	}

	@Override
	public Category createCategory(Category category) throws CategoryException {
		entityManager.persist(category);
		return category;

	}

	@Override
	public Category searchCategory(int categoryId) throws CategoryException {
		Category category = entityManager.find(Category.class, categoryId);
		return category;
	}

	@Override
	public Category deleteCategory(int categoryId) throws CategoryException {
		Category category = entityManager.find(Category.class, categoryId);
		if (category != null)
			entityManager.remove(category);
		return category;
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {
		entityManager.merge(category);
		return category;
	}

	@Override
	public List<Book> listOfBooksInCategory(int categoryId) throws CategoryException {
		String query="Select b from Book b where b.category.categoryId=:id";
		TypedQuery<Book> typedQuery = entityManager.createQuery(query,Book.class);
		return typedQuery.setParameter("id",categoryId).getResultList();
	}

}

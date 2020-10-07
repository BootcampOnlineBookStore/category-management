package com.cg.obms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;



//data access object interface implementation
@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@PersistenceContext
	EntityManager  entityManager ;
	
	@Override
	public List<Category> listAllCategories() throws CategoryException {
		String query="Select c from Category c";
		TypedQuery<Category> typedQuery = entityManager.createQuery(query,Category.class);
		return typedQuery.getResultList();
	}

}
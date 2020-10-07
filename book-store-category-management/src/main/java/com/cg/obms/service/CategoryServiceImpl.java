package com.cg.obms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.obms.dao.CategoryDao;
import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	@Override
	public List<Category> listAllCategories() throws CategoryException {
	
		return categoryDao.listAllCategories();
	}

}

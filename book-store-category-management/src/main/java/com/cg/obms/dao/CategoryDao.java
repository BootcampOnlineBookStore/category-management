package com.cg.obms.dao;

import java.util.List;

import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

public interface CategoryDao {
	
	public List<Category> listAllCategories() throws CategoryException;
	

}

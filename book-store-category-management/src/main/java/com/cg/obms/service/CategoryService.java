package com.cg.obms.service;

import java.util.List;

import com.cg.obms.entity.Category;
import com.cg.obms.exception.CategoryException;

public interface CategoryService {
	public List<Category> listAllCategories() throws CategoryException;
	


}

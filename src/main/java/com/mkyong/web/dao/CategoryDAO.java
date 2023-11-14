package com.mkyong.web.dao;

import java.util.List;

import com.mkyong.web.entities.Category;

public interface CategoryDAO {
	public List<Category> getCategories();
	public boolean insertCategory(Category c);
	public Category getCategoryById(Integer id);
	public boolean updateCategory(Category c);
	public boolean deleteCategory(Integer id);
	public List<Category> getCategoriesByName(String categoryName);
}

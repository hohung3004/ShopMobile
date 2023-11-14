package com.mkyong.web.dao;

import java.util.List;

import com.mkyong.web.entities.Subcategory;

public interface SubcategoryDAO {
	public List<Subcategory> getSubcategories();
	public boolean insertSubcategory(Subcategory sub);
	public Subcategory getSubcategoryById(Integer id);
	public boolean updateSubcategory(Subcategory sub);
	public boolean deleteSubcategory(Integer id);
	public List<Subcategory> getSubcategoriesByName(String subcategory);
}

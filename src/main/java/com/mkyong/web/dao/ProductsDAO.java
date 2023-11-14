package com.mkyong.web.dao;

import java.util.List;

import com.mkyong.web.entities.Products;

public interface ProductsDAO {
	public List<Products> getProducts();
	public List<Products> getProducts(Integer offset, Integer maxResult);
	public Long getTotalProducts();
	public boolean insertProducts(Products pro);
	public Products getProductsById(Integer id);
	public boolean updateProducts(Products pro);
	public boolean deleteProducts(Integer id);
	public List<Products> getProductsByName(String productName);
	public List<Products> menu(Integer id);
}

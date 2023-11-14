package com.mkyong.web.entities;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "subcategory")
public class Subcategory{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column (name = "subcategory")
	private String subcategory;
	@Column(name ="postingDate")
	private Date postingDate;
	@Column(name = "updationDate")
	private String updationDate;
	
	@ManyToOne()
	@JoinColumn(name = "categoryid", referencedColumnName = "id")
	public Category category;
	
	@OneToMany(mappedBy = "subcategory")
	private Set<Products> products;
	
	
	public Subcategory() {
		// TODO Auto-generated constructor stub
	}


	public Subcategory(Integer id, @NotEmpty(message = "Tên danh mục sản phẩm không được để trống!") String subcategory,
			Date postingDate, String updationDate, Category category, Set<Products> products) {
		super();
		this.id = id;
		this.subcategory = subcategory;
		this.postingDate = postingDate;
		this.updationDate = updationDate;
		this.category = category;
		this.products = products;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	public Date getPostingDate() {
		return postingDate;
	}


	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}


	public String getUpdationDate() {
		return updationDate;
	}


	public void setUpdationDate(String updationDate) {
		this.updationDate = updationDate;
	}


	public Set<Products> getProducts() {
		return products;
	}


	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	
	
	
}

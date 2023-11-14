package com.mkyong.web.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "category")
public class Category{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty (message ="Tên danh mục không để trống!" )
	@Column(name = "categoryName")
	private String categoryName;
	@NotEmpty (message ="Mô tả danh mục không để trống!" )
	@Column(name = "categoryDescription")
	private String categoryDescription;
	@Column(name ="postingDate")
	private Date postingDate;
	@Column(name = "updationDate")
	private String updationDate;
	
	@OneToMany(mappedBy = "category")
	private Set<Subcategory> subcategories;

	@OneToMany(mappedBy = "category")
	private Set<Products> products ;

	public Category() {
		// TODO Auto-generated constructor stub
	}
	

	public Category(Integer id, @NotEmpty(message = "Tên danh mục không để trống!") String categoryName,
			@NotEmpty(message = "Mô tả danh mục không để trống!") String categoryDescription, Date postingDate,
			String updationDate, Set<Subcategory> subcategories, Set<Products> products) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.postingDate = postingDate;
		this.updationDate = updationDate;
		this.subcategories = subcategories;
		this.products = products;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
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


	public Set<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

}

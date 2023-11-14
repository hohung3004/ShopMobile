package com.mkyong.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productreviews")
public class ProductDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "quality")
	private Integer quantity;
	@Column(name = "price")
	private Integer price;
	@Column(name = "value")
	private Integer value;
	@Column(name ="name")
	private String name;
	@Column(name ="summary")
	private String summary;
	@Column(name = "review")
	private String review;
	@Column(name ="reviewDate")
	private String reviewDate;
	
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "id")
	public Products products;
	
	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}

	public ProductDetails(Integer id, Integer quantity, Integer price, Integer value, String name, String summary,
			String review, String reviewDate, Products products) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.value = value;
		this.name = name;
		this.summary = summary;
		this.review = review;
		this.reviewDate = reviewDate;
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
	
}

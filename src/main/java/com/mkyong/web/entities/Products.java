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
@Table(name = "products")
public class Products {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productCompany")
	private String productCompany;
	@Column(name ="productPrice")
	private Double productPrice;
	@Column(name = "productPriceBeforeDiscount")
	private Double productPriceBeforeDiscount;
	@Column(name = "productDescription")
	private String productDescription;
	@Column(name = "productImage1")
	private String productImage1;
	@Column(name = "productImage2")
	private String productImage2;
	@Column(name = "productImage3")
	private String productImage3;
	@Column(name = "shippingCharge")
	private Integer shippingCharge;
	@Column(name = "productAvailability")
	private String productAvailability;
	@Column(name ="postingDate")
	private Date postingDate;
	@Column(name = "updationDate")
	private String updationDate;

	@ManyToOne
	@JoinColumn(name = "subCategory", referencedColumnName = "id")
	public Subcategory subcategory;
	
	@ManyToOne
	@JoinColumn(name = "category", referencedColumnName = "id")
	public Category category;
	
	@OneToMany(mappedBy = "products")
	private Set<ProductDetails> productDetails;
	
	@OneToMany(mappedBy = "products")
	private Set<Orders> orders;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(Integer id, String productName, String productCompany, Double productPrice,
			Double productPriceBeforeDiscount, String productDescription, String productImage1, String productImage2,
			String productImage3, Integer shippingCharge, String productAvailability, Date postingDate,
			String updationDate, Subcategory subcategory, Category category, Set<ProductDetails> productDetails,
			Set<Orders> orders) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCompany = productCompany;
		this.productPrice = productPrice;
		this.productPriceBeforeDiscount = productPriceBeforeDiscount;
		this.productDescription = productDescription;
		this.productImage1 = productImage1;
		this.productImage2 = productImage2;
		this.productImage3 = productImage3;
		this.shippingCharge = shippingCharge;
		this.productAvailability = productAvailability;
		this.postingDate = postingDate;
		this.updationDate = updationDate;
		this.subcategory = subcategory;
		this.category = category;
		this.productDetails = productDetails;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getProductPriceBeforeDiscount() {
		return productPriceBeforeDiscount;
	}

	public void setProductPriceBeforeDiscount(Double productPriceBeforeDiscount) {
		this.productPriceBeforeDiscount = productPriceBeforeDiscount;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage1() {
		return productImage1;
	}

	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}

	public String getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}

	public String getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}

	public Integer getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(Integer shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public String getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(String productAvailability) {
		this.productAvailability = productAvailability;
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

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(Set<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", productCompany=" + productCompany
				+ ", productPrice=" + productPrice + ", productPriceBeforeDiscount=" + productPriceBeforeDiscount
				+ ", productDescription=" + productDescription + ", productImage1=" + productImage1 + ", productImage2="
				+ productImage2 + ", productImage3=" + productImage3 + ", shippingCharge=" + shippingCharge
				+ ", productAvailability=" + productAvailability + "]";
	}
	
	
	
}

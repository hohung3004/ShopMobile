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

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name ="userOr")
	private String userOr;
	@Column(name ="phonenumber")
	private String phonenumber;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "totalPrice")
	private Double totalPrice;
	@Column(name = "orderDate")
	private String orderDate;
	@Column(name = "paymentMethod")
	private String paymentMethod;
	@Column(name ="shippingAddress")
	private String shippingAddress;
	@Column(name ="shippingState")
	private String shippingState;
	@Column(name ="shippingCity")
	private String shippingCity;
	@Column(name ="shippingPincode")
	private String shippingPincode;
	@Column(name="regDate")
	private String regDate;
	@Column(name = "orderStatus")
	private String orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "id")
	public Products products;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	public Users users;
	
	@OneToMany(mappedBy = "orders")
	private Set<Ordertrackhistory> ordertrackhistories ;
	
	@OneToMany(mappedBy = "orders")
	private Set<Orders> orders;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}


	



	





	public Orders(Integer id, String userOr, String phonenumber, Integer quantity, Double totalPrice, String orderDate,
			String paymentMethod, String shippingAddress, String shippingState, String shippingCity,
			String shippingPincode, String regDate, String orderStatus, Products products, Users users,
			Set<Ordertrackhistory> ordertrackhistories, Set<Orders> orders) {
		super();
		this.id = id;
		this.userOr = userOr;
		this.phonenumber = phonenumber;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.paymentMethod = paymentMethod;
		this.shippingAddress = shippingAddress;
		this.shippingState = shippingState;
		this.shippingCity = shippingCity;
		this.shippingPincode = shippingPincode;
		this.regDate = regDate;
		this.orderStatus = orderStatus;
		this.products = products;
		this.users = users;
		this.ordertrackhistories = ordertrackhistories;
		this.orders = orders;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getUserOr() {
		return userOr;
	}












	public void setUserOr(String userOr) {
		this.userOr = userOr;
	}












	public String getPhonenumber() {
		return phonenumber;
	}












	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}












	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	

	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}


	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingPincode() {
		return shippingPincode;
	}

	public void setShippingPincode(String shippingPincode) {
		this.shippingPincode = shippingPincode;
	}


	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}


	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Set<Ordertrackhistory> getOrdertrackhistories() {
		return ordertrackhistories;
	}

	public void setOrdertrackhistories(Set<Ordertrackhistory> ordertrackhistories) {
		this.ordertrackhistories = ordertrackhistories;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	
}

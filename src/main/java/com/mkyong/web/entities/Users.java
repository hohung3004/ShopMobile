package com.mkyong.web.entities;

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
@Table(name = "users")
public class Users {
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty (message ="Tên người dùng không được để trống!" )
	@Column(name ="name")
	private String name;
	@NotEmpty (message ="Email không được để trống!" )
	@Column(name ="email")
	private String email;
	@Column(name ="contactno")
	private String contactno;
	@NotEmpty (message ="Password không được để trống!" )

	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "users")
	private Set<Orders> orders;
	
	@OneToMany(mappedBy = "users")
	private Set<Wishlist> wishlists;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	

	public Users(Integer id, String name, String email, String contactno, String password, Set<Orders> orders, Set<Wishlist> wishlists) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.password = password;
		this.orders = orders;
		this.wishlists = wishlists;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<Wishlist> getWishlists() {
		return wishlists;
	}

	public void setWishlists(Set<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}
	
	
}

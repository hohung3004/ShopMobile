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
@Table(name ="wishlist")
public class Wishlist {
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name ="postingDate")
	private String postingDate;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	public Users users;
	
	public Wishlist() {
		// TODO Auto-generated constructor stub
	}

	public Wishlist(Integer id, String postingDate, Users users) {
		super();
		this.id = id;
		this.postingDate = postingDate;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	

}

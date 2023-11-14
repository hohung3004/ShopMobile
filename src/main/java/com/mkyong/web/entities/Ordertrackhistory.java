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
@Table(name = "ordertrackhistory")
public class Ordertrackhistory {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "status")
	private String status;
	@Column(name = "remark")
	private String remark;
	@Column(name = "postingDate")
	private String postingDate;
	
	@ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName = "id")
	public Orders orders;
	
	public Ordertrackhistory() {
		// TODO Auto-generated constructor stub
	}

	public Ordertrackhistory(Integer id, String status, String remark, String postingDate, Orders orders) {
		super();
		this.id = id;
		this.status = status;
		this.remark = remark;
		this.postingDate = postingDate;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
}

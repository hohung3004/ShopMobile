package com.mkyong.web.dao;

import java.util.List;

import com.mkyong.web.entities.OrderDetail;

public interface OrderDetailDAO {
	public List<OrderDetail> getOrderDetails();
	public boolean insertOrderDetail (OrderDetail orDetail);
	
}

package com.mkyong.web.dao;

import java.util.List;

import com.mkyong.web.entities.Orders;

public interface OrdersDAO {
	public List<Orders> getOrders();
	public int insertOrder(Orders or);
}

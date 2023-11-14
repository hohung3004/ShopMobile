package com.mkyong.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mkyong.web.dao.OrderDetailDAO;
import com.mkyong.web.dao.OrdersDAO;
import com.mkyong.web.entities.OrderDetail;
import com.mkyong.web.entities.Orders;

@Controller
@RequestMapping("/admin")
public class OrdersController {
	@Autowired
	private OrdersDAO ordersDAO;
	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@RequestMapping("/loadOrders")
	public String loadOrders(Model model) {

		List<Orders> list = ordersDAO.getOrders();
		model.addAttribute("list", list);
		return "admin/orders_admin";
	}

	@RequestMapping("/loadOrderDetail")
	public String loadOrderDetail(Model model) {

		List<OrderDetail> list = orderDetailDAO.getOrderDetails();
		model.addAttribute("list", list);
		return "admin/orderDetail_admin";
	}
	
	 
}

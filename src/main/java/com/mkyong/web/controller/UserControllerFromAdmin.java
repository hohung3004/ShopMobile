package com.mkyong.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mkyong.web.dao.CategoryDAO;
import com.mkyong.web.dao.OrderDetailDAO;
import com.mkyong.web.dao.OrdersDAO;
import com.mkyong.web.dao.ProductsDAO;
import com.mkyong.web.dao.SubcategoryDAO;
import com.mkyong.web.entities.Category;
import com.mkyong.web.entities.OrderDetail;
import com.mkyong.web.entities.Orders;
import com.mkyong.web.entities.Products;
import com.mkyong.web.entities.Subcategory;
import com.mkyong.web.entities.Users;

@Controller
public class UserControllerFromAdmin {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SubcategoryDAO subcategoryDAO;
	@Autowired
	private ProductsDAO productsDAO;
	@Autowired
	private OrdersDAO ordersDAO;
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf,true));
	}
	
	@RequestMapping(value = {"/", "/user"})
	public String user( Model model) {
		
			
		List<Products> list = productsDAO.getProducts();
		model.addAttribute("list", list);
			
		List<Products> listh1 = productsDAO.getProducts();
		model.addAttribute("listh1", listh1);
		
		List<Products> listh2 = productsDAO.getProducts();
		model.addAttribute("listh2", listh2);
				
		return "user/home";
	}

	
	@RequestMapping("/userHome" )
	public String userHome(@RequestParam(name = "page", required = false) Integer page,Model model) {
		if(page == null) 
			page = 1;
		int maxResult = 8;
		int offset = (page -1)* maxResult;
			
		long totalProducts = productsDAO.getTotalProducts();
		int totalPage = (int) (totalProducts/maxResult+(totalProducts%maxResult==0?0:1));
		
		List<Category> listca = categoryDAO.getCategories();
		List<Subcategory> listsub = subcategoryDAO.getSubcategories();
		List<Products> list = productsDAO.getProducts(offset, maxResult);
		
		model.addAttribute("listca", listca);
		model.addAttribute("listsub", listsub);
		model.addAttribute("list", list);
			
		List<Integer> listPage = new ArrayList<>();
		for (int i = 1;i<=totalPage;i++) 
			listPage.add(i);
		model.addAttribute("listPage", listPage);
		return "user/category";
	}
	
	@RequestMapping("/detailProductsUser")
	public String detailProductsUser(@RequestParam("id") Integer id, Model model) {
		Products products = productsDAO.getProductsById(id);
		model.addAttribute("p", products);
		return "user/detailProductsUser";
	}
	
	@RequestMapping("/addToCart")
	public String insertOrder(@RequestParam("id")Integer id,
								HttpSession session, Model model) {
		Products product = productsDAO.getProductsById(id);
		List<OrderDetail> listOrdertail= (List<OrderDetail>) session.getAttribute("listOrdetail"); 
		
		if(listOrdertail == null) {
			
			listOrdertail = new ArrayList<>();
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setProducts(product);
			orderDetail.setQuantity(1); 
			orderDetail.setUnitPrice(product.getProductPriceBeforeDiscount());
			orderDetail.setTotalPrice(orderDetail.getUnitPrice()* orderDetail.getQuantity());
			
			listOrdertail.add(orderDetail);
		} else {
			//nếu nó không null
			//check trong list xem da ton tai san pham do hay chua
			Boolean isExist = false;
			for (OrderDetail orderDetail : listOrdertail) {
				if(orderDetail.getProducts().getId()==id) {
					isExist = true;
					orderDetail.setQuantity(orderDetail.getQuantity()+1);//tang 1 san pham
					orderDetail.setTotalPrice(orderDetail.getUnitPrice()* orderDetail.getQuantity());
				}
			}
			
			if (!isExist) {
				OrderDetail order = new OrderDetail();
				order.setProducts(product);
				order.setQuantity(1); //set mac dinh cho no la 1 sp
				order.setUnitPrice(product.getProductPriceBeforeDiscount());
				order.setTotalPrice(order.getUnitPrice()* order.getQuantity()); 
				listOrdertail.add(order);
			}
			
		}
		
		session.setAttribute("listOrdetail", listOrdertail); 
		return "redirect:/user"; 
	}
	
	@RequestMapping("orderDetailUser")
	private String orderDetailUser(HttpSession session, Model model) {
		List<OrderDetail> listOrdertail= (List<OrderDetail>) session.getAttribute("listOrdertail");
		model.addAttribute("listOrdertail", listOrdertail);
		return "user/cart";
	}
	
	
	@RequestMapping("deleteProductToCart")
	public String deleteProductToCart(@RequestParam("id")Integer id,Model model, HttpSession session) {
		List<OrderDetail> listOrdertail= (List<OrderDetail>) session.getAttribute("listOrdetail");
		OrderDetail order = null;
		for (OrderDetail orderDetail : listOrdertail) {
			if(orderDetail.getProducts().getId()==id) {
				order = orderDetail;
			}
		}
		
		if (order != null) {
			listOrdertail.remove(order);
		}
		session.setAttribute("listOrdetail", listOrdertail);
		return "user/cart";
	}
	
	@RequestMapping("/searchProductsByNameUser")
	public String searchProductsByNameUser(@RequestParam("productName") String productName, Model model) {
		List<Products> list = productsDAO.getProductsByName(productName);
		model.addAttribute("list", list);
		return "user/search_products";
	}
	
	@RequestMapping("/initInsertOrders")
	public String initInsertOrders(HttpSession session, Model model) {
		Users user = (Users) session.getAttribute("user");
		Orders or = new Orders();
		
		model.addAttribute("or", or);
		model.addAttribute("user", user);
		return "user/checkout";
	}
	
	 @RequestMapping("/insertOrders") 
	 public String insertOrders(@ModelAttribute("or") Orders o, @RequestParam("userId")int id, Model model, HttpSession session) {
		 List<OrderDetail> listOrdertail= (List<OrderDetail>) session.getAttribute("listOrdetail");
		 double totalPrice = 0;
		 int totalQty = 0;
		 double unitPrice = 0;
		 if (listOrdertail != null) {
			 for (OrderDetail orderDetail : listOrdertail) {
				 totalPrice += orderDetail.getTotalPrice();
				 totalQty += orderDetail.getQuantity();
				 unitPrice = totalPrice*totalQty;
			 }
		 }
		 Users u = new Users();
		 u.setId(id);
		 o.setUsers(u);
		 o.setTotalPrice(totalPrice);
		 o.setQuantity(totalQty);
		 
		 int rs = ordersDAO.insertOrder(o);
			if (rs > 1) {
				
				for (OrderDetail orderDetail : listOrdertail) {
					Orders order = new Orders();
					order.setId(rs);
					orderDetail.setOrders(order);
					orderDetailDAO.insertOrderDetail(orderDetail);
				}
				
				model.addAttribute("success", "Đặt hàng thành công");
				return "redirect:user";
			} else {
				model.addAttribute("err", "Đặt hàng không thành công! Đặt lại");
				model.addAttribute("o", o);
				return "user/checkout";
			}
		}
	 
	 @RequestMapping("/loadsubuser")
		public String loadsubuser(@RequestParam("id")Integer id, Model model) {
			Products products =  (Products) productsDAO.menu(id);
			model.addAttribute("pro", products);
			return "user/category";
		}
	
}

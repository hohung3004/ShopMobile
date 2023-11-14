package com.mkyong.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkyong.web.dao.AdminDAO;
import com.mkyong.web.dao.CategoryDAO;
import com.mkyong.web.entities.Admin;
import com.mkyong.web.entities.Category;

@Controller

public class LoginAdminController {
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/initLoginAdmin")
	public String initLoginAdmin() {
		return "admin/login_admin";
	}

	@RequestMapping("/loginAdmin")
	public String loginAdmin(@RequestParam("emailadmin") String email, @RequestParam("password") String password,
			Model model, HttpSession session) {
		List<Admin> list = adminDAO.loginAmin(email, password);
		List<Category> listcate = categoryDAO.getCategories();
		if (list.size() > 0) {
			model.addAttribute("success", "Đăng nhập thành công");
			model.addAttribute("user", list.get(0));
			session.setAttribute("admin", list.get(0));
			model.addAttribute("list", listcate);
			return "redirect:admin/loadCategory";
		} else {
			model.addAttribute("err", "Đăng nhập không thành công");
			return "admin/login_admin";
		}
	}
}

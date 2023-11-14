package com.mkyong.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkyong.web.dao.UsersDAO;
import com.mkyong.web.entities.Users;

@Controller
public class LoginController {
	@Autowired
	private UsersDAO usersDAO;

	
	@RequestMapping("/loadLogin")
	public String loadLogin(Model model) {
		List<Users> list = usersDAO.getUsers();
		model.addAttribute("list", list);
		return "login/login";
	}

	@RequestMapping(value = "/initInsertUser" )
	public String initInsertUser(Model model) {
		Users u = new Users();
		model.addAttribute("u", u);
		return "login/register";
	}

	@RequestMapping("/insertUser")
	public String insertUser(@ModelAttribute("u") Users u, Model model) {
		boolean bl = usersDAO.insertUser(u);
		if (bl) {
			return "redirect:/loadLogin";
		} else {
			model.addAttribute("err", "Insert Failed!");
			model.addAttribute("u", u);
			return "login/login";
		}
	}
	
	@RequestMapping("/loginUser")
	public String loginUser(@RequestParam("email") String email,
							@RequestParam("password") String password, Model model, HttpSession session) {
		List<Users> list = usersDAO.login(email, password);
		if(list.size() >0) {
			model.addAttribute("success", "Đăng nhập thành công");
			model.addAttribute("user", list.get(0));
			session.setAttribute("user", list.get(0));
			return "redirect:/user";
		}else
		model.addAttribute("err", "Đăng nhập không thành công");
		return "login/login";
	}
	
}

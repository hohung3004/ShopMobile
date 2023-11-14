package com.mkyong.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mkyong.web.dao.UsersDAO;
import com.mkyong.web.entities.Users;

@Controller
@RequestMapping("/admin")
public class UsersController {
	@Autowired
	private UsersDAO usersDAO;
	
	@RequestMapping(value= "/loadUsers")
	public String loadUsers(Model model) {
		
		
		List<Users> list = usersDAO.getUsers();
		model.addAttribute("list", list);
		return "admin/users_admin";
	}
	
	
}

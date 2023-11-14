package com.mkyong.web.controller;

import java.text.SimpleDateFormat;
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

import com.mkyong.web.dao.CategoryDAO;
import com.mkyong.web.entities.Category;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping(value = {"", "/loadCategory"})
	public String loadCategory (Model model, HttpSession session) {
		

		List<Category> list = categoryDAO.getCategories();
		model.addAttribute("list", list);
		return "admin/category_admin";
	}
	
	@RequestMapping("/initInsertCategory")
	public String initInsertCategory(Model model) {
		Category c = new Category();
		model.addAttribute("c", c);
		return "admin/insertCategory";
	}
	
	
	@RequestMapping("/insertCategory")
	public String insertCategory (@ModelAttribute("c")Category c,Model model) {
		boolean bl = categoryDAO.insertCategory(c);
		if(bl) {
			return "redirect:/admin/loadCategory";
		}else {
			model.addAttribute("err","Insert Failed!");
			model.addAttribute("c", c);
			return "admin/insertCategory";
		}
	}
	
	@RequestMapping("/detailCategory")
	public String detailCategory(@RequestParam("id")Integer id, Model model) {
		Category category = categoryDAO.getCategoryById(id);
		model.addAttribute("c", category);
		return "admin/detailCategory";
	}
	
	@RequestMapping("/initUpdateCategory")
	public String initUpdateCategory(@RequestParam("id")Integer id, Model model) {
		Category category = categoryDAO.getCategoryById(id);
		model.addAttribute("c", category);
		
		return "admin/updateCategory";
	}
	
	@RequestMapping("/updateCategory")
	public String updateCategory (@ModelAttribute("c")Category c,Model model) {
		boolean bl = categoryDAO.updateCategory(c);
		if(bl) {
			return "redirect:/admin/loadCategory";
		}else {
			model.addAttribute("err","Update Failed!");
			model.addAttribute("c", c);
			return "admin/updateCategory";
		}
	}
	
	@RequestMapping("/deleteCategory")
	public String deleteCategory(@RequestParam("id")Integer id, Model model) {
		boolean bl = categoryDAO.deleteCategory(id);
		if(bl) {
			model.addAttribute("success","Delete Successfully!");
		}else {
			model.addAttribute("err","Delete Fail!");
		}
		List<Category> list = categoryDAO.getCategories();
		model.addAttribute("list", list);
		return "admin/category_admin";
	}
	
	@RequestMapping("/searchCategoryByName")
	public String searchCategoryByName(@RequestParam("categoryName")String categoryName, Model model) {
		List<Category> list = categoryDAO.getCategoriesByName(categoryName);
		model.addAttribute("list", list);
		return "admin/category_admin";
	}
	
	@RequestMapping("/logoutAdmin")
	public String logoutAdmin(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/admin/initLoginAdmin";
	}
	
}

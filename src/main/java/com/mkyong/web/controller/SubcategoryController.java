package com.mkyong.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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
import com.mkyong.web.dao.SubcategoryDAO;
import com.mkyong.web.entities.Category;
import com.mkyong.web.entities.Subcategory;

@Controller
@RequestMapping("/admin")
public class SubcategoryController {
	@Autowired
	private SubcategoryDAO subcategoryDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping(value="/loadSubcategory")
	public String loadSubcategory(Model model) {
		
		List<Subcategory> list = subcategoryDAO.getSubcategories();
		model.addAttribute("list", list);
		return "admin/subcategory_admin";
	}
	
	@RequestMapping("/initInsertSubcategory")
	public String initInsertSubcategory(Model model) {
		List<Category> listCate = categoryDAO.getCategories();
		Subcategory s = new Subcategory();
		model.addAttribute("listCate", listCate);
		model.addAttribute("s", s);
		return "admin/insertSubcategory";
	}
	
	
	@RequestMapping("/insertSubcategory")
	public String insertSubcategory (@ModelAttribute("s")Subcategory sub,Model model) {
		boolean bl = subcategoryDAO.insertSubcategory(sub);
		if(bl) {
			return "redirect:/admin/loadSubcategory";
		}else {
			model.addAttribute("err","Insert Failed!");
			List<Category> listCate = categoryDAO.getCategories();
			
			model.addAttribute("listCate", listCate);
			model.addAttribute("s", sub);
			return "admin/insertSubcategory";
		}
	}
	
	@RequestMapping("/detailSubcategory")
	public String detailSubcategory(@RequestParam("id")Integer id,Model model) {
		Subcategory subcategory = subcategoryDAO.getSubcategoryById(id);
		model.addAttribute("s", subcategory);
		return "admin/detailSubcategory";
	}
	
	@RequestMapping("/initUpdateSubcategory")
	public String initUpdateSubcategory(@RequestParam("id")Integer id, Model model ) {
		Subcategory subcategory = subcategoryDAO.getSubcategoryById(id);
		model.addAttribute("s", subcategory);
		List<Category> listCate = categoryDAO.getCategories();
		model.addAttribute("listCate", listCate);
		
		return "admin/updateSubcategory";
	}
	
	@RequestMapping("/updateSubcategory")
	public String updateSubcategory (@ModelAttribute("s")Subcategory sub,Model model) {
		boolean bl = subcategoryDAO.updateSubcategory(sub);
		if(bl) {
			return "redirect:/admin/loadSubcategory";
		}else {
			model.addAttribute("err","Update Failed!");
			List<Category> listCate = categoryDAO.getCategories();
			
			model.addAttribute("listCate", listCate);
			model.addAttribute("s", sub);
			return "admin/updateSubcategory";
		}
	}
	
	@RequestMapping("/deleteSubcategory")
	public String deleteSubcategory(@RequestParam("id")Integer id, Model model) {
		boolean bl = subcategoryDAO.deleteSubcategory(id);
		if(bl) {
			model.addAttribute("success","Delete Successfully!");
		}else {
			model.addAttribute("err","Delete Fail!");
		}
		List<Subcategory> list = subcategoryDAO.getSubcategories();
		model.addAttribute("list", list);
		return "subcategory_admin";
	}
	
	@RequestMapping("/searchSubcategoryByName")
	public String searchSubcategoryByName(@RequestParam("subcategory")String subcategory, Model model) {
		List<Subcategory> list = subcategoryDAO.getSubcategoriesByName(subcategory);
		model.addAttribute("list", list);
		return "admin/subcategory_admin";
	}
}

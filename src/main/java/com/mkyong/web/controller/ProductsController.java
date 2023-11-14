package com.mkyong.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mkyong.web.dao.CategoryDAO;
import com.mkyong.web.dao.ProductsDAO;
import com.mkyong.web.dao.SubcategoryDAO;
import com.mkyong.web.entities.Category;
import com.mkyong.web.entities.Products;
import com.mkyong.web.entities.Subcategory;

@Controller
@RequestMapping("/admin")
public class ProductsController {
	@Autowired
	private ProductsDAO productsDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SubcategoryDAO subcategoryDAO;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping(value = "/loadProducts")
	public String loadProducts(Model model) {
		
		
		List<Products> list = productsDAO.getProducts();
		model.addAttribute("list", list);
		return "admin/products_admin";
	}

	@RequestMapping("/initInsertProducts")
	public String initInsertProducts(Model model) {
		List<Subcategory> listSub = subcategoryDAO.getSubcategories();
		List<Category> listCate = categoryDAO.getCategories();
		Products p = new Products();
		model.addAttribute("listSub", listSub);
		model.addAttribute("listCate", listCate);
		model.addAttribute("p", p);
		return "admin/insertProducts";
	}

	@RequestMapping("/insertProducts")
	public String insertProducts(@Validated @ModelAttribute("p") Products pro,
			@RequestParam("productImage1Source")MultipartFile fileImage,
			@RequestParam("productImage2Source")MultipartFile fileImage1,
			@RequestParam("productImage3Source")MultipartFile fileImage2,
			HttpServletRequest request, Model model) {
//			xu ly anh1
		String path = request.getServletContext().getRealPath("resources/them1/img");
		File f = new File(path);

		File destination = new File(f.getAbsolutePath() + "/" + fileImage.getOriginalFilename());
		if (!destination.exists()) {
			try {
				Files.write(destination.toPath(), fileImage.getBytes(), StandardOpenOption.CREATE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//		xu ly anh2
		String path1 = request.getServletContext().getRealPath("resources/them1/img");
		File f1 = new File(path1);
	
		File destination1 = new File(f1.getAbsolutePath() + "/" + fileImage1.getOriginalFilename());
		if (!destination1.exists()) {
			try {
				Files.write(destination1.toPath(), fileImage1.getBytes(), StandardOpenOption.CREATE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//	xu ly anh3
	String path2 = request.getServletContext().getRealPath("resources/them1/img");
	File f2 = new File(path2);
	
	File destination2 = new File(f2.getAbsolutePath() + "/" + fileImage2.getOriginalFilename());
	if (!destination2.exists()) {
		try {
			Files.write(destination2.toPath(), fileImage2.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		pro.setProductImage1(fileImage.getOriginalFilename());
		pro.setProductImage2(fileImage1.getOriginalFilename());
		pro.setProductImage3(fileImage2.getOriginalFilename());
		boolean bl = productsDAO.insertProducts(pro);

		
		if (bl) {
			return "redirect:/admin/loadProducts";
		} else {
			model.addAttribute("err", "Insert Failed!");
			List<Subcategory> listSub = subcategoryDAO.getSubcategories();
			List<Category> listCate = categoryDAO.getCategories();
			model.addAttribute("listSub", listSub);
			model.addAttribute("listCate", listCate);
			model.addAttribute("p", pro);
			return "admin/insertProducts";
		}
	}

	@RequestMapping("/detailProducts")
	public String detailProducts(@RequestParam("id") Integer id, Model model) {
		Products products = productsDAO.getProductsById(id);
		model.addAttribute("p", products);
		return "admin/detailProducts";
	}
	
	@RequestMapping("/initUpdateProducts")
	public String initUpdateProducts(@RequestParam("id") Integer id, Model model) {
		Products products = productsDAO.getProductsById(id);
		List<Subcategory> listSub = subcategoryDAO.getSubcategories();
		List<Category> listCate = categoryDAO.getCategories();

		model.addAttribute("p", products);
		model.addAttribute("listSub", listSub);
		model.addAttribute("listCate", listCate);
		return "admin/updateProducts";
	}

	@RequestMapping("/updateProducts")
	public String updateProducts(@ModelAttribute("p") Products pro, Model model) {
		boolean bl = productsDAO.updateProducts(pro);
		if (bl) {
			return "redirect:/admin/loadProducts";
		} else {
			model.addAttribute("err", "Update Failed!");
			List<Subcategory> listSub = subcategoryDAO.getSubcategories();
			List<Category> listCate = categoryDAO.getCategories();

			model.addAttribute("listSub", listSub);
			model.addAttribute("listCate", listCate);
			model.addAttribute("p", pro);
			return "admin/updateProducts";
		}
	}

	@RequestMapping("/deleteProducts")
	public String deleteProducts(@RequestParam("id") Integer id, Model model) {
		boolean bl = productsDAO.deleteProducts(id);
		if (bl) {
			model.addAttribute("success", "Delete Successfully!");
		} else {
			model.addAttribute("err", "Delete Fail!");
		}
		List<Products> list = productsDAO.getProducts();
		model.addAttribute("list", list);
		return "admin/products_admin";
	}

	@RequestMapping("/searchProductsByName")
	public String searchProductsByName(@RequestParam("productName") String productName, Model model) {
		List<Products> list = productsDAO.getProductsByName(productName);
		model.addAttribute("list", list);
		return "admin/products_admin";
	}
	

}
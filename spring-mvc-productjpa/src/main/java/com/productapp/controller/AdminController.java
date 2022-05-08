package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class AdminController {
	@Autowired
	IProductService iProductService;
	@RequestMapping("/admin")
	public String admin() {
		
		return "admin";
	}
    @RequestMapping("/addForm")
    public String productForm() {
    	return "addProductForm";
    }
    @RequestMapping("/editForm")
    public String ProductEditForm() {
        return "editProductForm";
    }
    @RequestMapping("/deleteForm")
    public String deleteForm() {
    	return "deleteProductForm";
    }
    @RequestMapping("/home")
    public String home(ModelMap map) {
    	List<Product> products = iProductService.getAll();
		map.addAttribute("products",products);
    	return "home";
    }
    
}

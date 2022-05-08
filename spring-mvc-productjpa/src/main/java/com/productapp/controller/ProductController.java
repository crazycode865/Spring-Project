package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class ProductController {
	private IProductService iProductService;
	@Autowired
	public ProductController(IProductService iProductService) {
		super();
		this.iProductService = iProductService;
	}
	@RequestMapping("/")
	public String home(ModelMap map) {
		//get all the product by calling
		List<Product> products = iProductService.getAll();
		map.addAttribute("products",products);
		return "home";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Product product) {
		iProductService.addProduct(product);
		return "admin";
	}
	@RequestMapping("/search")
	public String search(@RequestParam("choice")String choice,ModelMap map) {
		List<Product> products=iProductService.getByChoice(choice);
		map.addAttribute("products",products);
		return "home";
	}
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId")int productId) {
	iProductService.deleteProduct(productId);
	return "admin";
	}
	@RequestMapping("/getOneProduct")
	public String getOne(@RequestParam("productId")int productId,ModelMap model) {
		Product product=iProductService.getById(productId);
		model.addAttribute("product",product);
		return "updateProductForm";
	}
	@RequestMapping("/updateProduct")
	public String updateProduct(Product product) {
		iProductService.updateProduct(product);
		return "admin";
	}
}

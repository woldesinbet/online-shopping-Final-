package com.project.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.model.Category;
import com.project.model.Product;
import com.project.service.CategoryService;
import com.project.service.ProductService;
import com.project.warehouseCalls.WareHouseService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private WareHouseService warehouseService;

	@RequestMapping("/deleteProduct")
	public String deleteProductById(@RequestParam("id") Long productId, Model model) {
		productService.delete(productId);
		return "HomePage";
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.GET)
	public String addNewProduct(@ModelAttribute("newProduct") Product newProduct, Model model) {
		List<Category> category = categoryService.viewCategory();
		model.addAttribute("categories", category);
		return "addProduct";
	}

	@Transactional
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct,
			RedirectAttributes redirect) {
		newProduct = productService.addProduct(newProduct);
		this.warehouseService.sendProductCreationRequest(newProduct);
		redirect.addFlashAttribute("products", productService.viewProduct());
		return "redirect:/viewproducts";

	}

	@RequestMapping("/viewproducts")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.viewProduct());
		return "products";
	}

	@RequestMapping("/product{id}")
	public String getProductById(@RequestParam("id") Long productId, Model model) {

		Product product = productService.viewById(productId);

		model.addAttribute("product", product);
		return "product";
	}

}

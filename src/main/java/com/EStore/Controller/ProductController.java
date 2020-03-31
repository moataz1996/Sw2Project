package com.EStore.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EStore.Entities.Product;
import com.EStore.Repositories.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repo;
	
	
	@GetMapping("/AddProduct")
	public String ShowAddedProduct(Model model) {
		model.addAttribute("product",new Product());
		return "AddProduct";
	}
	
	@PostMapping("/AddProduct")
	public String AddProduct(Model model ,@ModelAttribute Product product) {
		repo.save(product);
		model.addAttribute("product", new Product());
		return "AddProduct";
	}
	
	@GetMapping("/ShowAllProducts")
	public String ShowAllProducts(Model model) {
		Iterable<Product> pIterable = repo.findAll();
		List<Product> plist = new ArrayList<Product>();
		for(Product pr : pIterable ) {
			plist.add(pr);
		}
		
		model.addAttribute("prod", plist);
		
		return"ShowAllProducts";
	}
	
	

	
	
	
}
package com.EStore.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EStore.Entities.Brand;
import com.EStore.Repositories.BrandRepository;

@Controller
public class BrandController {
	
	@Autowired
	private BrandRepository repo;
	
	@GetMapping("/AddBrand")
	public String AddBrand(Model model) {
		model.addAttribute("brand" ,new Brand());
		return "AddBrand";
	}

	@PostMapping("/AddBrand")
	public String AddBrand(Model model , @ModelAttribute Brand brand) {
		repo.save(brand);
		model.addAttribute("brand" ,new Brand());
		return "AddBrand";
	}
	
	@GetMapping("/ShowAllBrands")
	public String ShowAllBrands(Model model) {
		Iterable<Brand> pIterable = repo.findAll();
		List<Brand> plist = new ArrayList<Brand>();
		for(Brand br : pIterable ) {
			plist.add(br);
		}
		
		model.addAttribute("blist", plist);
		
		return"ShowAllBrands";
	}
	
}

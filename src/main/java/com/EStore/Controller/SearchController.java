package com.EStore.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EStore.Entities.StoreProduct;
import com.EStore.Repositories.StoreProductRepository;

@Controller
public class SearchController {

	
	@Autowired
	private StoreProductRepository repo;
	
	@GetMapping("/SearchProduct")
	public String addAtt(Model model) {
		model.addAttribute("input",new StoreProduct());
		return "SearchProduct";
	}
	
	@PostMapping("/SearchProduct")
	public String SearchProduct(Model model, @ModelAttribute StoreProduct input) {
		Iterable<StoreProduct> pIterable = repo.findAll();
		List<StoreProduct> plist = new ArrayList<StoreProduct>();
		for(StoreProduct pr : pIterable ) {
			if(input.getName().equals(pr.getName())) {
				pr.setViewCount(pr.getViewCount()+1);
				repo.save(pr);
				plist.add(pr);
				break;
			}
		}
		
		model.addAttribute("prod", plist);
		model.addAttribute("input",new StoreProduct());
		return "SearchProduct";
		
	}
	
}

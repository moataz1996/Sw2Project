package com.EStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EStore.Entities.Brand;
import com.EStore.Entities.Product;
import com.EStore.Entities.StoreProduct;
import com.EStore.Repositories.BrandRepository;
import com.EStore.Repositories.ProductRepository;
import com.EStore.Repositories.StoreProductRepository;

@Controller
public class StoreProductController {
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private BrandRepository brandRepo;
	@Autowired
	private StoreProductRepository storeProductRepo;

	@GetMapping("/AddStoreProduct")
	public String addStorePro(Model model) {
		model.addAttribute("Sproduct",new StoreProduct());
		return "AddStoreProduct";
	}
	
	@PostMapping("/AddStoreProduct")
	public String AdStoreProduct(Model model ,@ModelAttribute StoreProduct Sproduct) {
		Iterable<Product> pIterable = productRepo.findAll();
		Iterable<Brand> bIterable = brandRepo.findAll();
		boolean pFound = false,bFound = false;
		for(Product pr : pIterable ) {
			if(pr.getName().equals(Sproduct.getName())) {
				pFound = true;
				break;
			}
		}
		for(Brand br : bIterable ) {
			if(br.getName().equals(Sproduct.getBrand())) {
				bFound = true;
				break;
			}
		}
		
		if(pFound&&bFound) {
			storeProductRepo.save(Sproduct);
		}
		storeProductRepo.save(Sproduct);
		model.addAttribute("Sproduct", new StoreProduct());
		return "AddStoreProduct";
	}

}

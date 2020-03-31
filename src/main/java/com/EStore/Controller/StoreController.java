package com.EStore.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EStore.Entities.Store;
import com.EStore.Repositories.StoreRepository;

@Controller
public class StoreController {
	
	@Autowired
	private StoreRepository repo;
	
	@GetMapping("/AddStore")
	public String AddNewStore(Model model) {
		model.addAttribute("store" ,new Store());
		return "AddStore";
	}
	
	@PostMapping("/AddStore")
	public String AddStore(Model model ,@ModelAttribute Store store) {	
		repo.save(store);
		model.addAttribute("store",new Store());
		return "AddStore";
				
	}
	
	@GetMapping("/ShowAppendingStores")
	public String ShowAppending(Model model) {
		Iterable<Store> storeIterable = repo.findAll();
		List<Store> storeList = new ArrayList<Store>();
		for (Store s : storeIterable ) {
			if (s.getApproved() == 0) {
				storeList.add(s);
			}
		}
		model.addAttribute("store" ,storeList);
		
		return "ShowAppendingStores";
	}
	
	
	@GetMapping("/ConfirmStore")
	public String ConfirmStore(Model model) {
		model.addAttribute("store" ,new Store());
		return "ConfirmStore";
	}
	
	@PostMapping("/ConfirmStore")
	public String ConfirmStoree(@ModelAttribute Store store) {
		Iterable<Store> storeIterable = repo.findAll();
		for(Store s : storeIterable) {
			if(store.getName().equals(s.getName()) && s.getOwnerUsername().equals(s.getOwnerUsername())) {
				s.setApproved(1);
				repo.save(s);
				return "ConfirmStore";
			}
		}
		return "ConfirmStore";
	}
	

	
	
}
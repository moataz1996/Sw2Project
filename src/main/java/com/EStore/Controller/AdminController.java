package com.EStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EStore.Entities.Admin;
import com.EStore.Repositories.AdminRepository;


@Controller
public class AdminController {

	@Autowired
	private AdminRepository repo;
	
	@GetMapping("/AdminLogin")
	public String ShowAdminLogin(Model model) {
		model.addAttribute("admin", new Admin());
		return "AdminLogin";
	}
	
	@PostMapping("/AdminLogin")
	public String Validate (@ModelAttribute Admin admin) {
		Iterable<Admin> adminsIterable = repo.findAll();
		boolean x =false;
		for(Admin a : adminsIterable) {
			if (admin.getUsername().equals(a.getUsername()) && admin.getPassword().equals(a.getPassword())) {
				x =true;
				break;	
			}
		}
		if (x) {
			return "AdminAfterLogin";
		}else {
			return "AdminLogin";
		}
	}
}
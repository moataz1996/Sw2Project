package com.EStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EStore.Entities.user;
import com.EStore.Repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/UserRegister")
	public String ShowUserRegister(Model model ) {
		model.addAttribute("user", new user());
		return "UserRegister";
		}
	
	@PostMapping("/UserRegister")
	public String Adduser(Model model ,@ModelAttribute user user ) {
		repo.save(user);
		model.addAttribute("user" ,new user());
		return"UserAfterRegister";
	}
	
	@GetMapping("/UserLogin")
	public String ShowUserlogin(Model model) {
		model.addAttribute("user" ,new user());
		return "UserLogin";
	}
	
	@PostMapping("/UserLogin")
	public String Validate(@ModelAttribute user user) {
		Iterable<user> usersIterable = repo.findAll();
		boolean x= false;
		for(user u : usersIterable) {
			if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
				x =true;
				break;
			}
		}
		if (x) {
			return "UserAfterLogin";
			
		}else {
			return"UserLogin";
		}
	}
}

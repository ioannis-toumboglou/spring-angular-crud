//package com.example.springangularcrud.controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.springangularcrud.entity.User;
//import com.example.springangularcrud.service.UserService;
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//	private UserService userService;
//	
//	public UserController(UserService theUserService) {
//		userService = theUserService;
//	}
//	
//	@GetMapping("/list")
//	public String listUsers(Model model) {
//		// Get the user list from the Service
//		List<User> users = userService.findAll();
//		
//		// Add the user list to the model
//		model.addAttribute("users", users);
//		
//		return "users/list-users";
//	}
//	
//	@GetMapping("/showAddForm")
//	public String showAddForm(Model model) {
//		// Create model attribute to bind form data
//		User user = new User();
//		
//		model.addAttribute("user", user);
//		
//		return "users/user-form";
//	}
//	
//	@PostMapping("/save")
//	public String saveUser(@ModelAttribute("user") User user, BindingResult result) {
//		// Save the user using the service
//		userService.save(user);
//		
//		return "redirect:/users/list";
//	}
//	
//	@GetMapping("/showUpdateForm")
//	public String showUpdateForm(@RequestParam("userId") int id, Model model) {
//		// Get user from the service
//		User user = userService.findById(id);
//		// Set user as a model attribute to pre-populate the form
//		model.addAttribute("user", user);
//		// Send to the form		
//		return "users/user-form";
//	}
//	
//	@GetMapping("/delete")
//	public String deleteUser(@RequestParam("userId") int id) {
//		// Delete the code record
//		userService.deleteById(id);
//		
//		return "redirect:/users/list";
//	}
//	
//}
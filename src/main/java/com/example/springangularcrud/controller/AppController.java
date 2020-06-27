package com.example.springangularcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class AppController {

	@GetMapping("/list")
	public String home() {
		
		return "users/user-management";
	}

}
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UserForm;
import com.example.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@GetMapping("")
	public String register(UserForm userForm) {
		return "register";
	}
	
	@PostMapping("/insert")
	public String insert(UserForm userForm) {
		registerService.insertUser(userForm);
		System.out.println(userForm.getUsername() + "登録するユーザーネーム");
		return "login";
	}
	

}

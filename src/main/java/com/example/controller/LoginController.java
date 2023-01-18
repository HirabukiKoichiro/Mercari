package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("")
	public String login(UserForm userForm) {
		return "login";
	}
	
//	@RequestMapping("/loginuser")
//	public String loginUser() {
//		User user = loginService.loginUser(userForm);
//		System.out.println(user.getUsername() + "ログインしたユーザーの名前");
//		session.setAttribute("user", user);
//		return "redirect:/list";
//	}
	
	@GetMapping("/logout")
	public String logout(UserForm userForm) {
		session.invalidate();
		return "login";
	}
}

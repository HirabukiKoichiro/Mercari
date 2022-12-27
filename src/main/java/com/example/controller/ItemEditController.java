package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edit")
public class ItemEditController {
	
	@GetMapping("")
	public String showEdit(Integer id, Model model) {
		model.addAttribute("id", id);
		return "edit";
	}
	
	

}

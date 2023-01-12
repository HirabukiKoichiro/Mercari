package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.form.ItemForm;
import com.example.service.AddItemService;
import com.example.service.CategoryService;

@Controller
@RequestMapping("/add")
public class AddItemController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AddItemService addItemService;
	
	@GetMapping("")
	public String showAdd(ItemForm itemForm, Model model) {
		List<Category> bigCategoryList = categoryService.bigCategoryList();
		model.addAttribute("bigCategoryList", bigCategoryList);	
		return "add";
	}
	
	
	@PostMapping("/item")
	public String addItem(ItemForm itemForm) {
		System.out.println(itemForm.getName());
		addItemService.addItem(itemForm);
		return "redirect:/list";
	}

}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Category;
import com.example.service.CategoryService;

@Controller
@RequestMapping("/add")
public class AddItemController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public String showAdd(Model model) {
		List<Category> bigCategoryList = categoryService.bigCategoryList();
		model.addAttribute("bigCategoryList", bigCategoryList);	
		return "add";
	}
	
	@ResponseBody
	@PostMapping("/mediumcategory")
	public List<Category> mediumCategoryList(Integer id, Model model) {
		List<Category> mediumCategoryList = categoryService.mediumCategoryList(id);
		return mediumCategoryList;
	}
	
	@ResponseBody
	@PostMapping("/smallcategory")
	public List<Category> smallCategoryList(Integer id) {
		List<Category> smallCategoryList = categoryService.smallCategoryList(id);
		return smallCategoryList;
	}

}

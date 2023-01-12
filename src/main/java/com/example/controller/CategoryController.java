package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Category;
import com.example.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
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

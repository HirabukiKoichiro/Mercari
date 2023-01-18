package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.NewItem;
import com.example.form.ItemForm;
import com.example.service.CategoryService;
import com.example.service.EditService;

@Controller
@RequestMapping("/edit")
public class EditController {

	@Autowired
	private EditService editService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public String showEdit(Integer id, Model model, ItemForm itemForm) {
		NewItem item = editService.showEdit(id);
		model.addAttribute("item", item);
		List<Category> bigCategoryList = categoryService.bigCategoryList();
		model.addAttribute("bigCategoryList", bigCategoryList);
//		String category = item.getCategory();
//		String[] categoryArray = category.split("/", 3); 
//		String bigCategory = categoryArray[0];
//		String mediumCategory = categoryArray[1];
//		String smallCategory = categoryArray[2];
//		model.addAttribute("bigCategory", bigCategory);
//		model.addAttribute("mediumCategory", mediumCategory);
//		model.addAttribute("smallCategory ", smallCategory );
		return "edit";
	}
	
	@PostMapping("update")
	public String update(ItemForm itemForm) {
		
		
		
	}

}

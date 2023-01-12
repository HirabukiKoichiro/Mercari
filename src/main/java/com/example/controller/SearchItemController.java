package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.SearchItemForm;
import com.example.service.CategoryService;
import com.example.service.SearchItemService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/search")
public class SearchItemController {
	
	@Autowired
	private SearchItemService searchItemService;
	
	// １ページの最大表示数
	public static final int OUTPUT_NUM = 30;
	
	// itemsテーブルのレコード総数
	private int recordNum;
	
	// 現在のページ
	private int currentPage = 0;
	
	// 全レコードの件数から算出されるページ数（recordNum/outputNum）
	private int maxPage;
	
	private SearchItemForm searchItemForm2 = null;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("")
	public String searchItem(SearchItemForm searchItemForm, Model model) {
		List<Category> bigCategoryList = categoryService.bigCategoryList();
		model.addAttribute("bigCategoryList", bigCategoryList);	
		searchItemForm2 = null;
		searchItemForm2 = searchItemForm;
		List<Item> itemList = searchItemService.searchItemName(OUTPUT_NUM, searchItemForm);
		model.addAttribute("itemList", itemList);
		return "searchItemList";
	}
	
	@GetMapping("/next")
	public String turnPage(Integer num1, Model model, SearchItemForm searchItemForm) {	
		List<Category> bigCategoryList = categoryService.bigCategoryList();
		model.addAttribute("bigCategoryList", bigCategoryList);	
		currentPage += num1;
		//1ページよりも前に戻ろうとすると１ページ目に遷移するようにしているif文
		if(currentPage <= 0) {
			currentPage = 0;
			return "redirect:/search";
		}
		int num2 = OUTPUT_NUM * currentPage;
		List<Item> itemList = searchItemService.searcItem(OUTPUT_NUM, num2, searchItemForm2);
		//最後のページ以降に行こうとすると直前のページに戻るようにするif文
		if(itemList == null) {
			currentPage -= 1;
			num2 = OUTPUT_NUM * currentPage;
			itemList = searchItemService.searcItem(OUTPUT_NUM, num2, searchItemForm2);
		}
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("itemList", itemList);
		return "searchItemList";
	}

}
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.repository.ShowItemListRepository;
import com.example.service.ShowItemService;

@Controller
@RequestMapping("/list")
public class ShowItemListController {
	
	@Autowired
	private ShowItemService showItemService;
	
//	@Autowired
//	private ShowItemListRepository showItemListRepository;
	
	// １ページの最大表示数
	public static final int OUTPUT_NUM = 100;
	
	// itemsテーブルのレコード総数
	private int recordNum;
	
	// 現在のページ
	private int currentPage = 0;
	
	// 全レコードの件数から算出されるページ数（recordNum/outputNum）
	private int maxPage;
	

	@GetMapping("")
	public String showItemList(Model model) {
//		recordNum = showItemListRepository.recordNum();
//		maxPage = recordNum / OUTPUT_NUM;
//		System.out.println("総ページ数=" + maxPage);
		List<Item> itemList = showItemService.showItemList(OUTPUT_NUM);
		model.addAttribute("itemList", itemList);
		return "list";
	}
	
	@GetMapping("/next")
	public String turnPage(Integer num1, Model model) {
		currentPage += num1;
		//1ページよりも前に戻ろうとすると１ページ目に遷移するようにしている
		if(currentPage <= 0) {
			currentPage = 0;
			return "redirect:/list";
		}
		int num2 = OUTPUT_NUM * currentPage;
		List<Item> itemList = showItemService.limitAndOffset(OUTPUT_NUM, num2);
		//最後のページ以降に行こうとすると直前のページに戻るようにする
		if(itemList == null) {
			currentPage -= 1;
			num2 = OUTPUT_NUM * currentPage;
			itemList = showItemService.limitAndOffset(OUTPUT_NUM, num2);
		}
		model.addAttribute("itemList", itemList);
		return "list";
	}
	

}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.form.SearchItemForm;
import com.example.repository.SearchItemRepository;

@Service
@Transactional
public class SearchItemService {
	
	@Autowired
	private  SearchItemRepository  searchItemRepository;
	
	public List<Item> search(int OUTPUT_NUM, SearchItemForm searchItemForm) {
		String sql = "SELECT i.id, i.name, i.condition, c.name_all AS category, i.brand, i.price, i.shipping, i.description FROM items i INNER JOIN category c ON i.category = c.id ";
		sql += "WHERE i.name ILIKE " + "'" + "%" + searchItemForm.getName() + "%" + "'" + " AND i.brand ILIKE " + "'" + "%" + searchItemForm.getBrand() + "%" + "' ";
		
		if(searchItemForm.getSmallCategory() != null) {
			sql += "AND i.category=" + searchItemForm.getSmallCategory() + " ";
		}
		sql += "ORDER BY id LIMIT " + OUTPUT_NUM + ";";
		return searchItemRepository.findByName(sql);
	}
	
	public List<Item> turnPage(int OUTPUT_NUM, int num2, SearchItemForm searchItemForm2) {
		String sql = "SELECT i.id, i.name, i.condition, c.name_all AS category, i.brand, i.price, i.shipping, i.description FROM items i INNER JOIN category c ON i.category = c.id ";
		sql += "WHERE i.name ILIKE " + "'" + "%" + searchItemForm2.getName() + "%" + "'" + " AND i.brand ILIKE " + "'" + "%" + searchItemForm2.getBrand() + "%" + "' ";
		
		if(searchItemForm2.getSmallCategory() != null) {
			sql += "AND i.category=" + searchItemForm2.getSmallCategory() + " ";
		}
		sql += "ORDER BY id LIMIT " + OUTPUT_NUM + "OFFSET " + num2 + ";";
		return searchItemRepository.findByName(sql);
	}

}
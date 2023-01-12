package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.NewItem;
import com.example.form.ItemForm;
import com.example.repository.AddItemRepository;

@Service
@Transactional
public class AddItemService {
	
	@Autowired
	private AddItemRepository addItemRepository;
	
	public void addItem(ItemForm form) {
		NewItem newItem = new NewItem();
		BeanUtils.copyProperties(form, newItem);
		newItem.setCondition(Integer.parseInt(form.getCondition()));
		newItem.setCategory(Integer.parseInt(form.getCategory()));
		newItem.setPrice(Double.parseDouble(form.getPrice()));
		newItem.setShipping(1);
		addItemRepository.insert(newItem);
	}

}

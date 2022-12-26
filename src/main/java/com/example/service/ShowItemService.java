package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ShowItemListRepository;

@Service
@Transactional
public class ShowItemService {
	
	@Autowired
	private ShowItemListRepository showItemListRepository;
	
	public List<Item> showItemList(int num1) {
		return showItemListRepository.LimitFindAll(num1);
	}
	
	public List<Item> limitAndOffset(int num1, int num2) {
		return showItemListRepository.trunPage(num1, num2);
	}

}

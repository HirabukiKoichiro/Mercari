package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ShowItemDetailRepository;

@Service
@Transactional
public class ShowItemDetailService {
	
	@Autowired
	private ShowItemDetailRepository showItemDetailRepository;
	
	public Item showItemDetail(Integer id) {
		return showItemDetailRepository.load(id);
	}
	
	

}

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.NewItem;
import com.example.repository.EditRepository;

@Service
@Transactional
public class EditService {
	
	@Autowired
	private EditRepository editRepository;
	
	public NewItem showEdit(Integer id) {
		return editRepository.load(id);
	}

}

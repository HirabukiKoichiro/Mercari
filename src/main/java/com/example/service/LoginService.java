package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.repository.LoginRepository;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public User loginUser(UserForm userForm) {
		return loginRepository.findByMailAndPassword(userForm.getUserName(), userForm.getPassword());
	}

}

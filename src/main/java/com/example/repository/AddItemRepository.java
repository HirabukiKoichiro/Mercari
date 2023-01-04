package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

@Repository
public class AddItemRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public void insert(Item item) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		String sql = "Insert into items(name, condition, category, brand, price, shipping, description) values(:name, :condition, :category, :brand, :price, :shipping, :description);";
		template.update(sql, param);
	}

}

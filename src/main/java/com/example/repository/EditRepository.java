package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.NewItem;

@Repository
public class EditRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<NewItem> NEWITEM_ROW_MAPPER = new BeanPropertyRowMapper<>(NewItem.class);
	
	public NewItem load(Integer id) {
		String sql = "SELECT id, name, condition, category, brand, price, shipping, description FROM items WHERE id=:id;;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		NewItem item = template.queryForObject(sql, param, NEWITEM_ROW_MAPPER);
		return item;
	}
	
	public void update(Integer id) {
		String sql = "UPDATE items SET name, condition, category, brand, price, shipping, description WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);
	}

}

package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;
import com.example.domain.RecordNum;

@Repository
public class ShowItemListRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Item> ITEM_ROW_MAPPER = new BeanPropertyRowMapper<>(Item.class);
	private static final RowMapper<RecordNum> RECORDNUM_ROW_MAPPER = new BeanPropertyRowMapper<>(RecordNum.class);

	public Integer recordNum() {
		String sql = "SELECT COUNT(id) AS record_num FROM items;";
		List<RecordNum> recordNumlist = template.query(sql, RECORDNUM_ROW_MAPPER);
		return recordNumlist.get(0).getRecordNum();
	}

	public List<Item> LimitFindAll(int num1) {
		String sql = "SELECT i.id, i.name, i.condition, c.name_all AS category, i.brand, i.price, i.shipping, i.description FROM items i INNER JOIN category c ON i.category = c.id ORDER BY id LIMIT :num1;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("num1", num1);
		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
		return itemList;
	}

	public List<Item> trunPage(int num1, int num2) {
		String sql = "SELECT i.id, i.name, i.condition, c.name_all AS category, i.brand, i.price, i.shipping, i.description FROM items i INNER JOIN category c ON i.category = c.id ORDER BY id LIMIT :num1 OFFSET :num2";
		SqlParameterSource param = new MapSqlParameterSource().addValue("num1", num1).addValue("num2", num2);
		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
		return itemList;
	}

}

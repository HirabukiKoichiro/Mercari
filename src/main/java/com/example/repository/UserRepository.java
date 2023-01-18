package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * ユーザーオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<User> USER_ROW_MAPPER = new BeanPropertyRowMapper<>(User.class);
	/**
	 * ユーザーを1件検索します.
	 * 
	 * @param mailAddress メールアドレス
	 * @return ユーザー
	 */
	public User findByMail(String username) {
		String sql = "select id, user_name AS username, password, authority from users where user_name = :username";
		SqlParameterSource param = new MapSqlParameterSource().addValue("username", username);
		User user = template.queryForObject(sql, param, USER_ROW_MAPPER);
		return user;
	}

}

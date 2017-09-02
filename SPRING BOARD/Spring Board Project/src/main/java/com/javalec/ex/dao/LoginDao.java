package com.javalec.ex.dao;

import com.javalec.ex.dto.UserDto;

public interface LoginDao {

	public UserDto find_by_string_id(String bId);
}

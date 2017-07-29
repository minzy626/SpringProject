package com.javalec.ex.dao;

import com.javalec.ex.dto.UserDto;

public interface UserDao {
	public void register(UserDto dto);
	public UserDto find_pass(UserDto dto);
}

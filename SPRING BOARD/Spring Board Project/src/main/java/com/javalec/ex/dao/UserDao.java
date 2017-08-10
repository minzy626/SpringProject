package com.javalec.ex.dao;

import com.javalec.ex.dto.UserDto;

public interface UserDao {
	public void register(UserDto dto);
	public UserDto find_by_id(UserDto dto);
	public UserDto find_by_nick(UserDto dto);
	public UserDto find_by_email(UserDto dto);
}

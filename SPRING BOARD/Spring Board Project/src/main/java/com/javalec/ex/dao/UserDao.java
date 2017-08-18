package com.javalec.ex.dao;

import com.javalec.ex.dto.UserDto;

public interface UserDao {
	public void register(UserDto dto);
	public UserDto find_by_id(UserDto dto);
	public UserDto find_by_string_id(String bId);
	public UserDto find_by_nick(UserDto dto);
	public void update_pass_by_id(UserDto dto);
	public void user_modify_pass(UserDto dto);
	public void user_modify(UserDto dto);
	public void drop_by_id(UserDto dto);
}

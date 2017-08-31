package com.javalec.ex.UserService;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao dao;
	
	@Override
	public void register(UserDto dto) {
		// TODO Auto-generated method stub
		dao.register(dto);
	}

	@Override
	public UserDto find_by_id(UserDto dto) {
		// TODO Auto-generated method stub
		return dao.find_by_id(dto);
	}

	@Override
	public UserDto find_by_string_id(String bId) {
		// TODO Auto-generated method stub
		return dao.find_by_string_id(bId);
	}

	@Override
	public UserDto find_by_nick(UserDto dto) {
		// TODO Auto-generated method stub
		return dao.find_by_nick(dto);
	}

	@Override
	public void update_pass_by_id(UserDto dto) {
		// TODO Auto-generated method stub
		dao.update_pass_by_id(dto);
	}

	@Override
	public void user_modify_pass(UserDto dto) {
		// TODO Auto-generated method stub
		dao.user_modify_pass(dto);
	}

	@Override
	public void user_modify(UserDto dto) {
		// TODO Auto-generated method stub
		dao.user_modify(dto);
	}

	@Override
	public void drop_by_id(UserDto dto) {
		// TODO Auto-generated method stub
		dao.drop_by_id(dto);
	}

}

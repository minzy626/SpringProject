package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dto.UserDto;

public interface BUserService {
	void execute(SqlSession sqlsession,Model model);
	void execute(SqlSession sqlsession,UserDto userDto) throws Exception;
	
}

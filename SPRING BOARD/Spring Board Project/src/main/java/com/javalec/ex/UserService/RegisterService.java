package com.javalec.ex.UserService;


import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class RegisterService {
	
	public void execute(SqlSession sqlsession, UserDto userDto) {
		UserDao userdao = sqlsession.getMapper(UserDao.class);
		userdao.register(userDto);
	}


}

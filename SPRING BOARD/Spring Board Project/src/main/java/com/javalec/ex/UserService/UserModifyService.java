package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class UserModifyService {
	public void execute(SqlSession sqlsession ,UserDto userDto)  {
		
		UserDao dao = sqlsession.getMapper(UserDao.class);
		if(userDto.getbPass().equals("")) {
			dao.user_modify(userDto);
		}
		else {
			dao.user_modify_pass(userDto);
		}
	}
}

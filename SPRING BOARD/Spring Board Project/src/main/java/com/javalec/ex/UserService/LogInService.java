package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.validation.Errors;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class LogInService { 
	
	public UserDto login(SqlSession sqlsession,UserDto userDto) throws Exception
	{
		UserDto resultDto;
		try {
			UserDao userDao = sqlsession.getMapper(UserDao.class);
			resultDto = userDao.find_by_id(userDto);
		
			if(resultDto == null || !resultDto.getbPass().equals(userDto.getbPass()))
			{
				throw new Exception();
			}
			
		}catch(Exception e) {
			throw e;
		}
		return resultDto;
	}
	
}

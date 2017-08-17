package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class WithdrawService {
	public void execute(SqlSession sqlsession ,UserDto userDto) throws Exception {
		
		UserDao dao = sqlsession.getMapper(UserDao.class);
		dao.drop_by_id(userDto);	
	}
}

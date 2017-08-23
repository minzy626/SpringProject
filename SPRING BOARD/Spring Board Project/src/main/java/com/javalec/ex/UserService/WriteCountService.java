package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.BDto;

public class WriteCountService {
	public int execute(SqlSession sqlsession, BDto dto) throws Exception {
		
		UserDao dao = sqlsession.getMapper(UserDao.class);
		int count = dao.count_write(dto);
		
		System.out.println(dto.getbName());
		
		System.out.println(count);
		if(count >= 10)
			throw new Exception();
		
		return count;
	}
}

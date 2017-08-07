package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class NickDuplicationService {
	public UserDto execute(SqlSession sqlsession ,UserDto userDto) throws Exception {
		
		UserDao dao = sqlsession.getMapper(UserDao.class);
		UserDto resultdto = dao.find_by_nick(userDto);
		if(resultdto != null)
			throw new Exception();
		//�г����� �����Ұ�� ����ó��
		return resultdto;	
	}
}

package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class EmailCertifyService {
	public UserDto execute(SqlSession sqlsession ,UserDto userDto) throws Exception {
		
		UserDao dao = sqlsession.getMapper(UserDao.class);
		UserDto resultdto = dao.find_by_id(userDto);
		if(resultdto != null)
			throw new Exception();
		//���̵� �����Ұ�� ����ó��
		return resultdto;	
	}
}
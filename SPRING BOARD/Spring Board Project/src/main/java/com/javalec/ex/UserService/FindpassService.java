package com.javalec.ex.UserService;


import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class FindpassService {
	
	public UserDto execute(SqlSession sqlsession ,UserDto userDto) throws Exception {
			
			UserDao dao = sqlsession.getMapper(UserDao.class);
			UserDto resultdto = dao.find_by_id(userDto);
			if(resultdto == null || !resultdto.getbId().equals(userDto.getbId()))
				throw new Exception();
			//����ڰ� �Է��� ���̵� �������� �ʰų� �������̸����� ����ڰ� �Է��� �̸��ϰ� �ٸ���� ���� ����.
			return resultdto;
		
	}


}

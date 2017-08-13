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
			//사용자가 입력한 아이디가 존재하지 않거나 가져온이메일이 사용자가 입력한 이메일과 다를경우 예외 던짐.
			return resultdto;
		
	}


}

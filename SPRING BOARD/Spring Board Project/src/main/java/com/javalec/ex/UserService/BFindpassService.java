package com.javalec.ex.UserService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class BFindpassService implements BUserService {
	
	@Override
	public void execute(SqlSession sqlsession, Model model) {
	}

	@Override
	public void execute(SqlSession sqlsession, UserDto userDto) throws Exception {
			
			UserDao dao = sqlsession.getMapper(UserDao.class);
			UserDto resultdto = dao.find_pass(userDto);
			if(resultdto == null || !resultdto.getbEmail().equals(userDto.getbEmail()))
				throw new Exception();
			//사용자가 입력한 아이디가 존재하지 않거나 가져온이메일이 사용자가 입력한 이메일과 다를경우 예외 던짐.
		
	}

}

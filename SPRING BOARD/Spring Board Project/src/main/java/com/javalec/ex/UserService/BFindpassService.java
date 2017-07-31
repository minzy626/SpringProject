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
			//����ڰ� �Է��� ���̵� �������� �ʰų� �������̸����� ����ڰ� �Է��� �̸��ϰ� �ٸ���� ���� ����.
		
	}

}

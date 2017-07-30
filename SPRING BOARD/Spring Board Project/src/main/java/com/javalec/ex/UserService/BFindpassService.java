package com.javalec.ex.UserService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class BFindpassService implements BUserService {
	UserDto dto = null;
	UserDto resultdto = null;
	UserDao dao = null;
	@Override
	public void execute(SqlSession sqlsession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bId = request.getParameter("bId");
		String bEmail = request.getParameter("bEmail"); //����ڰ� �Է��� �̸���
		dto = new UserDto();
		dto.setbId(bId);
		dto.setbEmail(bEmail);
		dao = sqlsession.getMapper(UserDao.class);
		resultdto = dao.find_pass(dto); 
		
	}

}

package com.javalec.ex.UserCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class BRegisterCommand implements BUserCommand {
	
	
	
	@Override
	public void execute(SqlSession sqlsession,Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		UserDto userdto = new UserDto();
		userdto.setbId(request.getParameter("bId"));
		userdto.setbEmail(request.getParameter("bEmail"));
		userdto.setbGender(request.getParameter("bGender"));
		userdto.setbGrade(Integer.parseInt(request.getParameter("bGrade")));
		userdto.setbMajor(request.getParameter("bMajor"));
		userdto.setbNick(request.getParameter("bNick"));
		userdto.setbPass(request.getParameter("bPass"));
		userdto.setbRegion(request.getParameter("bRegion"));
		userdto.setbSchool(request.getParameter("bSchool"));
		
		System.out.println(request.getParameter("bId"));
		System.out.println(request.getParameter("bNick"));
		System.out.println(request.getParameter("bPass"));
		System.out.println(request.getParameter("bGender"));
		System.out.println(request.getParameter("bSchool"));
		System.out.println(request.getParameter("bGrade"));
		System.out.println(request.getParameter("bMajor"));
		System.out.println(request.getParameter("bEmail"));
		System.out.println(request.getParameter("bRegion"));
		UserDao userdao = sqlsession.getMapper(UserDao.class);
		userdao.register(userdto);
	}

}

package com.javalec.ex.UserService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class BRegisterService implements BUserService {
	
	
	
	@Override
	public void execute(SqlSession sqlsession,Model model) {
	}
	
	public void execute(SqlSession sqlsession,UserDto userDto) {
		UserDao userdao = sqlsession.getMapper(UserDao.class);
		userdao.register(userDto);
	}

}

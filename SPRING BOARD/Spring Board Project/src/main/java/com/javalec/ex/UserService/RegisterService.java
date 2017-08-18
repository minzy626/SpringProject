package com.javalec.ex.UserService;


import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class RegisterService {
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public void execute(SqlSession sqlsession, UserDto userDto) {
		UserDao userdao = sqlsession.getMapper(UserDao.class);
		String Password = userDto.getbPass();
		String encrypted = passwordEncoder.encode(Password);
		userDto.setbPass(encrypted);
		
		userdao.register(userDto);
	}


}

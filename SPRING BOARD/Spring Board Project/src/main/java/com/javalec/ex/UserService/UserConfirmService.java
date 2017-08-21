package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class UserConfirmService {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public void execute(SqlSession sqlsession, UserDto userDto, String currentPass) throws Exception {
		
		UserDao dao = sqlsession.getMapper(UserDao.class);
		UserDto resultDto = dao.find_by_id(userDto);
		
		String currentPassword = resultDto.getbPass();
				
		if(!passwordEncoder.matches(currentPass, currentPassword))
			throw new Exception();
	}
}

package com.javalec.ex.UserService;


import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dto.UserDto;

public class FindpassService {
	
	BCryptPasswordEncoder passwordEncoder;
	
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public UserDto execute(SqlSession sqlsession ,UserDto userDto) throws Exception {
			
			UserDao dao = sqlsession.getMapper(UserDao.class);
			UserDto resultdto = dao.find_by_id(userDto);
			if(resultdto == null)
				throw new Exception();
			//사용자가 입력한 아이디가 존재하지 않거나 가져온이메일이 사용자가 입력한 이메일과 다를경우 예외 던짐.
			
			//예외가 발생하지 않았을 경우 랜덤값을 암호화해서 데이터베이스에 비밀번호 업데이트해줌.
			double randomvalue = Math.random();
			int random = (int)(randomvalue * 100000) +1;
			String password = passwordEncoder.encode(String.valueOf(random));
			
			resultdto.setbPass(password); //암호화된 비밀번호를 디비에 저장해줌.
			dao.update_pass_by_id(resultdto); //암호화된 비밀번호를 디비에 저장해줌.
			
			resultdto.setbPass(String.valueOf(random)); //암호화되지 않은 비밀번호를 사용자에게 알려줘야 함.
			
			return resultdto;
		
	}


}

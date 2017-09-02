package com.javalec.ex.UserService;


import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javalec.ex.dao.LoginDao;
import com.javalec.ex.dto.CustomUserDetails;
import com.javalec.ex.dto.UserDto;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	SqlSession sqlsession;
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginDao dao = sqlsession.getMapper(LoginDao.class);
		UserDto dto = dao.find_by_string_id(username);

		if(dto == null)
			throw new UsernameNotFoundException(username);
		
		CustomUserDetails user = new CustomUserDetails();
		user.setbGender(dto.getbGender());
		user.setbGrade(dto.getbGrade());
		user.setbId(dto.getbId());
		user.setbMajor(dto.getbMajor());
		user.setbNick(dto.getbNick());
		user.setbPass(dto.getbPass());
		user.setbRegion(dto.getbRegion());
		user.setbSchool(dto.getbSchool());
		user.setbImage(dto.getbImage());
		user.setEnabled(true);
		//user의 권한 정보는 항상 ROLR_USER를 반환하도록 되어있어서 여기서는 따로 설정해주지 않아도 됨.
		//권한정보도 마찬가지로 디비에서 읽어오게끔 할 수도 있으나 이 프로젝트에서는 그럴 필요가 없어서 무조건 ROLE_USER만 사용하게끔 했음.
		
		
		return user;
	}

	
}



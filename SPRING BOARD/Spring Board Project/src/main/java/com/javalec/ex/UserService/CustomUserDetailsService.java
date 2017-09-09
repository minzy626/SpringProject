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
		//user�� ���� ������ �׻� ROLR_USER�� ��ȯ�ϵ��� �Ǿ��־ ���⼭�� ���� ���������� �ʾƵ� ��.
		//���������� ���������� ��񿡼� �о���Բ� �� ���� ������ �� ������Ʈ������ �׷� �ʿ䰡 ��� ������ ROLE_USER�� ����ϰԲ� ����.
		
		
		return user;
	}

	
}



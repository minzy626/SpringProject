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
			//����ڰ� �Է��� ���̵� �������� �ʰų� �������̸����� ����ڰ� �Է��� �̸��ϰ� �ٸ���� ���� ����.
			
			//���ܰ� �߻����� �ʾ��� ��� �������� ��ȣȭ�ؼ� �����ͺ��̽��� ��й�ȣ ������Ʈ����.
			double randomvalue = Math.random();
			int random = (int)(randomvalue * 100000) +1;
			String password = passwordEncoder.encode(String.valueOf(random));
			
			resultdto.setbPass(password); //��ȣȭ�� ��й�ȣ�� ��� ��������.
			dao.update_pass_by_id(resultdto); //��ȣȭ�� ��й�ȣ�� ��� ��������.
			
			resultdto.setbPass(String.valueOf(random)); //��ȣȭ���� ���� ��й�ȣ�� ����ڿ��� �˷���� ��.
			
			return resultdto;
		
	}


}

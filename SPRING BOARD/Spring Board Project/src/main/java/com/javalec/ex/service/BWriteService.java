package com.javalec.ex.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.IDao;
import com.javalec.ex.dto.BDto;


public class BWriteService implements BService {

	@Override
	public void execute(SqlSession sqlsession, Model model) {
	}
	
	//�����ε�
	public void execute(SqlSession sqlsession, BDto bDto) {
		IDao dao = sqlsession.getMapper(IDao.class);
		dao.write(bDto);
	}

}

package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.IDao;
import com.javalec.ex.dto.BDto;


public class BWriteCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlsession, Model model) {
	}
	
	//오버로딩
	public void execute(SqlSession sqlsession, BDto bDto) {
		IDao dao = sqlsession.getMapper(IDao.class);
		dao.write(bDto);
	}

}

package com.javalec.ex.service;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


import com.javalec.ex.dao.IDao;
import com.javalec.ex.dto.BDto;


public class BListService implements BService {
	
	@Override
	public void execute(SqlSession sqlsession,Model model) {
		IDao dao = sqlsession.getMapper(IDao.class);
		model.addAttribute("list",dao.list());
	}


}

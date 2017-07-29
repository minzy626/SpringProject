package com.javalec.ex.command;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


import com.javalec.ex.dao.IDao;
import com.javalec.ex.dto.BDto;


public class BListCommand implements BCommand {
	
	@Override
	public void execute(SqlSession sqlsession,Model model) {
		IDao dao = sqlsession.getMapper(IDao.class);
		model.addAttribute("list",dao.list());
	}


}

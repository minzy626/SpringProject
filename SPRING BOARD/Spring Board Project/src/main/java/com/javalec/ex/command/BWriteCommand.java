package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.IDao;


public class BWriteCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlsession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		IDao dao = sqlsession.getMapper(IDao.class);
		dao.write(bName,bTitle,bContent,0,0,0);
		
	}

}

package com.javalec.ex.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.IDao;
import com.javalec.ex.dto.BDto;

public class BDeleteService implements BService {

	@Override
	public void execute(SqlSession sqlsession,Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bId = request.getParameter("bId");
		
		IDao dao = sqlsession.getMapper(IDao.class);
		dao.delete(bId);

	}



}

package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.IDao;
import com.javalec.ex.dto.BDto;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlsession,Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BDto dto = new BDto();
		dto.setbId(Integer.parseInt(request.getParameter("bId")));
		dto.setbName(request.getParameter("bName"));
		dto.setbTitle(request.getParameter("bTitle"));
		dto.setbContent(request.getParameter("bContent"));
		IDao dao = sqlsession.getMapper(IDao.class);
		dao.modify(dto);
		

	}

}

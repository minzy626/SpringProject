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
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		System.out.println(bContent);
		BDto dto = new BDto();
		dto.setbContent(bContent);
		dto.setbHit(0);
		dto.setbName(bName);
		dto.setbTitle(bTitle);
		IDao dao = sqlsession.getMapper(IDao.class);
		System.out.println(dto.getbContent());
		System.out.println(dto.getbHit());
		System.out.println(dto.getbName());
		System.out.println(dto.getbTitle());
		dao.write(dto);
		
	}

}

package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dao.IDao;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlsession, Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		IDao dao = sqlsession.getMapper(IDao.class);
		dao.replyShape(bGroup, bStep);
		dao.reply(bName, bTitle, bContent, Integer.parseInt(bGroup), Integer.parseInt(bStep)+1, Integer.parseInt(bIndent)+1);
		
	}

}

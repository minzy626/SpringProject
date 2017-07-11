package com.javalec.ex_16_1.spring_pjt_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex_16_1.spring_pjt_board.dao.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bName = request.getParameter("bName");
		
		
		BDao dao = new BDao();
		dao.modify(bId,bName,bTitle,bContent); //수정만 하고 끝나면 됨.
	}

}

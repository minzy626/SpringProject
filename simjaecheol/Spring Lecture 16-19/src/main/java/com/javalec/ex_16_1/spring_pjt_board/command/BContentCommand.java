package com.javalec.ex_16_1.spring_pjt_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex_16_1.spring_pjt_board.dao.BDao;
import com.javalec.ex_16_1.spring_pjt_board.dto.BDto;

public class BContentCommand implements BCommand { //게시판에서 글 내용을 보는 서비스 커맨드객 체

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view",dto);

	}

}

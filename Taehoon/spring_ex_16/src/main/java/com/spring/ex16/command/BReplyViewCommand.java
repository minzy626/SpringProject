package com.spring.ex16.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex16.dao.BDao;
import com.spring.ex16.dto.BDto;

public class BReplyViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		dao.reply_view(bId);
		BDto dto = dao.reply_view(bId);
		
		model.addAttribute("reply_view", dto);
		
	}

}

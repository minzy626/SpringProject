package com.javalec.ex_16_1.spring_pjt_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex_16_1.spring_pjt_board.dao.BDao;

public class BDeleteCommand implements BCommand { //delete ���� ��ü������ ��Ʈ�ѷ��� dao�� ��ȣ�ۿ�

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		BDao dao = new BDao();
		dao.delete(bId);
		
	}

}

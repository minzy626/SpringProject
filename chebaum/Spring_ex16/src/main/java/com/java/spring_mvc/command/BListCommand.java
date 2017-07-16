package com.java.spring_mvc.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.java.spring_mvc.dao.BDao;
import com.java.spring_mvc.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) { // 주목적: jsp페이지에 dto객체를 넘겨서 jsp페이지에 예쁘게 표시할 수 있도록!
		// TODO Auto-generated method stub
		BDao dao=new BDao();
		ArrayList<BDto> dtos=dao.list(); // db접근해서 data가져온다.
		
		model.addAttribute("list", dtos);
	}

}

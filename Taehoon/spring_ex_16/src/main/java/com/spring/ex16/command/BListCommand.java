package com.spring.ex16.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex16.dao.BDao;
import com.spring.ex16.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
	}

}

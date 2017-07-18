package com.javalec.spring_project.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_project.dao.BDao;
import com.javalec.spring_project.dto.BDto;

public class BListCommand implements BCommand {
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BDto>dtos =  dao.list();//dao 리스트를 dto에 담는다
		
		model.addAttribute("list", dtos);//모델에 담는다-뷰페이지에서 사용하면 됨
		
	}

}

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
		ArrayList<BDto>dtos =  dao.list();//dao ����Ʈ�� dto�� ��´�
		
		model.addAttribute("list", dtos);//�𵨿� ��´�-������������ ����ϸ� ��
		
	}

}

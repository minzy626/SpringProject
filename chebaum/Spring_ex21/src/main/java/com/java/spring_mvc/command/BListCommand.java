package com.java.spring_mvc.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.java.spring_mvc.dao.BDao;
import com.java.spring_mvc.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) { // �ָ���: jsp�������� dto��ü�� �Ѱܼ� jsp�������� ���ڰ� ǥ���� �� �ֵ���!
		// TODO Auto-generated method stub
		BDao dao=new BDao();
		ArrayList<BDto> dtos=dao.list(); // db�����ؼ� data�����´�.
		
		model.addAttribute("list", dtos);
	}

}

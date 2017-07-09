package com.javalec.spring_pjt_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.BDao;
import com.javalec.spring_pjt_board.dto.BDto;

//������ ���̽��� �ִ� �����͸� �� �����ͼ� ȭ�鿡 �ѷ��ֱ� ���ؼ� ,jsp�������� dto ��ü�� �Ѱ��ְ� ���� jsp�������� ���ڰ� �ѷ��ֱ� ���ؼ� �����ϴ� Ŀ�ǵ� ��ü
//�� �Խ��� ���
public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
	
		model.addAttribute("list",dtos); //�信�� list�� ������ ��.
	}

}

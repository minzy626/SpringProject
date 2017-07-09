package com.javalec.spring_pjt_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.BDao;
import com.javalec.spring_pjt_board.dto.BDto;

//데이터 베이스에 있는 데이터를 다 가져와서 화면에 뿌려주기 위해서 ,jsp페이지에 dto 객체를 넘겨주고 나서 jsp페이지에 예쁘게 뿌려주기 위해서 존재하는 커맨드 객체
//글 게시판 목록
public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
	
		model.addAttribute("list",dtos); //뷰에서 list로 받으면 됨.
	}

}

package com.javalec.ex.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.BoardService.CommentService;
import com.javalec.ex.dto.CDto;
import com.javalec.ex.dto.CustomUserDetails;



@Controller
public class CommentController {
	
	@Inject
	CommentService service;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@RequestMapping(value="/cWrite")
	public String cwrite(CDto cdto, RedirectAttributes rttr, Principal principal)
	{
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();
		// �ڽ��� �ۿ� ����� �ް��ִ� ���, �ش����� ����ó�� �� ������ db�� �����Ѵ�.
		// cIsSeen�� default���� false�̹Ƿ� elseó���� �����൵ ����.
		if(user.getbNick()==cdto.getcNick())
			cdto.setcIsSeen(true);
		service.cWrite(cdto);
		return "redirect:/content_view?bPage=1&bPerPageNum=10&bSearchType=&bSearchMType&bSearchRType&bKeyword=&bId="+cdto.getcBoardNum();
	}
	
	@RequestMapping(value="/cUpdate")
	public String cUpdate(@RequestParam("cId") int cId, @RequestParam("cContent") String cContent, @RequestParam("cBoardNum") int cBoardNum, RedirectAttributes rttr)
	{
		logger.info("cUpdate is called......");
		
		logger.info(" cId : " + cId);
		logger.info(" cContent : " + cContent);
		logger.info(" cBoardNum : " + cBoardNum);
		CDto cdto=new CDto();
		cdto.setcId(cId);
		cdto.setcContent(cContent);
		cdto.setcBoardNum(cBoardNum);
		service.cUpdate(cdto);
		return "redirect:/content_view?bPage=1&bPerPageNum=10&bSearchType=&bSearchMType&bSearchRType&bKeyword=&bId="+cBoardNum;
	}
	
	@RequestMapping(value="/cDelete")
	public String cDelete(@RequestParam("cId") Integer cId, @RequestParam("cBoardNum") Integer cBoardNum, RedirectAttributes rttr)
	{
		service.cDelete(cId);
		return "redirect:/content_view?bPage=1&bPerPageNum=10&bSearchType=&bSearchMType&bSearchRType&bKeyword=&bId="+cBoardNum;
	}
}
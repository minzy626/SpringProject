package com.javalec.ex.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.BoardService.CommentService;
import com.javalec.ex.dto.CDto;



@Controller
public class CommentController {
	
	@Inject
	CommentService service;
	
	@RequestMapping(value="/cWrite")
	public String cwrite(CDto cdto, RedirectAttributes rttr)
	{
		service.cWrite(cdto);
		return "redirect:/content_view?bPage=1&bPerPageNum=10&bSearchType=&bSearchMType&bSearchRType&bKeyword=&bId="+cdto.getcBoardNum();
	}
	
	@RequestMapping(value="/cUpdate")
	public String cUpdate(@RequestParam("cId") int cId, @RequestParam("cContent") String cContent, @RequestParam("cBoardNum") int cBoardNum, RedirectAttributes rttr)
	{
		CDto cdto;
		
		//cdto.setcContent(cContent);
		//cdto.setcId(cId);
		//service.cUpdate(cdto);
		return "redirect:/content_view?bPage=1&bPerPageNum=10&bSearchType=&bSearchMType&bSearchRType&bKeyword=&bId="+cBoardNum;
	}
	
	@RequestMapping(value="/cDelete")
	public String cDelete(@RequestParam("cId") Integer cId, @RequestParam("cBoardNum") Integer cBoardNum, RedirectAttributes rttr)
	{
		service.cDelete(cId);
		return "redirect:/content_view?bPage=1&bPerPageNum=10&bSearchType=&bSearchMType&bSearchRType&bKeyword=&bId="+cBoardNum;
	}
}
package com.javalec.ex.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javalec.ex.service.BService;


@Controller

public class BController {
	BService command=null;
	
	@Autowired
	SqlSession sqlsession;
	
	public BController() {
		
	}

//	@RequestMapping(value="/write", method = RequestMethod.POST) 
//	public String write(BDto bDto,Model model)  
//	{
//		BWriteService command= new BWriteService();
//		command.execute(sqlsession,bDto);
//		return "redirect:/board/list"; 
//	}
//	
//	
//	
//	@RequestMapping("/write_view")
//	public String write_view(Model model) {
//
//		return "write_view";} 
//	
//	
//	@RequestMapping("/content_view") 
//	public String content_view(HttpServletRequest request,Model model) { 
//		model.addAttribute("request",request);
//		command = new BContentService();
//		command.execute(sqlsession,model);  
//		return "content_view"; 
//
//	}
//
//	
//	@RequestMapping(value="/modify")
//	public String modify(BDto bDto,Model model) { 
//		BModifyService command = new BModifyService();
//		command.execute(sqlsession,bDto);  
//
//		return "redirect:/board/list"; 
//	} 
//	
//	
//	
//	
//	@RequestMapping("/delete") //�� �����ϱ�
//	public String delete(HttpServletRequest request,Model model) { 
//		model.addAttribute("request",request);
//		command = new BDeleteService(); 
//		command.execute(sqlsession,model);   
//		return "redirect:/board/list"; 
//	}
	
	
	
	
	
	
	
}

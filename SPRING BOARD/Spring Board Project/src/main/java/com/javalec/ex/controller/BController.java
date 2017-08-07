package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.service.BContentService;
import com.javalec.ex.service.BDeleteService;
import com.javalec.ex.service.BModifyService;
import com.javalec.ex.service.BService;
import com.javalec.ex.service.BWriteService;


@Controller
public class BController {
	BService command=null;
	
	@Autowired
	SqlSession sqlsession;
	
	public BController() {
		
	}
	
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(BDto bDto,Model model)
	{
		BWriteService command= new BWriteService();
		command.execute(sqlsession,bDto);
		return "redirect:list";
	}
	
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		return "write_view";} 
	
	
	
	@RequestMapping("/content_view") 
	public String content_view(HttpServletRequest request,Model model) { 
		model.addAttribute("request",request);
		command = new BContentService();
		command.execute(sqlsession,model);  
		return "content_view";
	} 
	
	
	@RequestMapping(value="/modify") //�� �����ϱ�
	public String modify(BDto bDto,Model model) { 
		BModifyService command = new BModifyService();
		command.execute(sqlsession,bDto);  
		return "redirect:list";
	} 

	
	@RequestMapping("/delete") //�� �����ϱ�
	public String delete(HttpServletRequest request,Model model) { 
		model.addAttribute("request",request);
		command = new BDeleteService(); 
		command.execute(sqlsession,model);   
		return "redirect:list"; 
	}
	
	
	
	
	
	
	
}

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
@RequestMapping("/board")
public class BController {
	BService command=null;
	
	@Autowired
	SqlSession sqlsession;
	
	public BController() {
		
	}

	
	/*@RequestMapping("/list") //占쌉쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙
	public String list(Model model) // Controller->Command->DAO占쏙옙 占쏙옙占식쇽옙 占쏙옙占쏙옙占싶몌옙 占쌕쏙옙 占쏙옙占쏙옙占쏙옙占실뤄옙 model占쏙옙체占쏙옙 占쏙옙占쌘뤄옙 占쌨아억옙占쏙옙. 
	{
		command = new BListService();
		command.execute(sqlsession,model); //占쏙옙트占싼뤄옙占쏙옙占쏙옙 Command占쏙옙 占쏙옙占쏘를 占싼깍옙 (占쏜델울옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙틴占� 占싹므뤄옙 占쏙옙占쌘뤄옙 占쏙옙占쏙옙)
		return "list"; //list.jsp占쏙옙 占쏙옙占쏙옙占싹깍옙 占쏙옙占쏙옙.
	}*/

	
	
	@RequestMapping(value="/write", method = RequestMethod.POST) 
	public String write(BDto bDto,Model model)  
	{
		BWriteService command= new BWriteService();
		command.execute(sqlsession,bDto);
		return "redirect:/board/list"; 
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

	
	@RequestMapping(value="/modify")
	public String modify(BDto bDto,Model model) { 
		BModifyService command = new BModifyService();
		command.execute(sqlsession,bDto);  

		return "redirect:/board/list"; 
	} 
	
	
	
	
	@RequestMapping("/delete") //�� �����ϱ�
	public String delete(HttpServletRequest request,Model model) { 
		model.addAttribute("request",request);
		command = new BDeleteService(); 
		command.execute(sqlsession,model);   
		return "redirect:/board/list"; 
	}
	
	
	
	
	
	
	
}

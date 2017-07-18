package com.javalec.spring_project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_project.command.BCommand;
import com.javalec.spring_project.command.BContentCommand;
import com.javalec.spring_project.command.BDeleteCommand;
import com.javalec.spring_project.command.BListCommand;
import com.javalec.spring_project.command.BModifyCommand;
import com.javalec.spring_project.command.BReplyCommand;
import com.javalec.spring_project.command.BReplyViewCommand;
import com.javalec.spring_project.command.BWriteCommand;

@Controller
public class BController {

	BCommand command;//인터페이스 선언 
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");//로그 찍기
		
		command = new BListCommand();
		command.execute(model);//받아온 모델 실행
		
		return "list";//리스트페이지 반환
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")//글작성페이지
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		
		return "redirect:list";//작성후 리스트페이지로 리다이렉트
	}
	
	@RequestMapping("content_view")//작성글글 확인 페이지
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	//글 수정
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	//답변 보기
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	//답변 달기
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";//답변 달고 리스트로 리다이렉트
	}
	//삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";//삭제 후 리스트로 리다이렉트
	}
	
}

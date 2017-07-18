package com.java.spring_mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring_mvc.command.BCommand;
import com.java.spring_mvc.command.BContentCommand;
import com.java.spring_mvc.command.BDeleteCommand;
import com.java.spring_mvc.command.BListCommand;
import com.java.spring_mvc.command.BModifyCommand;
import com.java.spring_mvc.command.BReplyCommand;
import com.java.spring_mvc.command.BReplyViewCommand;
import com.java.spring_mvc.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		command=new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view") // 그저 작성하는 화면으로 옮겨주면 그만.
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command=new BWriteCommand();
		command.execute(model);
		
		return "redirect:list"; // 작성완료하면 리스트 페이지로!
	}
	
	@RequestMapping("/content_view") // 글 클릭하면 내용 보여주기.
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command=new BContentCommand();
		
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify") // 글 수정하기 눌렀을때
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command=new BModifyCommand();
		command.execute(model);
		
		return "redirect:list"; // 수정했으니 리스트로.
	}
	
	@RequestMapping("/reply_view") // 답변 글 보기.
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command=new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply") // 답변 글 달기.
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command=new BReplyCommand();
		command.execute(model);
		
		return "redirect:list"; // 답변 작성했으니 리스트로
	}
	
	@RequestMapping("/delete") // 삭제하기. 삭제후 리스트로 복귀
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command=new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}

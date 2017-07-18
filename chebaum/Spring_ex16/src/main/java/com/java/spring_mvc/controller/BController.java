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
	
	@RequestMapping("/write_view") // ���� �ۼ��ϴ� ȭ������ �Ű��ָ� �׸�.
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
		
		return "redirect:list"; // �ۼ��Ϸ��ϸ� ����Ʈ ��������!
	}
	
	@RequestMapping("/content_view") // �� Ŭ���ϸ� ���� �����ֱ�.
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command=new BContentCommand();
		
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify") // �� �����ϱ� ��������
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command=new BModifyCommand();
		command.execute(model);
		
		return "redirect:list"; // ���������� ����Ʈ��.
	}
	
	@RequestMapping("/reply_view") // �亯 �� ����.
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command=new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply") // �亯 �� �ޱ�.
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command=new BReplyCommand();
		command.execute(model);
		
		return "redirect:list"; // �亯 �ۼ������� ����Ʈ��
	}
	
	@RequestMapping("/delete") // �����ϱ�. ������ ����Ʈ�� ����
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command=new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}

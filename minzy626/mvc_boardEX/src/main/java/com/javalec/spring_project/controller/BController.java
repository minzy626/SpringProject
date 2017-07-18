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

	BCommand command;//�������̽� ���� 
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");//�α� ���
		
		command = new BListCommand();
		command.execute(model);//�޾ƿ� �� ����
		
		return "list";//����Ʈ������ ��ȯ
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")//���ۼ�������
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		
		return "redirect:list";//�ۼ��� ����Ʈ�������� �����̷�Ʈ
	}
	
	@RequestMapping("content_view")//�ۼ��۱� Ȯ�� ������
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	//�� ����
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	//�亯 ����
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	//�亯 �ޱ�
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";//�亯 �ް� ����Ʈ�� �����̷�Ʈ
	}
	//����
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";//���� �� ����Ʈ�� �����̷�Ʈ
	}
	
}

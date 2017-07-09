package com.javalec.spring_pjt_board.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_board.command.BCommand;
import com.javalec.spring_pjt_board.command.BContentCommand;
import com.javalec.spring_pjt_board.command.BDeleteCommand;
import com.javalec.spring_pjt_board.command.BListCommand;
import com.javalec.spring_pjt_board.command.BModifyCommand;
import com.javalec.spring_pjt_board.command.BReplyCommand;
import com.javalec.spring_pjt_board.command.BReplyViewCommand;
import com.javalec.spring_pjt_board.command.BWriteCommand;

@Controller
public class BController { //��ü���� �۾��� �����Ѵ�.

	//��û -> dispatcer -> controller -> view or command(������ ���̽� ���� ���� ó���� dao dto) ��û �ϰ� ������ ó���� �ѱ�� �������� httpservletrequest�� model ��ü�� ���ȴ�.
	BCommand command;
	
	@RequestMapping("/list")

	public String list(Model model) {
		System.out.println("list()");
		
		command = new BListCommand();
		command.execute(model);
		return "list"; //list.jsp������ ���� ���������� �ϼ���.
	}
	
	
	
	@RequestMapping("/write_view") //�� �ۼ� ȭ��
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view"; 
	}
	
	@RequestMapping("/write") //�� �ۼ� ȭ�鿡�� ���� �ۼ����� ������ ������ ������ dao��ü�� �����ϰ� ����� ���� ��..
	public String write(HttpServletRequest request,Model model) //�� �ۼ��� ���� ������ ������������ httpservletrequest �ʿ�
	{ 
		System.out.println("write()");
		
		model.addAttribute("request",request); //�ۼ��� �� ������ �׳� ������ ���̽��� ������ϸ� �ǹǷ� ��Ʈ�ѿ����� ������ ����.
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list"; //���� �� �ۼ��ϰ� ����  �ٽ� list�������� �����
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) //
	{
		System.out.println("content_view()");
		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model); //������ �������� �������� �����ϰ� �̷����� command���� ����.
		
		return "content_view";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/modify") //���� �����ϴ� ���̹Ƿ� ����� �����������.
	public String modify(HttpServletRequest request,Model model) 
	{
		System.out.println("modify()");
		
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view") //����� ���� ��
	public String reply_view(HttpServletRequest request,Model model)
	{
		System.out.println("reply_view()");
		
		model.addAttribute("request",request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request,Model model) // �亯�� �ٴ� ���
	{
		System.out.println("reply()");
		
		model.addAttribute("request",request);
		command = new BReplyCommand();
		command.execute(model);
		
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model)
	{
		System.out.println("delete()");
		
		model.addAttribute("request",request);
		command = new BDeleteCommand();
		command.execute(model);
		
		
		return "redirect:list";
	}
	
	
}

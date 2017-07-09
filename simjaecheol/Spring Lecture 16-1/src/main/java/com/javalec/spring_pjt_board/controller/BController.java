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
public class BController { //전체적인 작업을 지휘한다.

	//요청 -> dispatcer -> controller -> view or command(데이터 베이스 관련 일을 처리함 dao dto) 요청 하고 데이터 처리를 넘기는 과정에서 httpservletrequest와 model 객체가 사용된다.
	BCommand command;
	
	@RequestMapping("/list")

	public String list(Model model) {
		System.out.println("list()");
		
		command = new BListCommand();
		command.execute(model);
		return "list"; //list.jsp페이지 에서 최종적으로 완성됨.
	}
	
	
	
	@RequestMapping("/write_view") //글 작성 화면
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view"; 
	}
	
	@RequestMapping("/write") //글 작성 화면에서 글을 작성한후 제출을 누르면 실제로 dao객체에 접근하고 등등의 일을 함..
	public String write(HttpServletRequest request,Model model) //글 작성에 대한 정보를 가져오기위해 httpservletrequest 필요
	{ 
		System.out.println("write()");
		
		model.addAttribute("request",request); //작성한 글 내용을 그냥 데이터 베이스에 입출력하면 되므로 컨트롤에서는 할일이 없음.
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list"; //글을 다 작성하고 나서  다시 list페이지로 가면됨
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) //
	{
		System.out.println("content_view()");
		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model); //실제로 컨텐츠를 가져오고 실행하고 이런것은 command에서 해줌.
		
		return "content_view";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/modify") //글을 수정하는 것이므로 방식을 지정해줘야함.
	public String modify(HttpServletRequest request,Model model) 
	{
		System.out.println("modify()");
		
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view") //답글을 보는 뷰
	public String reply_view(HttpServletRequest request,Model model)
	{
		System.out.println("reply_view()");
		
		model.addAttribute("request",request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request,Model model) // 답변을 다는 기능
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

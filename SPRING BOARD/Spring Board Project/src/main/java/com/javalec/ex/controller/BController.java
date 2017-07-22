package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.command.BCommand;
import com.javalec.ex.command.BContentCommand;
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.BListCommand;
import com.javalec.ex.command.BModifyCommand;
import com.javalec.ex.command.BReplyCommand;
import com.javalec.ex.command.BReplyViewCommand;
import com.javalec.ex.command.BWriteCommand;

@Controller
public class BController {
	BCommand command=null;

	public BController() {
		
	}
	
	
	@RequestMapping("/list") //�Խ��� �� ��� ��������
	public String list(Model model) // Controller->Command->DAO�� ���ļ� �����͸� �ٽ� �������Ƿ� model��ü�� ���ڷ� �޾ƾ���. 
	{
		command = new BListCommand();
		command.execute(model); //��Ʈ�ѷ����� Command�� ��� �ѱ� (�𵨿� ������ ��� ��ƾ� �ϹǷ� ���ڷ� ����)
		return "list"; //list.jsp�� �����ϱ� ����.
	}
	
	
	
	@RequestMapping("/write") //�� �ۼ�
	public String write(HttpServletRequest request,Model model) //�� �ۼ��� �ۼ���,����� ������ �����;ߵǴϱ� request�� ���ڷι޾ƾ���.  
	{
		model.addAttribute("request",request); //WriteĿ�ǵ� ��ü�� �� �ۼ������� �ѰžߵǹǷ� �𵨿� ������Ʈ�� ��´�.
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list"; //�� �ۼ� �ϰ����� �ٽ� �� ����� ������ �ϹǷ� list.jspȣ��ǰԲ�.
	}
	
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		return "write_view";} // �۾��� �޴� �������� �ٷ� ȭ�鸸 �����ָ� �Ǵϱ� �ٷ� �������ָ� ��
	
	
	
	@RequestMapping("/content_view") //�� ���� ����
	public String content_view(HttpServletRequest request,Model model) { //list.jsp���� �� ��� �۸��� ID���� �ش��ϴ� ���� ��� ����� �ϹǷ� request �ʿ�
		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model);  
		return "content_view"; //�信 �ѷ�����,model���� ���� �A���� dto�� �������. jsp���Ͽ��� dto�� ������ �����.
	} 
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST) //�� �����ϱ�
	public String modify(HttpServletRequest request,Model model) { 
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);  
		return "redirect:list"; //�� �����ѵ� �ٽ� �� ��� ���
	} 
	//GET��İ� POST����� ����  https://blog.outsider.ne.kr/312 
	
	@RequestMapping("/reply_view") //�� �亯�ޱ�
	public String reply_view(HttpServletRequest request,Model model) { //request���� ���� id�� ���������. 
		model.addAttribute("request",request);
		command = new BReplyViewCommand(); 
		command.execute(model); //DB�����ؼ� �� ID�� �ش��ϴ� �ۼ���,������� �����ͼ� �信 �Ѹ��� ��.  
		return "reply_view"; 
	} 
	
	@RequestMapping("/reply") //�� �亯�ޱ�
	public String reply(HttpServletRequest request,Model model) { //request���� ���� id�� ���������. 
		model.addAttribute("request",request);
		command = new BReplyCommand(); 
		command.execute(model);   
		return "redirect:list"; 
	} 
	
	@RequestMapping("/delete") //�� �����ϱ�
	public String delete(HttpServletRequest request,Model model) { //request���� ���� id�� ���������. 
		model.addAttribute("request",request);
		command = new BDeleteCommand(); 
		command.execute(model);   
		return "redirect:list"; 
	}
	
	
	
	
	
	
	
}

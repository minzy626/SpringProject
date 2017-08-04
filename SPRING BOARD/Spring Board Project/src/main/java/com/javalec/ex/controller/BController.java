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
	
	
	/*@RequestMapping("/list") //�Խ��� �� ��� ��������
	public String list(Model model) // Controller->Command->DAO�� ���ļ� �����͸� �ٽ� �������Ƿ� model��ü�� ���ڷ� �޾ƾ���. 
	{
		command = new BListService();
		command.execute(sqlsession,model); //��Ʈ�ѷ����� Command�� ��� �ѱ� (�𵨿� ������ ��� ��ƾ� �ϹǷ� ���ڷ� ����)
		return "list"; //list.jsp�� �����ϱ� ����.
	}*/

	
	
	@RequestMapping(value="/write", method = RequestMethod.POST) //�� �ۼ�
	public String write(BDto bDto,Model model) //�� �ۼ��� �ۼ���,����� ������ �����;ߵǴϱ� request�� ���ڷι޾ƾ���.  
	{
		BWriteService command= new BWriteService();
		command.execute(sqlsession,bDto);
		return "redirect:list"; //�� �ۼ� �ϰ����� �ٽ� �� ����� ������ �ϹǷ� list.jspȣ��ǰԲ�.
	}
	
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		return "write_view";} // �۾��� �޴� �������� �ٷ� ȭ�鸸 �����ָ� �Ǵϱ� �ٷ� �������ָ� ��
	
	
	
	@RequestMapping("/content_view") //�� ���� ����
	public String content_view(HttpServletRequest request,Model model) { //list.jsp���� �� ��� �۸��� ID���� �ش��ϴ� ���� ��� ����� �ϹǷ� request �ʿ�
		model.addAttribute("request",request);
		command = new BContentService();
		command.execute(sqlsession,model);  
		return "content_view"; //�信 �ѷ�����,model���� ���� �A���� dto�� �������. jsp���Ͽ��� dto�� ������ �����.
	} 
	
	
	@RequestMapping(value="/modify") //�� �����ϱ�
	public String modify(BDto bDto,Model model) { 
		BModifyService command = new BModifyService();
		command.execute(sqlsession,bDto);  
		return "redirect:list"; //�� �����ѵ� �ٽ� �� ��� ���
	} 
	//GET��İ� POST����� ����  https://blog.outsider.ne.kr/312 
	
	@RequestMapping("/delete") //�� �����ϱ�
	public String delete(HttpServletRequest request,Model model) { //request���� ���� id�� ���������. 
		model.addAttribute("request",request);
		command = new BDeleteService(); 
		command.execute(sqlsession,model);   
		return "redirect:list"; 
	}
	
	
	
	
	
	
	
}

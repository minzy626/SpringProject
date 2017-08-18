package com.javalec.ex.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.dto.UserDto;


@Controller
public class MailController {
	
	@Autowired
	JavaMailSender mailSender; //root-context���� ������ google mailsender ��
	
	// mailSending �ڵ�
	  @RequestMapping(value = "/sendpass")
	  public String mailSending(Model model,HttpServletResponse response) {
		Map<String, Object> map = model.asMap();
		UserDto userDto = (UserDto)map.get("resultDto");
	    
	    String setfrom = "springteam11@gmail.com";         
	    String tomail  = userDto.getbId();     // �޴� ��� �̸���
	    String title   = userDto.getbNick() + "���� ��й�ȣ �Դϴ�.";      // ����
	    String content = userDto.getbNick() + "���� �ӽ� ��й�ȣ�� " +userDto.getbPass()
	    					+ " �Դϴ�.\n �α��� �� �ݵ�� ��й�ȣ�� ������ �ֽñ� �ٶ��ϴ�.";    // ����
	   
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8"); //�ι�° ���� true���� ����÷�� ����.
	 
	      messageHelper.setFrom(setfrom);  // �����»�� �����ϰų� �ϸ� �����۵��� ����
	      messageHelper.setTo(tomail);     // �޴»�� �̸���
	      messageHelper.setSubject(title); // ���������� ������ �����ϴ�
	      messageHelper.setText(content);  // ���� ����
	     
	      mailSender.send(message);
	      
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println("<script>alert('���������� ������ �߼��߽��ϴ�.');history.go(-1);</script>");
	      out.flush();


	    } catch(Exception e){
	      System.out.println(e);
	    }
	   
	    return "login";
	  }
	  @RequestMapping(value = "/email_certify_send")
	  public String email_certify_send(ModelMap model, HttpServletResponse response, HttpSession session, RedirectAttributes redirectattr) {
		UserDto userDto = (UserDto)model.get("userDto");
		UserDto resultDto = (UserDto)model.get("resultDto");
		
		if(resultDto == null) {
		double randomValue = Math.random();
		int randomValue2 = (int)(randomValue * 900000) + 100000;
		String certifyNum = String.valueOf(randomValue2);
	    
	    String setfrom = "springteam11@gmail.com";         
	    String tomail  = userDto.getbId();     // �޴� ��� �̸���
	    String title   = "�̸��� ������ȣ �Դϴ�.";      // ����
	    String content = "ȸ������ ������ȣ�� " + certifyNum
	    					+ " �Դϴ�.";    // ����
	    
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8"); //�ι�° ���� true���� ����÷�� ����.
	 
	      messageHelper.setFrom(setfrom);  // �����»�� �����ϰų� �ϸ� �����۵��� ����
	      messageHelper.setTo(tomail);     // �޴»�� �̸���
	      messageHelper.setSubject(title); // ���������� ������ �����ϴ�
	      messageHelper.setText(content);  // ���� ����
	     
	      mailSender.send(message);
	      
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println("<script>alert('���������� ������ �߼��߽��ϴ�.');history.go(-1);</script>");
	      out.flush();
	        
	      session.setAttribute("certifyNum", certifyNum);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	    
		}
	   
	    return "emailCheckForm";
	  }
	  
	  @RequestMapping(value = "/withdraw_certify_send")
	  public String withdraw_certify_send(ModelMap model, HttpServletResponse response, HttpSession session, RedirectAttributes redirectattr) {
		UserDto userDto = (UserDto)model.get("userDto");
		
		double randomValue = Math.random();
		int randomValue2 = (int)(randomValue * 900000) + 100000;
		String certifyNum = String.valueOf(randomValue2);
	    
	    String setfrom = "springteam11@gmail.com";         
	    String tomail  = userDto.getbId();     // �޴� ��� �̸���
	    String title   = "�̸��� ������ȣ �Դϴ�.";      // ����
	    String content = "ȸ��Ż�� ������ȣ�� " + certifyNum
	    					+ " �Դϴ�.";    // ����
	    
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8"); //�ι�° ���� true���� ����÷�� ����.
	 
	      messageHelper.setFrom(setfrom);  // �����»�� �����ϰų� �ϸ� �����۵��� ����
	      messageHelper.setTo(tomail);     // �޴»�� �̸���
	      messageHelper.setSubject(title); // ���������� ������ �����ϴ�
	      messageHelper.setText(content);  // ���� ����
	     
	      mailSender.send(message);
	      
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println("<script>alert('���������� ������ �߼��߽��ϴ�.');history.go(-1);</script>");
	      out.flush();
	        
	      session.setAttribute("certifyNum", certifyNum);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	    
	   
	    return "withdrawForm";
	  }  

}

package com.javalec.ex.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MailController {
	
	@Autowired
	JavaMailSender mailSender; //root-context���� ������ google mailsender ��
	
	// mailSending �ڵ�
	  @RequestMapping(value = "/send")
	  public String mailSending(HttpServletRequest request) {
	   
	    String setfrom = "springteam11@gmail.com";         
	    String tomail  = "simsimjae@naver.com";     // �޴� ��� �̸���
	    String title   = "�����Դϴ�";      // ����
	    String content = "�����Դϴ�";    // ����
	   
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper 
	                        = new MimeMessageHelper(message, true, "UTF-8");
	 
	      messageHelper.setFrom(setfrom);  // �����»�� �����ϰų� �ϸ� �����۵��� ����
	      messageHelper.setTo(tomail);     // �޴»�� �̸���
	      messageHelper.setSubject(title); // ���������� ������ �����ϴ�
	      messageHelper.setText(content);  // ���� ����
	     
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	   
	    return "redirect:list";
	  }
	
}

package com.javalec.ex.controller;

import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.ex.dto.UserDto;


@Controller
public class MailController {
	
	@Autowired
	JavaMailSender mailSender; //root-context���� ������ google mailsender ��
	
	// mailSending �ڵ�
	  @RequestMapping(value = "/sendpass")
	  public String mailSending(Model model) {
		Map<String, Object> map = model.asMap();
		UserDto userDto = (UserDto)map.get("resultDto");
	    
	    System.out.println(userDto.getbEmail());
		System.out.println(userDto.getbId());
	    String setfrom = "springteam11@gmail.com";         
	    String tomail  = userDto.getbEmail();     // �޴� ��� �̸���
	    String title   = userDto.getbId() + "���� ��й�ȣ �Դϴ�.";      // ����
	    String content = userDto.getbId() + "���� ��й�ȣ�� " +userDto.getbPass()
	    					+ " �Դϴ�.";    // ����
	   
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8"); //�ι�° ���� true���� ����÷�� ����.
	 
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
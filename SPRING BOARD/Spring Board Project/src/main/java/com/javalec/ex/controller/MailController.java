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
	JavaMailSender mailSender; //root-context에서 생성한 google mailsender 빈
	
	// mailSending 코드
	  @RequestMapping(value = "/sendpass")
	  public String mailSending(Model model) {
		Map<String, Object> map = model.asMap();
		UserDto userDto = (UserDto)map.get("resultDto");
	    
	    System.out.println(userDto.getbEmail());
		System.out.println(userDto.getbId());
	    String setfrom = "springteam11@gmail.com";         
	    String tomail  = userDto.getbEmail();     // 받는 사람 이메일
	    String title   = userDto.getbId() + "님의 비밀번호 입니다.";      // 제목
	    String content = userDto.getbId() + "님의 비밀번호는 " +userDto.getbPass()
	    					+ " 입니다.";    // 내용
	   
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8"); //두번째 인자 true여야 파일첨부 가능.
	 
	      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	      messageHelper.setTo(tomail);     // 받는사람 이메일
	      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	      messageHelper.setText(content);  // 메일 내용
	     
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	   
	    return "redirect:list";
	  }
	
}

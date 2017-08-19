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
	JavaMailSender mailSender; //root-context에서 생성한 google mailsender 빈
	
	// mailSending 코드
	  @RequestMapping(value = "/sendpass")
	  public String mailSending(Model model,HttpServletResponse response) {
		Map<String, Object> map = model.asMap();
		UserDto userDto = (UserDto)map.get("resultDto");
	    
	    String setfrom = "springteam11@gmail.com";         
	    String tomail  = userDto.getbId();     // 받는 사람 이메일
	    String title   = userDto.getbNick() + "님의 비밀번호 입니다.";      // 제목
	    String content = userDto.getbNick() + "님의 임시 비밀번호는 " +userDto.getbPass()
	    					+ " 입니다.\n 로그인 후 반드시 비밀번호를 수정해 주시기 바랍니다.";    // 내용
	   
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8"); //두번째 인자 true여야 파일첨부 가능.
	 
	      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	      messageHelper.setTo(tomail);     // 받는사람 이메일
	      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	      messageHelper.setText(content);  // 메일 내용
	     
	      mailSender.send(message);
	      
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println("<script>alert('성공적으로 메일을 발송했습니다.');history.go(-1);</script>");
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
	    String tomail  = userDto.getbId();     // 받는 사람 이메일
	    String title   = "이메일 인증번호 입니다.";      // 제목
	    String content = "회원가입 인증번호는 " + certifyNum
	    					+ " 입니다.";    // 내용
	    
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8"); //두번째 인자 true여야 파일첨부 가능.
	 
	      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	      messageHelper.setTo(tomail);     // 받는사람 이메일
	      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	      messageHelper.setText(content);  // 메일 내용
	     
	      mailSender.send(message);
	      
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println("<script>alert('성공적으로 메일을 발송했습니다.');history.go(-1);</script>");
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
	    String tomail  = userDto.getbId();     // 받는 사람 이메일
	    String title   = "이메일 인증번호 입니다.";      // 제목
	    String content = "회원탈퇴 인증번호는 " + certifyNum
	    					+ " 입니다.";    // 내용
	    
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper  = new MimeMessageHelper(message, true, "UTF-8"); //두번째 인자 true여야 파일첨부 가능.
	 
	      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	      messageHelper.setTo(tomail);     // 받는사람 이메일
	      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	      messageHelper.setText(content);  // 메일 내용
	     
	      mailSender.send(message);
	      
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println("<script>alert('성공적으로 메일을 발송했습니다.');history.go(-1);</script>");
	      out.flush();
	        
	      session.setAttribute("certifyNum", certifyNum);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	    
	   
	    return "withdrawForm";
	  }  

}

package com.javalec.ex_spring_pjt;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//HttpServletRequest를 통한 데이터 입력 받기.
	@RequestMapping("board/confirmid")
	public String confirmid(HttpServletRequest httpServletRequest,Model model) {
		model.addAttribute("id",httpServletRequest.getParameter("id"));
		model.addAttribute("pw",httpServletRequest.getParameter("pw"));
		
		return "board/confirmid";
	}
	
	//RequestParam을 이용한 데이터 입력 받기
	@RequestMapping("board/checkid")
	public String checkid(@RequestParam("id") String id,@RequestParam("pw") int pw,Model model) {
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "board/checkid";
	}
	
	
//	//RequestParam을 이용한 데이터 입력 받은후 객체 초기화후 뷰로 넘기기
//	@RequestMapping("join/form")
//	public String join(@RequestParam("name") String name,@RequestParam("id") String id,@RequestParam("pw") String pw,@RequestParam("email") String email,
//			Model model) {
//		Member member = new Member();
//		member.setEmail(email);
//		member.setId(id);
//		member.setName(name);
//		member.setPw(pw);
//		model.addAttribute(member);
//		return "join/form";
//	}
	
	@RequestMapping("join/form")
	public String form(Member member) {
		return "join/form";
	}
	
	@RequestMapping("student/{studentid}")
	public String student(@PathVariable("studentid") String id,Model model) {
		model.addAttribute("id",id);
		return "student/studentid";
	}
	
	
}

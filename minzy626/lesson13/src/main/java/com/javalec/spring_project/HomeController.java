package com.javalec.spring_project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("/member/memberView")
	public String viewMember(HttpServletRequest httpServletRequest,Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		
		return "/member/memberView";
	}
	//http와 다른것은 http는 값이 없어도 페이지는 나오는데 requestparam은 값을 안주면 화면안나옴.400에러뜸.
	@RequestMapping("member/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "member/checkId";
	}
	/*
	@RequestMapping("/join/formOK")
	public String join(@RequestParam("name")String name,
			@RequestParam("id")String id,
			@RequestParam("pw")String pw,
			@RequestParam("email")String email, Model model){
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("member",member);
		
		return "join/formOK";
	}*/
	
	@RequestMapping("/join/formOK")
	public String join(Member member){
		
		return "join/formOK";
	}

		

}	


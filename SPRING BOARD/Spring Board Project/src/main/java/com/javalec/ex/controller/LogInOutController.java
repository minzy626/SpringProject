package com.javalec.ex.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.UserService.LogInService;
import com.javalec.ex.dto.UserDto;

@Controller
public class LogInOutController {
	
	@Autowired
	SqlSession sqlsession;
	
	public LogInOutController() {
	}
	
	@RequestMapping("/login_view")
	public String LogInView(UserDto userDto,Errors errors) {
		return "login";
	}
	
	@RequestMapping("/login")
	public String LogIn(UserDto userDto,Errors errors,HttpSession httpSession)
	{
		LogInService logInService = new LogInService();
		
		try {
			UserDto resultDto = logInService.login(sqlsession,userDto);
			httpSession.setAttribute("userinfo", resultDto);
		} catch (Exception e) {
			errors.reject("IDPASSNOTMATCH");
			return "login";
		}
		return "index";
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession httpSession)
	{
		httpSession.invalidate();
		return "redirect:index";
	}
	
}

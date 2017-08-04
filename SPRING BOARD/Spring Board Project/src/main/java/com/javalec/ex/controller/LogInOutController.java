package com.javalec.ex.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.ex.UserService.LogInService;
import com.javalec.ex.dto.UserDto;

@Controller
public class LogInOutController {
	
	@Autowired
	SqlSession sqlsession;
	
	public LogInOutController() {
	}
	
	@RequestMapping("/login")
	public String LogIn(UserDto userDto,Errors errors,HttpSession httpSession)
	{
		LogInService logInService = new LogInService();
		
		try {
			UserDto resultDto = logInService.login(sqlsession,userDto,errors);
			httpSession.setAttribute("userinfo", resultDto);
		} catch (Exception e) {
			return "login";
		}
		return "index";
	}
	
	
}

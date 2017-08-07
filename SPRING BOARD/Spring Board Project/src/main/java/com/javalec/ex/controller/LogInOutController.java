package com.javalec.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String LogIn(UserDto userDto,Errors errors,HttpSession httpSession,HttpServletResponse response) throws IOException
	{
		LogInService logInService = new LogInService();
		
		try {
			UserDto resultDto = logInService.login(sqlsession,userDto);
			httpSession.setAttribute("userinfo", resultDto);
		} catch (Exception e) {
			errors.reject("IDPASSNOTMATCH");
			return "login";
		}
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<script>alert('성공적으로 로그인 되었습니다.');</script>");
	    out.flush();
	    return "index";
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession httpSession)
	{
		httpSession.invalidate();
		return "redirect:index";
	}
	
}

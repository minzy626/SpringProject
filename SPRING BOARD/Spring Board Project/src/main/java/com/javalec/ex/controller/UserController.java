package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.UserCommand.BRegisterCommand;
import com.javalec.ex.UserCommand.BUserCommand;

@Controller
public class UserController {
	BUserCommand command = null;
	@Autowired
	SqlSession sqlsession;
	
	public UserController() {
	
	}
	
	@RequestMapping(value="/sign_up", method = RequestMethod.GET)
	public String sign_up(Model model) {
		return "sign_up";
	}
	
	
	@RequestMapping(value="/memberinfo", method = RequestMethod.GET)
	public String memberinfo(Model model) {
		return "memberinfo";
	}
	
	@RequestMapping(value="/register" ,method = RequestMethod.POST) 
	public String register(HttpServletRequest request,Model model)
	{
		model.addAttribute("request",request);
		command = new BRegisterCommand();
		command.execute(sqlsession,model);
		return "redirect:index"; 
	}
	
}

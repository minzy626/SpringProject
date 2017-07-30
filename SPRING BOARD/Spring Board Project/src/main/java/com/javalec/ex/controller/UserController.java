package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.UserService.BFindpassService;
import com.javalec.ex.UserService.BRegisterService;
import com.javalec.ex.UserService.BUserService;
import com.javalec.ex.dto.UserDto;
import com.javalec.ex.validator.FindPassValidator;

@Controller
public class UserController {
	BUserService command = null;
	@Autowired
	SqlSession sqlsession;
	
	public UserController() {
	
	}
	
	@RequestMapping(value="/sign_up", method = RequestMethod.GET)
	public String sign_up(Model model) {
		return "sign_up";
	}
	
	@RequestMapping(value="/find_pass", method = RequestMethod.POST)
	public String find_pass(UserDto userDto,Model model,Errors errors) {
		new FindPassValidator().validate(userDto, errors);
		if(errors.hasErrors())
			return "find_passView";
//		try {
//			
//		}catch()
//		{
//			
//		}
		command = new BFindpassService();
		command.execute(sqlsession, model);
		return "redirect:index";
	}
	
	@RequestMapping(value="/memberinfo", method = RequestMethod.GET)
	public String memberinfo(Model model) {
		return "memberinfo";
	}
	
	@RequestMapping(value="/register" ,method = RequestMethod.POST) 
	public String register(HttpServletRequest request,UserDto userDto)
	{
		BRegisterService command = new BRegisterService();
		command.execute(sqlsession,userDto);
		return "redirect:index"; 
	}
	
}

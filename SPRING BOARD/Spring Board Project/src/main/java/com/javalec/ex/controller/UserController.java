package com.javalec.ex.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.UserService.BFindpassService;
import com.javalec.ex.UserService.BRegisterService;
import com.javalec.ex.dto.UserDto;
import com.javalec.ex.validator.FindPassValidator;

@Controller
public class UserController {
	
	@Autowired
	SqlSession sqlsession;
	
	public UserController() {
	
	}
	
	@RequestMapping(value="/sign_up", method = RequestMethod.GET)
	public String sign_up(Model model) {
		return "sign_up";
	}
	
	@RequestMapping(value="/sign_up2", method = RequestMethod.POST)
	public String sign_up2(Model model) {
		return "sign_up2";
	}
	
	@RequestMapping(value="/find_pass", method = RequestMethod.POST)
	public String find_pass(UserDto userDto,RedirectAttributes redirectattr,Errors errors) {
		new FindPassValidator().validate(userDto, errors);
		if(errors.hasErrors())
			return "find_passView";
		
		BFindpassService service = new BFindpassService();
		
		try {
			UserDto resultDto = service.execute(sqlsession, userDto);
			redirectattr.addFlashAttribute("resultDto",resultDto); 
			return "redirect:sendpass";
		}catch(Exception e)
		{
			errors.reject("IdEmailNotMatch");
			return "find_passView"; 
		}
		
	}
	
	@RequestMapping(value="/memberinfo", method = RequestMethod.GET)
	public String memberinfo(Model model) {
		return "memberinfo";
	}
	
	@RequestMapping(value="/register" ,method = RequestMethod.POST) 
	public String register(HttpServletRequest request,UserDto userDto)
	{
		BRegisterService service = new BRegisterService();
		service.execute(sqlsession,userDto);
		return "redirect:index"; 
	}
	
}

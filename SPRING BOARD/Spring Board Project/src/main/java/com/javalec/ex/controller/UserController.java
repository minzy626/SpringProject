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
	
	@RequestMapping(value="/find_pass", method = RequestMethod.POST)
	public String find_pass(UserDto userDto,RedirectAttributes redirectattr,Errors errors) {
		new FindPassValidator().validate(userDto, errors);
		if(errors.hasErrors())
			return "find_passView";
		
		BFindpassService service = new BFindpassService();
		
		try {
			UserDto resultDto = service.execute(sqlsession, userDto);
			redirectattr.addFlashAttribute("resultDto",resultDto); //리다이렉트 시에는 모델에 넣은 값이 제대로 전달이 안돼서 이거 사용함.
			return "redirect:sendpass"; //값을 무리없이 잘 가져왔으면 메일을 전송함.
		}catch(Exception e)
		{
			errors.reject("IdEmailNotMatch");
			return "find_passView"; //아이디가 존재하지않거나 아이디와 이메일이 일치하지 않는경우 다시 입력받음.
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

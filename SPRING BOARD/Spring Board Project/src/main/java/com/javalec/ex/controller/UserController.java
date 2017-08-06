package com.javalec.ex.controller;

import java.io.PrintWriter;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.UserService.FindpassService;
import com.javalec.ex.UserService.IdDuplicationService;
import com.javalec.ex.UserService.RegisterService;
import com.javalec.ex.dto.UserDto;
import com.javalec.ex.validator.FindPassValidator;
import com.javalec.ex.validator.IdDuplicationValidator;

@Controller
public class UserController {
	
	@Autowired
	SqlSession sqlsession;
	
	public UserController() {
	
	}
	
	@RequestMapping(value="/find_passView", method = RequestMethod.GET)
	public String Find_passView(Model model) {
		return "find_passView";
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
		
		FindpassService service = new FindpassService();
		
		try {
			UserDto resultDto = service.execute(sqlsession, userDto);
			redirectattr.addFlashAttribute("resultDto",resultDto); 
			return "redirect:sendpass";
		}catch(Exception e)
		{
			errors.reject("IDPASSNOTMATCH");
			errors.reject("bId","IDNotExist");
			errors.reject("IdEmailNotMatch");
			return "find_passView"; 
		}
		
	}
	
	@RequestMapping(value="/memberinfo")
	public String memberinfo(Model model,HttpSession httpsession) {
		return "memberinfo";
	}
	
	@RequestMapping(value="/register" ,method = RequestMethod.POST) 
	public String register(HttpServletRequest request,UserDto userDto)
	{
		RegisterService service = new RegisterService();
		service.execute(sqlsession,userDto);
		return "redirect:index"; 
	}
	
	@RequestMapping(value="/idCheckForm", method = RequestMethod.GET)
	public String idCheckForm(Model model) {
		return "idCheckForm";
	}
	
	@RequestMapping(value="/id_duplication_check", method = RequestMethod.POST)
	public String duplication_check(UserDto userDto,RedirectAttributes redirectattr,Errors errors) {
		new IdDuplicationValidator().validate(userDto, errors);
		if(errors.hasErrors()) 
			return "idCheckForm";
		
		IdDuplicationService service = new IdDuplicationService();
		
		try {
			UserDto resultDto = service.execute(sqlsession, userDto);
			redirectattr.addFlashAttribute("resultDto",resultDto); 
			return "redirect:/idCheckForm/id_check_confirm";
		}catch(Exception e)
		{
			errors.reject("IDExist");
			return "idCheckForm"; 
		}
		
	}
	
	@RequestMapping(value="/idCheckForm/id_check_confirm", method = RequestMethod.GET)
	public String id_check_confirm(Model model, HttpServletResponse response) {
		Map<String, Object> map = model.asMap();
		UserDto userDto = (UserDto)map.get("resultDto");
		
		if(userDto == null) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('사용할 수 있는 계정입니다.');history.go(-1);</script>");
				out.println("<script>opener.document.userInfo.idDuplication.value =\"idCheck\";</script>");				
				out.flush();
			} catch(Exception e){
				System.out.println(e);
			}
		}

		return "sign_up2";
	}
}

package com.javalec.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Principal;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.UserService.UserService;
import com.javalec.ex.UserService.UserServiceImpl;
import com.javalec.ex.dto.CDto;
import com.javalec.ex.dto.UserDto;
import com.javalec.ex.validator.FindPassValidator;
import com.javalec.ex.validator.IdDuplicationValidator;
import com.javalec.ex.validator.NickDuplicationValidator;
import com.javalec.ex.validator.PasswordValidator;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserService uService;
	@Autowired
	UserServiceImpl service;
	public UserController() {
	
	}
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@RequestMapping(value="/login_view")
	public String login_view(Model model, Principal principal) {
		model.addAttribute("principal", principal);
		return "login";
	}
	
	@RequestMapping(value="/find_passView", method = RequestMethod.GET)
	public String Find_passView() {
		return "find_passView";
	}
	
	@RequestMapping(value="/find_pass", method = RequestMethod.POST)
	public String find_pass(UserDto userDto,RedirectAttributes redirectattr,Errors errors) {
		new FindPassValidator().validate(userDto, errors);
		
		if(errors.hasErrors())
			return "find_passView";
			
		try {
			UserDto resultdto = uService.find_by_id(userDto);
			if(resultdto == null)
				throw new Exception();
			
			double randomvalue = Math.random();
			int random = (int)(randomvalue * 1000000) +1;
			String password = passwordEncoder.encode(String.valueOf(random));
			
			resultdto.setbPass(password); //암호화된 비밀번호를 디비에 저장해줌.
			uService.update_pass_by_id(resultdto); //암호화된 비밀번호를 디비에 저장해줌.
			
			resultdto.setbPass(String.valueOf(random));
			
			redirectattr.addFlashAttribute("resultDto", resultdto); 
			return "redirect:sendpass";
		}catch(Exception e)
		{
			errors.reject("IDNotExist");
			return "find_passView"; 
		}
		
	}
	
	@RequestMapping(value="/memberinfo")
	public String memberinfo(Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		String decode = URLDecoder.decode(request.getParameter("nickname"),"UTF-8");
		UserDto dto = new UserDto();
		dto.setbNick(decode);
		model.addAttribute("dto",service.find_by_nick(dto));
		return "memberinfo";
	}
	
	//회원가입 관련
	@RequestMapping(value="/sign_up", method = RequestMethod.GET)//이용약관
	public String sign_up(Model model) {
		return "sign_up";
	}
	
	@RequestMapping(value="/sign_up2", method = RequestMethod.POST)//회원가입
	public String sign_up2(Model model, HttpSession session) {
		return "sign_up2";
	}
	
	@RequestMapping(value="/register" ,method = RequestMethod.POST) //회원가입 완료
	public String register(HttpServletRequest request, HttpServletResponse response, UserDto userDto, Errors errors, HttpSession session){
		//ID 타당성 체크
		new IdDuplicationValidator().validate(userDto, errors);
		if(errors.hasErrors()) 
			return "sign_up2";
		
		if(uService.find_by_id(userDto) != null) {
			errors.reject("IDExist");
			return "sign_up2"; 
		}
		
		//닉네임 타당성 체크
		new NickDuplicationValidator().validate(userDto, errors);
		if(errors.hasErrors()) 
			return "sign_up2";
		
		if(uService.find_by_nick(userDto) != null) {
			errors.reject("NickExist");
			return "sign_up2"; 
		}
		
		//패스워드 타당성 체크
		new PasswordValidator().validate(userDto, errors);
		if(errors.hasErrors()) 
			return "sign_up2";
		
		if(uService.select_dropuser(userDto) != null) {
			errors.reject("RecentDropUser");
			return "sign_up2"; 
		}
		
		//이메일 인증 세션 확인
		String success = (String)session.getAttribute("success");
		System.out.println(success);
		
		try {
			if(success.equals("success")) {
				String Password = userDto.getbPass();
				String encrypted = passwordEncoder.encode(Password);
				userDto.setbPass(encrypted);
				uService.register(userDto);
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원가입이 완료 되었습니다.');</script>");
				out.flush();
				  
				session.removeAttribute("success");
				session.removeAttribute("certifyNum");
				return "index";
			}
			else {
				errors.reject("FailCertify");
				return "sign_up2"; 
			}
		} catch (Exception e) {
			errors.reject("NotCertify");
			return "sign_up2"; 
		}

	}
	@RequestMapping(value="/emailCheckForm", method = RequestMethod.GET)//이메일 인증번호창
	public String emailCheckForm(Model model, HttpSession session) {
		return "emailCheckForm";
	}
	
	@RequestMapping(value="/email_certify", method = RequestMethod.POST)
	public String email_certify(HttpServletRequest request, HttpServletResponse response, UserDto userDto, RedirectAttributes redirectattr, Errors errors, HttpSession session) {
		UserDto resultDto = uService.find_by_id(userDto);
		
		if(resultDto == null) {
			redirectattr.addFlashAttribute("resultDto", resultDto); 
			redirectattr.addFlashAttribute("userDto", userDto);
			return "redirect:/email_certify_send";
		}
		else {
			errors.reject("IDExist");
			return "emailCheckForm"; 
		}
		
	}
	
	@RequestMapping(value="/email_certify_confirm", method = RequestMethod.POST)
	public String email_certification_check(Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		String certifyNum = (String)session.getAttribute("certifyNum");
		String certNumber = (String)request.getParameter("certNumber");
		String success = "fail";
		
		if(certifyNum.equals(certNumber) && certNumber != null) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('인증에 성공하셨습니다.');history.go(-1);</script>");
				out.println("<script>self.close();history.go(-1);</script>");		
				out.flush();
				success = "success";
			} catch(Exception e){
				System.out.println(e);
			}
		}

		session.setAttribute("success", success);
		return "emailCheckForm";
	}
	
	@RequestMapping(value="/memberModify", method = RequestMethod.GET)
	public String memberModify(Model model, HttpSession session) {
		return "memberModify";
	}
	
	@RequestMapping(value="/user_modify_confirm", method = RequestMethod.POST)
	public String user_modify_confirm(HttpServletRequest request, UserDto userDto, Errors errors, HttpSession httpSession, HttpServletResponse response) throws IOException
	{
		String bCurrentPass = (String)request.getParameter("bCurrentPass");
		UserDto resultDto = uService.find_by_id(userDto);
		String currentPassword = resultDto.getbPass();
		
		if(!passwordEncoder.matches(bCurrentPass, currentPassword)) {
			errors.reject("PassNotMatch");
			return "memberModify";
		}
		
		if(userDto.getbPass().equals("")) {
			uService.user_modify(userDto);
		}
		else {
			//패스워드 타당성 체크
			new PasswordValidator().validate(userDto, errors);
			if(errors.hasErrors()) 
				return "memberModify";
			String Password = userDto.getbPass();
			String encrypted = passwordEncoder.encode(Password);
			userDto.setbPass(encrypted);
			uService.user_modify_pass(userDto);
		}

		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<script>alert('회원정보 수정을 완료 하였습니다.');</script>");
	    out.println("<script>alert('변경된 정보로 재로그인해주세요.');</script>");
		out.println("<script>location.href=\"logout\";</script>");
	    out.flush();
	    
		return "index"; 
	}
	
	@RequestMapping(value="/withdrawForm", method = RequestMethod.GET)
	public String withdrawForm(Model model, HttpSession session) {
		return "withdrawForm";
	}

	@RequestMapping(value="/withdraw_certify", method = RequestMethod.POST)
	public String withdraw_certify(HttpServletRequest request, HttpServletResponse response, UserDto userDto, RedirectAttributes redirectattr, Errors errors, HttpSession session) {
		
		try {
			redirectattr.addFlashAttribute("userDto", userDto);
			return "redirect:/withdraw_certify_send";
		}catch(Exception e)
		{
			System.out.println(e);
			return "withdrawForm"; 
		}
		
	}
	
	@RequestMapping(value="/withdraw_certify_confirm", method = RequestMethod.POST)
	public String withdraw_certify_confirm(Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session){
		String certifyNum = (String)session.getAttribute("certifyNum");
		String certNumber = (String)request.getParameter("certNumber");
		String dropId = (String)request.getParameter("dropId");
		UserDto userDto = uService.find_by_string_id(dropId);
		
		if(certifyNum.equals(certNumber) && certNumber != null) {
			
			try {
				uService.drop_by_id(userDto);
				uService.insert_dropuser(userDto);
					
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원탈퇴를 완료하였습니다.');history.go(-1);</script>");
				out.println("<script>opener.location.href=\"logout\";history.go(-1);</script>");	
				out.println("<script>self.close();history.go(-1);</script>");		
				out.flush();
				
			} catch (Exception e) {
				System.out.println(e);
				return "withdrawForm";
			}
		}
		else {
			return "withdrawForm"; 
		}
		
		session.removeAttribute("success");
		session.removeAttribute("certifyNum");
		return "index";
	}
}
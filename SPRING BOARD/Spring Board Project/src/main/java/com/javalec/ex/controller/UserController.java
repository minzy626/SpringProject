package com.javalec.ex.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.UserService.EmailCertifyService;
import com.javalec.ex.UserService.FindpassService;
import com.javalec.ex.UserService.IdDuplicationService;
import com.javalec.ex.UserService.NickDuplicationService;
import com.javalec.ex.UserService.RegisterService;
import com.javalec.ex.UserService.UserConfirmService;
import com.javalec.ex.UserService.UserModifyService;
import com.javalec.ex.UserService.WithdrawService;
import com.javalec.ex.dto.UserDto;
import com.javalec.ex.validator.FindPassValidator;
import com.javalec.ex.validator.IdDuplicationValidator;
import com.javalec.ex.validator.NickDuplicationValidator;

@Controller
public class UserController {
	
	@Autowired
	SqlSession sqlsession;
	@Autowired
	RegisterService registerService;
	@Autowired
	FindpassService findpassService;
	
	public UserController() {
	
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
			UserDto resultDto = findpassService.execute(sqlsession, userDto);
			redirectattr.addFlashAttribute("resultDto",resultDto); 
			return "redirect:sendpass";
		}catch(Exception e)
		{
			errors.reject("IDNotExist");
			return "find_passView"; 
		}
		
	}
	
	@RequestMapping(value="/memberinfo")
	public String memberinfo(Model model,Authentication auth) {
		model.addAttribute("userinfo",auth);
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
		new IdDuplicationValidator().validate(userDto, errors);
		if(errors.hasErrors()) 
			return "sign_up2";
		
		IdDuplicationService idservice = new IdDuplicationService();
		try {
			idservice.execute(sqlsession, userDto);
		}catch(Exception e)
		{
			errors.reject("IDExist");
			return "sign_up2"; 
		}
		
		new NickDuplicationValidator().validate(userDto, errors);
		if(errors.hasErrors()) 
			return "sign_up2";
		
		NickDuplicationService nickservice = new NickDuplicationService();
		
		try {
			nickservice.execute(sqlsession, userDto);
		}catch(Exception e)
		{
			errors.reject("NickExist");
			return "sign_up2"; 
		}
		
		String success = (String)session.getAttribute("success");
		System.out.println(success);
		
		try {
			if(success.equals("success")) {
				RegisterService service = new RegisterService();
				service.execute(sqlsession,userDto);

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
		EmailCertifyService service = new EmailCertifyService();

		try {
			UserDto resultDto = service.execute(sqlsession, userDto);
			redirectattr.addFlashAttribute("resultDto", resultDto); 
			redirectattr.addFlashAttribute("userDto", userDto);
			return "redirect:/email_certify_send";
		}catch(Exception e)
		{
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
		return "memberModify2";
	}
	
	@RequestMapping(value="/memberModify2", method = RequestMethod.POST)
	public String memberModify2(Model model, HttpSession session) {

		return "memberModify2";
	}
	
	@RequestMapping(value="/user_modify", method = RequestMethod.POST)
	public String user_modify(UserDto userDto,Errors errors,HttpSession httpSession,HttpServletResponse response)
	{
/*		LogInService logInService = new LogInService();
		
		try {
			logInService.login(sqlsession,userDto);
		} catch (Exception e) {
			errors.reject("IDPASSNOTMATCH");
			return "memberModify";
		}*/
	    return "memberModify2";
	}
	
	@RequestMapping(value="/user_modify_confirm", method = RequestMethod.POST)
	public String user_modify_confirm(HttpServletRequest request, UserDto userDto, Errors errors, HttpSession httpSession, HttpServletResponse response) throws IOException
	{
		String bCurrentPass = (String)request.getParameter("bCurrentPass");
		
		try {
			UserConfirmService confirmService = new UserConfirmService();
			confirmService.execute(sqlsession, userDto, bCurrentPass);
		}
		catch (Exception e) {
			errors.reject("PassNotMatch");
			return "memberModify2";
		}
		
		UserModifyService service = new UserModifyService();
		service.execute(sqlsession,userDto);

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
		UserDto userDto = new UserDto();
		userDto.setbId(dropId);
		
		if(certifyNum.equals(certNumber) && certNumber != null) {
			
			try {
				WithdrawService service = new WithdrawService();
				service.execute(sqlsession,userDto);
					
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
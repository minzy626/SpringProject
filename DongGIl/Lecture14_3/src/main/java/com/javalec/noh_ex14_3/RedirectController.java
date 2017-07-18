package com.javalec.noh_ex14_3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOk";
		}
		else
			return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		return "studentNg";
	}
	
}

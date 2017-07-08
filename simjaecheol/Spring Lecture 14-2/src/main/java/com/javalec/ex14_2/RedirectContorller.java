package com.javalec.ex14_2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectContorller {

	@RequestMapping("/studentConfirm")
	public String student(HttpServletRequest hsr,Model model) {
		
		if(hsr.getParameter("name").equals("abcd"))
		{
			return "redirect:studentOK";
		}
		
		return "redirect:studentNG";
	}
	
	@RequestMapping("/studentOK")
	public String studentOK(Model model) {
		return "studentOK";
	}
	
	@RequestMapping("/studentNG")
	public String studentNG(Model model) {
			return "studentNG";
	}
	
	@RequestMapping("student/studentURL1")
	public String studentURL1(Model model) {
			return "redirect:http://localhost:8181/ex14_2/studentURL1.jsp";
	}
	
	@RequestMapping("/studentURL2")
	public String studentURL2(Model model) {
		return "redirect:http://localhost:8181/ex14_2/studentURL2.jsp";
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL11(Model model) {
			return "redirect:/student/studentURL1";
	}
	
}

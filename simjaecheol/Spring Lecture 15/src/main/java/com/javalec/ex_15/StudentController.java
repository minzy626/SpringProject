package com.javalec.ex_15;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	
	@RequestMapping("/studentForm")
	public String studentFrom() {
		return "createPage";
	}
	
	@RequestMapping("/student/create") //유효성 검증
	public String studentCreate(@ModelAttribute("student") @Valid student student,BindingResult result) {
		String page = "createDone";
		

		
// 		Validator 객체를 통한 커맨드 객체 유효성 검사		
//		System.out.println(student.getId());
//		System.out.println(student.getName());
//		StudentValidator validator = new StudentValidator();
//	
//		validator.validate(student,result);
		
		if(result.hasErrors())
		{
			page ="createPage";
		}
		
		return page;
		
	}
	
	@org.springframework.web.bind.annotation.InitBinder
	protected void InitBinder(WebDataBinder binder)
	{
		binder.setValidator(new StudentValidator());
	}
	
}

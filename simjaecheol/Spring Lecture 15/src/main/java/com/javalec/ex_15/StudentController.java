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
	
	@RequestMapping("/student/create") //��ȿ�� ����
	public String studentCreate(@ModelAttribute("student") @Valid student student,BindingResult result) {
		String page = "createDone";
		

		
// 		Validator ��ü�� ���� Ŀ�ǵ� ��ü ��ȿ�� �˻�		
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

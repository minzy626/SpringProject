package com.javalec.ex_15;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		
		System.out.println("validate()");
		
		student student = (student)object;
		
//		String name = student.getName();
//		if(name == null || name.trim().isEmpty())
//		{
//			System.out.println("student name is null or empty");
//			errors.rejectValue("name", "trouble");
//		}
//		
//		int id = student.getId();
//		if(id == 0)
//		{
//			System.out.println("student id is 0");
//			errors.rejectValue("id", "trouble");
//		}
//    Validator �������̽��� Ȱ���� Ŀ�Ǵ� ��ü ��ȿ�� ����
		
// ������ʹ� ValidationUtils�� ���� Ŀ�Ǵ� ��ü ��ȿ�� ����
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		
		int studentid = student.getId();
		
		if(studentid == 0)
		{
			System.out.println("studentid is 0");
			errors.rejectValue("id","trouble");
		}
		
	}

	
}

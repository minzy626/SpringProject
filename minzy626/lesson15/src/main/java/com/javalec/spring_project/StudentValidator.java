package com.javalec.spring_project;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0);  
	}//위 클래스타입의 객체를 검증
	
//위아래 두 함수가 기본적으로 작성해주어야할 메소드

//모든클래스는 오브젝트로 받는다,에러가 있을경우 에러를 받을 에러
	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;//원하는 타입으로 바꾸기
		
		String studentName = student.getName();//검증과정
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble");//이름에 문제있다고 에러추가
		}
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}
	}
	
}

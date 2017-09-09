package com.javalec.ex.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.javalec.ex.dto.UserDto;

public class PasswordValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;
	String regexp = "^[a-zA-Z0-9]{8,20}$"; //8자이상 20자 이하 영문+숫자 정규표현식
	public PasswordValidator() {
		pattern = pattern.compile(regexp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDto userDto = (UserDto)target;
		String pass = userDto.getbPass();
		matcher = pattern.matcher(userDto.getbPass());
		
		if(pass == null) 
			errors.rejectValue("bPass", "PassRequired");
		else if(pass.length() < 8 || pass.trim().isEmpty() || !matcher.matches())
			errors.rejectValue("bPass", "PassBad");
	}

}

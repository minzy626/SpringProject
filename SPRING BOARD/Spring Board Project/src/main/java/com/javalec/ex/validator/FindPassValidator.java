package com.javalec.ex.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javalec.ex.dto.UserDto;

public class FindPassValidator implements Validator { //비밀번호 찾기 화면에서 이메일과 아이디가 제대로 입력 됬는지 검증하는 클래스

	private Pattern pattern;
	private Matcher matcher;
	String regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"; //이메일 정규 표현식
	public FindPassValidator() {
		pattern = pattern.compile(regexp);
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDto userDto = (UserDto)target;
		String id = userDto.getbId();
		matcher = pattern.matcher(userDto.getbId());
		
		if(id == null || id.trim().isEmpty())
			errors.rejectValue("bId", "IdRequired");
		else if(!matcher.matches())
			errors.rejectValue("bId", "bad");
		
	}

}

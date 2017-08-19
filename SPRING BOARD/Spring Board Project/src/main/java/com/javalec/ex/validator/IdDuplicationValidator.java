package com.javalec.ex.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.javalec.ex.dto.UserDto;

public class IdDuplicationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDto userDto = (UserDto)target;
		String id = userDto.getbId();
		if(id == null || id.trim().isEmpty()) 
			errors.rejectValue("bId", "IdRequired");
		else if(id.length()<5 || id.length()>15)
			errors.rejectValue("bId", "IdLengthError");
	}
}

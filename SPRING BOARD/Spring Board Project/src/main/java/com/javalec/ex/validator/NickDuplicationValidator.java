package com.javalec.ex.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.javalec.ex.dto.UserDto;

public class NickDuplicationValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDto userDto = (UserDto)target;
		String nick = userDto.getbNick();
		if(nick == null || nick.trim().isEmpty()) 
			errors.rejectValue("bNick", "NickRequired");
		else if(nick.length()<2 || nick.length()>10)
			errors.rejectValue("bNick", "NickLengthError");
	}
}

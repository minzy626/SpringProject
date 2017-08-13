package com.javalec.ex.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javalec.ex.dto.UserDto;

public class FindPassValidator implements Validator { //ºñ¹Ğ¹øÈ£ Ã£±â È­¸é¿¡¼­ ÀÌ¸ŞÀÏ°ú ¾ÆÀÌµğ°¡ Á¦´ë·Î ÀÔ·Â ‰ç´ÂÁö °ËÁõÇÏ´Â Å¬·¡½º

	private Pattern pattern;
	private Matcher matcher;
	String regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"; //ÀÌ¸ŞÀÏ Á¤±Ô Ç¥Çö½Ä
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
		if(id == null || id.trim().isEmpty())
			errors.rejectValue("bId", "IdRequired");
		else if(id.length()<5 || id.length()>15 || id.matches(".*[¤¡-¤¾¤¿-¤Ó°¡-ÆR]+.*"))
			errors.rejectValue("bId", "IdLengthError");
		
		//ÀÌ¸ŞÀÏÀÌ ¿Ã¹Ù¸¥ Çü½ÄÀÎÁö °Ë»ç
		matcher = pattern.matcher(userDto.getbId());
		if(userDto.getbId() == null || userDto.getbId().trim().isEmpty())
			errors.rejectValue("bId", "IdRequired");
		else if(!matcher.matches()) //»ç¿ëÀÚ°¡ ÀÔ·ÂÇÑ ÀÌ¸ŞÀÏÀÌ Á¤±ÔÇ¥Çö½Ä¿¡ ¸ÅÄ¡ µÇÁö¾Ê´Â´Ù¸é
			errors.rejectValue("bId", "bad");
			
		
	}

}

package com.javalec.ex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BDao {
	JdbcTemplate template;
	
	@Autowired //Autowired 해놓으면 스프링 설정파일에서 Jdbc 템플릿 빈 생성시 자동으로 BController에있는 template에 맵핑 시켜줌.
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
}

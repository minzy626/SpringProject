package com.javalec.ex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BDao {
	JdbcTemplate template;
	
	@Autowired //Autowired �س����� ������ �������Ͽ��� Jdbc ���ø� �� ������ �ڵ����� BController���ִ� template�� ���� ������.
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
}

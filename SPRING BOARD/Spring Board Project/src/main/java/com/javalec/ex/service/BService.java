package com.javalec.ex.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dto.BDto;

public interface BService {
	void execute(SqlSession sqlsession,Model model);
}

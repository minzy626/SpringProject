package com.javalec.ex.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.javalec.ex.dto.BDto;

public interface BCommand {
	void execute(SqlSession sqlsession,Model model);
}

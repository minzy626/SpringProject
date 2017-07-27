package com.javalec.ex.command;


import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BCommand {
	void execute(SqlSession sqlsession, Model model);
}

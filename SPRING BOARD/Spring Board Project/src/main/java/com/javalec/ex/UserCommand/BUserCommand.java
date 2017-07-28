package com.javalec.ex.UserCommand;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BUserCommand {
	void execute(SqlSession sqlsession,Model model);
}

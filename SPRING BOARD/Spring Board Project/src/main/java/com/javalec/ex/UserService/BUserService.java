package com.javalec.ex.UserService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BUserService {
	void execute(SqlSession sqlsession,Model model);
	
}

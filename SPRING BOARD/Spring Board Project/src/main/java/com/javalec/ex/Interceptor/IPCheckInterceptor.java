package com.javalec.ex.Interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.ex.dao.UserDao;
import com.javalec.ex.dao.UserDaoImpl;

public class IPCheckInterceptor implements HandlerInterceptor {
	private static final Logger logger = Logger.getLogger(IPCheckInterceptor.class);
	@Autowired
	UserDaoImpl dao;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		logger.info("client ip " + req.getRemoteAddr());
		List<String> list = dao.find_ip_ban_list(); //���� IP�� ���� ����� IP�� �����´�.
		for(String li : list)
		{
			logger.info("ban ip " + li);
			if(req.getRemoteAddr().matches(li))
			{
				 res.setContentType("text/html; charset=UTF-8");
			      PrintWriter out = res.getWriter();
			      out.println("<script>alert('���� ������ ���ۼ��� �Ϸ絿�� ���ѵ˴ϴ�.');history.go(-1);</script>");
			      out.flush();
				return false;
			}
		}
		return true;
	}

}

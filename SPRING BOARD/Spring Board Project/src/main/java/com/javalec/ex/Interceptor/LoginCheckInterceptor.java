package com.javalec.ex.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.javalec.ex.dto.UserDto;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false); //false로 하면 세션 없으면 그냥 null되고 true일때는 세션이 없으면 세션을 생성함.

		if(session == null)
		{
			response.sendRedirect(request.getContextPath()+"/login_view");
			return false;
		}
		else
		{
			UserDto userDto = (UserDto) session.getAttribute("userinfo");
			if(userDto == null)
			{
				response.sendRedirect(request.getContextPath()+"/login_view");
				return false;
			}
		}
		
		
		return true;
	}

}

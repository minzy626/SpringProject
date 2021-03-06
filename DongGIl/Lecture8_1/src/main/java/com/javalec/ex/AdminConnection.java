package com.javalec.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean{

	private Environment env;
	private String adminId;
	private String adminPw;
	
	public void setEnv(Environment env) {
		this.env = env;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	public Environment getEnv() {
		return env;
	}

	public String getAdminId() {
		return adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSEt()");
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}

	@Override
	public void setEnvironment(Environment env) {
		// TODO Auto-generated method stub
		System.out.println("setEnvironment");
		setEnv(env);
	}
}

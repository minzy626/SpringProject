package com.javalec.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean{

	private Environment env;
	private String adminId;
	private String adminPw;
	private String sub_adminId;
	private String sub_adminPw;
	
	public String getSub_adminId() {
		return sub_adminId;
	}

	public void setSub_adminId(String sub_adminId) {
		this.sub_adminId = sub_adminId;
	}

	public String getSub_adminPw() {
		return sub_adminPw;
	}

	public void setSub_adminPw(String sub_adminPw) {
		this.sub_adminPw = sub_adminPw;
	}

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
	}

	@Override
	public void setEnvironment(Environment env) {
		// TODO Auto-generated method stub
		System.out.println("setEnvironment");
		setEnv(env);
	}
}
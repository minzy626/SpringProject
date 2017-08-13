package com.javalec.ex.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private String bId;
	private String bPass;
	private String bNick;
	private String bGender;
	private String bSchool;
	private int bGrade;
	private String bMajor;
	private String bRegion;
	private boolean enabled;
	
	
	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbPass() {
		return bPass;
	}

	public void setbPass(String bPass) {
		this.bPass = bPass;
	}

	public String getbNick() {
		return bNick;
	}

	public void setbNick(String bNick) {
		this.bNick = bNick;
	}

	public String getbGender() {
		return bGender;
	}

	public void setbGender(String bGender) {
		this.bGender = bGender;
	}

	public String getbSchool() {
		return bSchool;
	}

	public void setbSchool(String bSchool) {
		this.bSchool = bSchool;
	}

	public int getbGrade() {
		return bGrade;
	}

	public void setbGrade(int bGrade) {
		this.bGrade = bGrade;
	}

	public String getbMajor() {
		return bMajor;
	}

	public void setbMajor(String bMajor) {
		this.bMajor = bMajor;
	}

	public String getbRegion() {
		return bRegion;
	}

	public void setbRegion(String bRegion) {
		this.bRegion = bRegion;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER")); //회원가입한 사람은 누구나 ROLE_USER 권한을 갖는다.
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return bPass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return bId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auo-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

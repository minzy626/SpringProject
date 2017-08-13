package com.javalec.ex.dto;
public class UserDto {
	
	String bId;
	String bPass;
	String bNick;
	String bGender;
	String bSchool;
	int bGrade;
	String bMajor;
	String bRegion;
	
	public UserDto() {
	
	}
	
	public UserDto(String bId, String bPass, String bNick, String bGender, String bSchool, int bGrade, String bMajor,
			 String bRegion) {
		super();
		this.bId = bId;
		this.bPass = bPass;
		this.bNick = bNick;
		this.bGender = bGender;
		this.bSchool = bSchool;
		this.bGrade = bGrade;
		this.bMajor = bMajor;
		this.bRegion = bRegion;
	}

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
	
}

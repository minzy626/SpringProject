package com.javalec.ex.dto;

import java.sql.Timestamp;

public class CDto {
	int cId;
	int cBoardNum;
	String cNick;
	String cContent;
	Timestamp cDate;
	public CDto() {
		
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getcBoardNum() {
		return cBoardNum;
	}
	public void setcBoardNum(int cBoardNum) {
		this.cBoardNum = cBoardNum;
	}
	public String getcNick() {
		return cNick;
	}
	public void setcNick(String cNick) {
		this.cNick = cNick;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public Timestamp getcDate() {
		return cDate;
	}
	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}
	
	
}
package com.javalec.ex.dto;

import java.sql.Timestamp;

public class CDto {
	int cId;
	int cBoardNum;
	String cNick;
	String cContent;
	String cImage;
	public String getcImage() {
		return cImage;
	}

	public void setcImage(String cImage) {
		this.cImage = cImage;
	}
	Timestamp cDate;
	boolean cIsSeen;
	public boolean iscIsSeen() {
		return cIsSeen;
	}

	public void setcIsSeen(boolean cIsSeen) {
		this.cIsSeen = cIsSeen;
	}

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
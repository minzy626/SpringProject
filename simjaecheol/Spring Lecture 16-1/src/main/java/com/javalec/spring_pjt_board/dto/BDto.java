package com.javalec.spring_pjt_board.dto;

import java.sql.Timestamp;

public class BDto { //데이터 베이스로 부터 꺼내온 정보를 저장하는 객체(커맨더 객체랑 유사)
	int bId;
	String bName;
	String bTitle;
	Timestamp bDate;
	int bHit;
	int bGroup;
	int bStep;
	int bIndent;
	
	
	public BDto(int bId,String bName, String bTitle,Timestamp bDate,int bHit,int bGroup, int bStep, int bIndent) {
		// TODO Auto-generated constructor stub
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}


	public int getBid() {
		return bId;
	}


	public void setBid(int bid) {
		this.bId = bid;
	}


	public String getbName() {
		return bName;
	}


	public void setbName(String bName) {
		this.bName = bName;
	}


	public String getbTitle() {
		return bTitle;
	}


	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}


	public Timestamp getbDate() {
		return bDate;
	}


	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}


	public int getbHit() {
		return bHit;
	}


	public void setbHit(int bHit) {
		this.bHit = bHit;
	}


	public int getbGroup() {
		return bGroup;
	}


	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}


	public int getbStep() {
		return bStep;
	}


	public void setbStep(int bStep) {
		this.bStep = bStep;
	}


	public int getbIndent() {
		return bIndent;
	}


	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
	
}

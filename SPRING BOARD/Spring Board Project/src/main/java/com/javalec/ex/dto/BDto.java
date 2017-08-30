package com.javalec.ex.dto;

import java.sql.Timestamp;

public class BDto {

	int bId;
	String bName;
	String bTitle;
	String bContent;
	String bRegionGroup;
	String bCategory;
	String bNotice;
	String bYyMmDd;
	Timestamp bDate;
	int bHit;
	
	public BDto() {
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
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

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		bYyMmDd = bDate.toString();
		bYyMmDd = bYyMmDd.substring(0, 10);
		this.bDate = bDate;
	}

	public String getbYyMmDd() {
		return bYyMmDd;
	}

	public void setYyMmDd(String bYyMmDd) {
		setbDate(bDate);
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public String getbRegionGroup() {
		return bRegionGroup;
	}

	public void setbRegionGroup(String bRegionGroup) {
		this.bRegionGroup = bRegionGroup;
	}

	public String getbCategory() {
		return bCategory;
	}

	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}

	public String getbNotice() {
		return bNotice;
	}

	public void setbNotice(String bNotice) {
		this.bNotice = bNotice;
	}
	
}

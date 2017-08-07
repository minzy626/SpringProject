package com.javalec.ex.dto;

public class SearchingPageDto extends BSearchDto{

	
	private String bSearchType;	// 검색 타입
	private String bSearchMType; // 모임 분류 타입
	private String bSearchRType; // 지역 분류 타입
	private String bKeyword;	// 검색 키워드
	
	
	public String getbSearchType() {
		return bSearchType;
	}



	public void setbSearchType(String bSearchType) {
		this.bSearchType = bSearchType;
	}



	public String getbKeyword() {
		return bKeyword;
	}



	public void setbKeyword(String bKeyword) {
		this.bKeyword = bKeyword;
	}



	public String getbSearchMType() {
		return bSearchMType;
	}



	public void setbSearchMType(String bSearchMType) {
		this.bSearchMType = bSearchMType;
	}



	public String getbSearchRType() {
		return bSearchRType;
	}



	public void setbSearchRType(String bSearchRType) {
		this.bSearchRType = bSearchRType;
	}



	@Override
	public String toString() {
		return "SearchingPageDto [bSearchType=" + bSearchType + ", bKeyword=" + bKeyword + "]";
	}
}

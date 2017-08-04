package com.javalec.ex.dto;

public class SearchingPageDto extends BSearchDto{

	
	private String bSearchType;	// 검색 타입
	private String bKeyword;		// 검색 키워드
	
	
	
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



	@Override
	public String toString() {
		return "SearchingPageDto [bSearchType=" + bSearchType + ", bKeyword=" + bKeyword + "]";
	}
}

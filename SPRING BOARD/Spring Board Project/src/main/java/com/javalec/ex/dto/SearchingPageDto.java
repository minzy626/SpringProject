package com.javalec.ex.dto;

public class SearchingPageDto extends BSearchDto{

	
	private String bSearchType;	// �˻� Ÿ��
	private String bSearchMType; // ���� �з� Ÿ��
	private String bSearchRType; // ���� �з� Ÿ��
	private String bKeyword;	// �˻� Ű����
	
	
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

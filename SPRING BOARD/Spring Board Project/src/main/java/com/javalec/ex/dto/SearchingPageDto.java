package com.javalec.ex.dto;

public class SearchingPageDto extends BSearchDto{

	
	private String bSearchType;	// �˻� Ÿ��
	private String bMeetingGroup; // ���� �з� Ÿ��
	private String bSearchRType; // ���� �з� Ÿ��
	private String bKeyword;	// �˻� Ű����
	private String bStudyGroup;
	private String bCategory;
	
	
	public String getbStudyGroup() {
		return bStudyGroup;
	}



	public void setbStudyGroup(String bStudyGroup) {
		this.bStudyGroup = bStudyGroup;
	}



	public String getbCategory() {
		return bCategory;
	}



	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}



	public void setbMeetingGroup(String bMeetingGroup) {
		this.bMeetingGroup = bMeetingGroup;
	}



	public String getbMeetingGroup() {
		return bMeetingGroup;
	}



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

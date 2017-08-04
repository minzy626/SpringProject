package com.javalec.ex.dto;

public class BSearchDto {

	private Integer bPage;
	private Integer bPerPageNum;
	
	public BSearchDto() {
		// TODO Auto-generated constructor stub
		
		this.bPage = 1;
		this.bPerPageNum = 10;
	}

	public Integer getbPage() {
		return bPage;
	}


	public void setbPage(Integer bPage) {
		this.bPage = (bPage < 1) ? 1 :  bPage; 
	}


	public Integer getbPerPageNum() {
		return bPerPageNum;
	}


	public void setbPerPageNum(Integer bPerPageNum) {
		// bPerPageNum을 10 미만 또는 100이상일 경우 10으로 고정.		
				this.bPerPageNum = (bPerPageNum <10 || bPerPageNum >=100) ? 10 : bPerPageNum;
	}

	public int getbPageStart(){

		return (this.bPage-1) * 10 ;
	}
}

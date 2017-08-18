package com.javalec.ex.dto;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class BPageDto {

	private BSearchDto sdto; // bPage, bPerPageNum

	private Integer totalCount; // 총 게시물 수

	private Integer bStartPage; // 시작 페이지
	private Integer endPage; // 끝 페이지
	private boolean prev;
	private boolean next;

	private Integer displayPageNum = 10; // 페이지 보여줄 갯수 10개로 설정

	// 리스트 페이지에서 단일 게시글 클릭하면 페이지, 검색 정보를 가지고 URI문자열을 만들어서 조회페이지로 이동한다.
	// 그러면 조회페이지에서 페이징, 검색정보를 유지하고 있기 때문에 다시 리스트 페이지로 이동할 때 원래 page와 검색 조건의 리스트로 이동할
	// 수 있다
	public String makeSearch(Integer bPage) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("bPage", bPage)
				.queryParam("bPerPageNum", sdto.getbPerPageNum())
				.queryParam("bSearchType", ((SearchingPageDto) sdto).getbSearchType())
				.queryParam("bMeetingGroup", ((SearchingPageDto) sdto).getbMeetingGroup())
				.queryParam("bCategory", ((SearchingPageDto) sdto).getbCategory())
				.queryParam("bStudyGroup", ((SearchingPageDto) sdto).getbStudyGroup())
				.queryParam("bSearchRType", ((SearchingPageDto) sdto).getbSearchRType())
				.queryParam("bKeyword", ((SearchingPageDto) sdto).getbKeyword()).build();

		return uriComponents.toUriString();
	}

	// 리스트페이지에서 단일 게시글 클릭하면 해당 page정보를 가지고 page, perPageNum 파라미터를 포함한 URI 문자열을 만들어서
	// 조회페이지로
	// 이동한다. 그러면 조회페이지에서 page, perPageNum, bId 값을 유지하고 있기 때문에 다시 리스트 페이지로 이동할때 원래
	// page로 이동할 수 있다.
	public String makeQuery(Integer bPage) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("bPage", bPage)
				.queryParam("bPerPageNum", sdto.getbPerPageNum()).build();

		return uriComponents.toUriString();
	}

	public BSearchDto getSdto() {
		return sdto;
	}

	public void setSdto(BSearchDto sdto) {
		this.sdto = sdto;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;

		calculData();
	}

	private void calculData() {

		// 끝 페이지
		endPage = (int) Math.ceil((double) sdto.getbPage() / displayPageNum) * displayPageNum;

		// 시작 페이지
		bStartPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) Math.ceil((double) totalCount / displayPageNum);

		// 끝 페이지 검증
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		} // if()

		prev = (bStartPage == 1 ? false : true);
		next = (tempEndPage > endPage ? true : false);

	}

	public Integer getbStartPage() {
		return bStartPage;
	}

	public void setStartPage(Integer bStartPage) {
		this.bStartPage = bStartPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Integer getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(Integer displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

}

package com.javalec.ex.dto;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class BPageDto {

	private BSearchDto sdto; // bPage, bPerPageNum

	private Integer totalCount; // �� �Խù� ��

	private Integer bStartPage; // ���� ������
	private Integer endPage; // �� ������
	private boolean prev;
	private boolean next;

	private Integer displayPageNum = 10; // ������ ������ ���� 10���� ����

	// ����Ʈ ���������� ���� �Խñ� Ŭ���ϸ� ������, �˻� ������ ������ URI���ڿ��� ���� ��ȸ�������� �̵��Ѵ�.
	// �׷��� ��ȸ���������� ����¡, �˻������� �����ϰ� �ֱ� ������ �ٽ� ����Ʈ �������� �̵��� �� ���� page�� �˻� ������ ����Ʈ�� �̵���
	// �� �ִ�
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

	// ����Ʈ���������� ���� �Խñ� Ŭ���ϸ� �ش� page������ ������ page, perPageNum �Ķ���͸� ������ URI ���ڿ��� ����
	// ��ȸ��������
	// �̵��Ѵ�. �׷��� ��ȸ���������� page, perPageNum, bId ���� �����ϰ� �ֱ� ������ �ٽ� ����Ʈ �������� �̵��Ҷ� ����
	// page�� �̵��� �� �ִ�.
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

		// �� ������
		endPage = (int) Math.ceil((double) sdto.getbPage() / displayPageNum) * displayPageNum;

		// ���� ������
		bStartPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) Math.ceil((double) totalCount / displayPageNum);

		// �� ������ ����
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

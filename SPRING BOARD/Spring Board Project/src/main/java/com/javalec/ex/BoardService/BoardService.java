package com.javalec.ex.BoardService;

import java.util.List;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BSearchDto;
import com.javalec.ex.dto.SearchingPageDto;

public interface BoardService {

	public BDto read(Integer bno);
	
	// cBoardNum에 해당하는 bTitle가져오기 query
	public String getBTitleFromBId(Integer cBoardNum);
	
	public void update(BDto dto);
	
	public void write(BDto dto);
	// 공지사항 조회
	public List<BDto> listNotice();
	
	// 게시물( 모든 게시물 조회 )
	public List<BDto> listAll();

	// 게시물 ( 페이징 처리 게시물 조회)
	public List<BDto> listCriteria(BSearchDto sdto);

	// 총 게시물 수 계산
	public Integer boardTotalCount();

	// 게시물 ( 페이징 처리 + 검색결과 게시물 조회)
	public List<BDto> listSearchCriteria(SearchingPageDto spdto);

	// 총 검색 결과 게시물 수 계산
	public Integer searchBoardTotalCount(SearchingPageDto spdto);

	// 글 삭제하기
	public void delete(Integer bId);
	
	// 조회수 늘리기
	public void upHit(Integer bId);
	
	//하루 개인 게시물 수 계산
	public Integer writeCount(BDto dto);
}

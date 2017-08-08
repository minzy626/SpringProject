package com.javalec.ex.BoardService;

import java.util.List;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BSearchDto;
import com.javalec.ex.dto.SearchingPageDto;

public interface BoardService {

	public BDto read(Integer bno);
	
	public void update(BDto dto);
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
}

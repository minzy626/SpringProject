package com.javalec.ex.dao;

import java.util.List;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BSearchDto;
import com.javalec.ex.dto.SearchingPageDto;

public interface BoardDao {
	// 게시물 삭제
	public void delete(Integer bId);
	// 조회수 ++
	public void upHit(Integer bId);
	// 게시물 등록(새글쓰기)
	public void write(BDto dto);
	// 게시물 조회(bId에 해당하는 단일 게시물 조회)
	public BDto read(Integer bId);
	// cBoardNum에 해당하는 bTitle가져오기 query
	public String getBTitleFromBId(Integer cBoardNum);
	// 게시물 업데이트
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

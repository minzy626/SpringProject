package com.javalec.ex.dao;

import java.util.ArrayList;
import java.util.List;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BSearchDto;
import com.javalec.ex.dto.SearchingPageDto;

public interface IDao {
	public ArrayList<BDto> list();

	public BDto contentView(String bId);

	public void modify(BDto dto);

	public void delete(String bId);

	public BDto read(Integer bno);

	public void write(BDto dto);

	public void upHit(String bId);

	// 게시물 업데이트
	public void update(BDto dto);

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

package com.javalec.ex.BoardService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.ex.dao.BoardDao;
import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BSearchDto;
import com.javalec.ex.dto.SearchingPageDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDao dao;
	
	@Override
	public void update(BDto dto) {
		// TODO Auto-generated method stub
		dao.update(dto);
	}

	@Override
	public List<BDto> listCriteria(BSearchDto sdto) {
		// TODO Auto-generated method stub
		return dao.listCriteria(sdto);
	}

	@Override
	public List<BDto> listSearchCriteria(SearchingPageDto spdto) {
		// TODO Auto-generated method stub
		return dao.listSearchCriteria(spdto);
	}

	@Override
	public Integer searchBoardTotalCount(SearchingPageDto spdto) {
		// TODO Auto-generated method stub
		return dao.searchBoardTotalCount(spdto);
	}

	@Override
	public List<BDto> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public Integer boardTotalCount() {
		// TODO Auto-generated method stub
		return dao.boardTotalCount();
	}

	@Override
	public BDto read(Integer bId) {
		// TODO Auto-generated method stub
		return dao.read(bId);
	}

	@Override
	public List<BDto> listNotice() {
		// TODO Auto-generated method stub
		return dao.listNotice();
	}
	
	@Override
	public void delete(Integer bId) {
		// TODO Auto-generated method stub
		dao.delete(bId);
	}
	
	@Override
	public void upHit(Integer bId) {
		dao.upHit(bId);
	}
}

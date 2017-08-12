package com.javalec.ex.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BSearchDto;
import com.javalec.ex.dto.SearchingPageDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.javalec.ex.dao.mapper.IDao";
	public BoardDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(BDto dto) {
		// TODO Auto-generated method stub
		session.update(namespace+".update", dto);
	}

	@Override
	public List<BDto> listNotice() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listNotice");
	}
	
	@Override
	public List<BDto> listAll() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BDto> listCriteria(BSearchDto sdto) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listCriteria", sdto);
	}

	@Override
	public Integer boardTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".boardTotalCount");
	}

	@Override
	public List<BDto> listSearchCriteria(SearchingPageDto spdto) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listSearchCriteria", spdto);
	}

	@Override
	public Integer searchBoardTotalCount(SearchingPageDto spdto) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".searchBoardTotalCount", spdto);
	}

	@Override
	public BDto read(Integer bId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", bId);
	}

	@Override
	public void delete(Integer bId) {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", bId);
	}
	@Override
	public void upHit(Integer bId) {
		session.selectOne(namespace+".upHit", bId);
	}
}

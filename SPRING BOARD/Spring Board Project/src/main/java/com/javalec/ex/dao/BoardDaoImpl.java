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
	public void write(BDto dto) {
		session.insert(namespace+".write", dto);
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
	// cBoardNum에 해당하는 bTitle가져오기 query
	public String getBTitleFromBId(Integer cBoardNum) {
		return session.selectOne(namespace+".getBTitleFromBId", cBoardNum);
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
	
	@Override
	public Integer writeCount(BDto dto) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".writeCount", dto);
	}
}

package com.javalec.ex.BoardService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.ex.dao.CommentDao;
import com.javalec.ex.dto.CDto;

@Service
public class CommentServiceImpl implements CommentService {

	@Inject
	CommentDao cdao;
	
	@Override
	public void cWrite(CDto cdto) {
		// TODO Auto-generated method stub
		cdao.cWrite(cdto);
	}

	@Override
	public void cUpdate(CDto cdto) {
		// TODO Auto-generated method stub
		cdao.cUpdate(cdto);
	}

	@Override
	public void cDelete(Integer cId) {
		// TODO Auto-generated method stub
		cdao.cDelete(cId);
	}

	@Override
	public List<CDto> cListAll(Integer bId) {
		// TODO Auto-generated method stub
		return cdao.cListAll(bId);
	}

}

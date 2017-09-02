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
	
	@Override
	// 댓글 읽음 처리(게시물 작성자가 자신의 게시물 읽은 경우)
	public void isSeenToTrue(Integer cBoardNum) {
		cdao.isSeenToTrue(cBoardNum);
	}

	@Override
	// 아직 읽지않은 댓글 수 가져오기(새로운 댓글 알람용)
	public int cGetNewCommentCount(String bName) {
		// TODO Auto-generated method stub
		return cdao.cGetNewCommentCount(bName);
	}
	
	@Override
	// 아직 읽지않은 댓글의 cDto객체를 가져오기(알림 상세내용 보여주기용)
	public List<CDto> cGetNewCommentDetails(String bName){
		return cdao.cGetNewCommentDetails(bName);
	}
	
	@Override
	// 접속중인 사용자의 모든 알림을 읽음처리
	public void cReadAllComments(String bName) {
		cdao.cReadAllComments(bName);
	}
}

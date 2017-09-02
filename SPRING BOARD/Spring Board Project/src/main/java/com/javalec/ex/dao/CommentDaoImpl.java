package com.javalec.ex.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.ex.dto.CDto;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Inject
	private SqlSession session;
	private static final String namespace="com.javalec.ex.dao.mapper.IDao";
	
	
	@Override
	public void cWrite(CDto cdto) {
		// TODO Auto-generated method stub
		session.insert(namespace+".cWrite", cdto);
	}


	@Override
	public void cUpdate(CDto cdto) {
		// TODO Auto-generated method stub
		session.update(namespace+".cUpdate", cdto);
	}


	@Override
	public void cDelete(Integer cId) {
		// TODO Auto-generated method stub
		session.delete(namespace+".cDelete", cId);
	}


	@Override
	public List<CDto> cListAll(Integer bId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".cListAll", bId);
	}
	
	@Override
	// 댓글 읽음 처리(게시물 작성자가 자신의 게시물 읽은 경우)
	public void isSeenToTrue(Integer cBoardNum) {
		session.update(namespace+".isSeenToTrue", cBoardNum);
	}
	
	@Override
	// 아직 읽지않은 댓글 수 가져오기(새로운 댓글 알람용)
	public int cGetNewCommentCount(String bName) {
		return session.selectOne(namespace+".cGetNewCommentCount", bName);
	}
	
	@Override
	// 아직 읽지않은 댓글의 cDto객체를 가져오기(알림 상세내용 보여주기용)
	public List<CDto> cGetNewCommentDetails(String bName){
		return session.selectList(namespace+".cGetNewCommentDetails", bName);
	}
	
	@Override
	// 접속중인 사용자의 모든 알림을 읽음처리
	public void cReadAllComments(String bName) {
		session.update(namespace+".cReadAllComments", bName);
	}
}

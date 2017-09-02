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
	// ��� ���� ó��(�Խù� �ۼ��ڰ� �ڽ��� �Խù� ���� ���)
	public void isSeenToTrue(Integer cBoardNum) {
		session.update(namespace+".isSeenToTrue", cBoardNum);
	}
	
	@Override
	// ���� �������� ��� �� ��������(���ο� ��� �˶���)
	public int cGetNewCommentCount(String bName) {
		return session.selectOne(namespace+".cGetNewCommentCount", bName);
	}
	
	@Override
	// ���� �������� ����� cDto��ü�� ��������(�˸� �󼼳��� �����ֱ��)
	public List<CDto> cGetNewCommentDetails(String bName){
		return session.selectList(namespace+".cGetNewCommentDetails", bName);
	}
	
	@Override
	// �������� ������� ��� �˸��� ����ó��
	public void cReadAllComments(String bName) {
		session.update(namespace+".cReadAllComments", bName);
	}
}

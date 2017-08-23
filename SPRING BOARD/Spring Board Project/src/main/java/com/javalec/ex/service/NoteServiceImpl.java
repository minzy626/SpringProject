package com.javalec.ex.service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.javalec.ex.dao.NoteDao;
import com.javalec.ex.dto.NoteDto;

public class NoteServiceImpl implements NoteService {

	@Override
	public List<NoteDto> receivelist(SqlSession sqlsession, String Receiver) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class); //맵퍼.xml과 맵퍼 인터페이스를 맵핑 시킴
		List<NoteDto> list = dao.find_all_by_Receiver(Receiver);
		return list;
	}
	
	@Override
	public List<NoteDto> sendlist(SqlSession sqlsession, String Sender) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class); //맵퍼.xml과 맵퍼 인터페이스를 맵핑 시킴
		List<NoteDto> list = dao.find_all_by_Sender(Sender);
		return list;
	}
	
	@Override
	public void insert(SqlSession sqlsession,NoteDto noteDto) {
		
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.send_insert(noteDto);
		dao.receive_insert(noteDto);
		dao.identify_id(); //발신함 수신함의 각각 동일한 2개의 쪽지의 아이디를 일치시켜줌.
	}

	@Override //보낸쪽지함에 있는 쪽지 내용 출력.
	public NoteDto send_content_view(SqlSession sqlsession,int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		return dao.find_send_by_id(Id);
	}
	
	@Override // 받은쪽지함에 있는 쪽지 내용 출력.
	public NoteDto receive_content_view(SqlSession sqlsession,int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		return dao.find_receive_by_id(Id);
	}
	
	@Override // 보낸 쪽지함에서 삭제하기
	public void send_delete(SqlSession sqlsession,int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_send_by_id(Id);
	}
	
	@Override // 받은 쪽지함에서 삭제하기
	public void receive_delete(SqlSession sqlsession,int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_receive_by_id(Id);
	}
	
	@Override
	public void delete_receive_all(SqlSession sqlsession, String Receiver) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_by_Receiver(Receiver);
	}
	
	@Override
	public void delete_send_all(SqlSession sqlsession, String Sender) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_by_Sender(Sender);
	}
	
	@Override
	public void update_send_check(SqlSession sqlsession, int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.update_send_confirm_by_id(Id);
	}
	
	@Override
	public void update_receive_check(SqlSession sqlsession, int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.update_receive_confirm_by_id(Id);
	}

	
	

}

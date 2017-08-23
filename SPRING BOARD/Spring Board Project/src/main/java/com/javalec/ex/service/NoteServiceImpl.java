package com.javalec.ex.service;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.ex.dao.NoteDao;
import com.javalec.ex.dto.NoteDto;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<NoteDto> receivelist( String Receiver) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class); //����.xml�� ���� �������̽��� ���� ��Ŵ
		List<NoteDto> list = dao.find_all_by_Receiver(Receiver);
		return list;
	}
	
	@Override
	public List<NoteDto> sendlist( String Sender) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class); //����.xml�� ���� �������̽��� ���� ��Ŵ
		List<NoteDto> list = dao.find_all_by_Sender(Sender);
		return list;
	}
	
	@Override
	public void insert(NoteDto noteDto) {
		
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.send_insert(noteDto);
		dao.receive_insert(noteDto);
		dao.identify_id(); //�߽��� �������� ���� ������ 2���� ������ ���̵� ��ġ������.
	}

	@Override //���������Կ� �ִ� ���� ���� ���.
	public NoteDto send_content_view(int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		return dao.find_send_by_id(Id);
	}
	
	@Override // ���������Կ� �ִ� ���� ���� ���.
	public NoteDto receive_content_view(int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		return dao.find_receive_by_id(Id);
	}
	
	@Override // ���� �����Կ��� �����ϱ�
	public void send_delete(int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_send_by_id(Id);
	}
	
	@Override // ���� �����Կ��� �����ϱ�
	public void receive_delete(int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_receive_by_id(Id);
	}
	
	@Override
	public void delete_receive_all( String Receiver) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_by_Receiver(Receiver);
	}
	
	@Override
	public void delete_send_all( String Sender) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_by_Sender(Sender);
	}
	
	@Override
	public void update_send_check( int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.update_send_confirm_by_id(Id);
	}
	
	@Override
	public void update_receive_check( int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.update_receive_confirm_by_id(Id);
	}

	@Override
	public String note_count(String Receiver) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		return dao.count_receive_note(Receiver);
	}

	
	

}

package com.javalec.ex.service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dto.NoteDto;

public interface NoteService {
	List<NoteDto> receivelist(SqlSession sqlsession,String Receiver); //���� ���� ����Ʈ ��������
	List<NoteDto> sendlist(SqlSession sqlsession,String Sender); //���� ���� ����Ʈ ������
	void insert(SqlSession sqlsession,NoteDto noteDto); //���� ������
	NoteDto send_content_view(SqlSession sqlsession,int Id); // ���� ���� ����
	NoteDto receive_content_view(SqlSession sqlsession,int Id);
	void receive_delete(SqlSession sqlsession,int Id); //���� ���� �����ϱ�
	void send_delete(SqlSession sqlsession,int Id); //���� ���� �����ϱ�
	void delete_receive_all(SqlSession sqlsession,String Receiver);//���� ������ ��ü ���� 
	void delete_send_all(SqlSession sqlsession,String Sender);//���� ������ ��ü ���� 
	void update_send_check(SqlSession sqlsession,int Id); // ���������Կ��� ������ -> ���� ���� ������Ʈ
	void update_receive_check(SqlSession sqlsession,int Id); // ���������Կ��� ������ -> ���� ���� ������Ʈ
	
}

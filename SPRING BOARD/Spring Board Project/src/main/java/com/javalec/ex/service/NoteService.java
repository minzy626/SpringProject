package com.javalec.ex.service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dto.NoteDto;

public interface NoteService {
	List<NoteDto> receivelist(String Receiver); //���� ���� ����Ʈ ��������
	List<NoteDto> sendlist(String Sender); //���� ���� ����Ʈ ������
	void insert(NoteDto noteDto); //���� ������
	NoteDto send_content_view(int Id); // ���� ���� ����
	NoteDto receive_content_view(int Id);
	void receive_delete(int Id); //���� ���� �����ϱ�
	void send_delete(int Id); //���� ���� �����ϱ�
	void delete_receive_all(String Receiver);//���� ������ ��ü ���� 
	void delete_send_all(String Sender);//���� ������ ��ü ���� 
	void update_send_check(int Id); // ���������Կ��� ������ -> ���� ���� ������Ʈ
	void update_receive_check(int Id); // ���������Կ��� ������ -> ���� ���� ������Ʈ
	String note_count(String Receiver); //�����ڿ��� �� �޽��� ���� ��.
	
}

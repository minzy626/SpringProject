package com.javalec.ex.service;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dto.NoteDto;

public interface NoteService {
	List<NoteDto> receivelist(SqlSession sqlsession,String Receiver); //���� ���� ����Ʈ ��������
	void insert(SqlSession sqlsession,NoteDto noteDto); //���� ������
	NoteDto content_view(SqlSession sqlsession,int Id); // ���� ���� ���� 
	void delete(SqlSession sqlsession,int Id);
}

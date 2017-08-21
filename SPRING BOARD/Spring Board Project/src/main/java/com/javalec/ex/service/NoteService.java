package com.javalec.ex.service;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dto.NoteDto;

public interface NoteService {
	List<NoteDto> receivelist(SqlSession sqlsession,String Receiver); //받은 쪽지 리스트 가져오기
	void insert(SqlSession sqlsession,NoteDto noteDto); //쪽지 보내기
	NoteDto content_view(SqlSession sqlsession,int Id); // 쪽지 내용 보기 
	void delete(SqlSession sqlsession,int Id);
}

package com.javalec.ex.service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.dto.NoteDto;

public interface NoteService {
	List<NoteDto> receivelist(String Receiver); //받은 쪽지 리스트 가져오기
	List<NoteDto> sendlist(String Sender); //보낸 쪽지 리스트 가져오
	void insert(NoteDto noteDto); //쪽지 보내기
	NoteDto send_content_view(int Id); // 쪽지 내용 보기
	NoteDto receive_content_view(int Id);
	void receive_delete(int Id); //받은 쪽지 삭제하기
	void send_delete(int Id); //보낸 쪽지 삭제하기
	void delete_receive_all(String Receiver);//받은 쪽지함 전체 삭제 
	void delete_send_all(String Sender);//보낸 쪽지함 전체 삭제 
	void update_send_check(int Id); // 보낸쪽지함에서 안읽음 -> 읽음 으로 업데이트
	void update_receive_check(int Id); // 받은쪽지함에서 안읽음 -> 읽음 으로 업데이트
	String note_count(String Receiver); //수신자에게 온 메시지 개수 셈.
	
}

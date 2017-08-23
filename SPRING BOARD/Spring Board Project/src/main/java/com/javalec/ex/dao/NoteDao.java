package com.javalec.ex.dao;

import java.util.List;

import com.javalec.ex.dto.NoteDto;

public interface NoteDao {
	public List<NoteDto> find_all_by_Receiver(String Receiver);
	public List<NoteDto> find_all_by_Sender(String Sender); //보낸사람이 Sender인것을 모두 찾아옴.
	public void send_insert(NoteDto noteDto);
	public void receive_insert(NoteDto noteDto);
	public NoteDto find_send_by_id(int Id);
	public NoteDto find_receive_by_id(int Id);
	public void delete_send_by_id(int Id);
	public void delete_receive_by_id(int Id);
	public void delete_by_Receiver(String Receiver);
	public void delete_by_Sender(String Sender);
	public void update_send_confirm_by_id(int Id);
	public void update_receive_confirm_by_id(int Id);
	public void identify_id();
}

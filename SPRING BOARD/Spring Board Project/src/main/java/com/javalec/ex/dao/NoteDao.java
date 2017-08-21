package com.javalec.ex.dao;

import java.util.List;

import com.javalec.ex.dto.NoteDto;

public interface NoteDao {
	public List<NoteDto> find_all_by_Receiver(String Receiver);
	public void insert(NoteDto noteDto);
	public NoteDto find_by_id(int Id);
	public void delete_by_id(int Id);
}

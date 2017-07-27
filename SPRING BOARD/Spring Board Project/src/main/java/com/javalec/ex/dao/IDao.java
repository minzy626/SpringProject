package com.javalec.ex.dao;

import java.util.ArrayList;

import com.javalec.ex.dto.BDto;

public interface IDao {
	public ArrayList<BDto> list();
	public BDto contentView(String bId);
	public BDto reply_view(String bId);
	public void reply( String bName,  String bTitle,  String bContent,  int bGroup,  int bStep,  int bIndent);
	public void replyShape( String strGroup,  String strStep);
	public void modify( String bName, String bTitle, String bContent, String bId);
	public void delete( String bId);
	public void write( String bName, String bTitle,  String bContent, int bHit, int bStep, int bIndent);
	public void upHit( String bId);
}


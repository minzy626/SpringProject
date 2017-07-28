package com.javalec.ex.dao;

import java.util.ArrayList;

import com.javalec.ex.dto.BDto;

public interface IDao {
	public ArrayList<BDto> list();
	public BDto contentView(String bId);
	public void modify(BDto dto);
	public void delete( String bId);
	public void write( BDto dto);
	public void upHit( String bId);
}


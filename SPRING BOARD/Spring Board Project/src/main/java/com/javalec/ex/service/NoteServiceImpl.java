package com.javalec.ex.service;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.javalec.ex.dao.NoteDao;
import com.javalec.ex.dto.NoteDto;

public class NoteServiceImpl implements NoteService {

	@Override
	public List<NoteDto> receivelist(SqlSession sqlsession, String Receiver) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class); //∏ ∆€.xml∞˙ ∏ ∆€ ¿Œ≈Õ∆‰¿ÃΩ∫∏¶ ∏ «Œ Ω√≈¥
		List<NoteDto> list = dao.find_all_by_Receiver(Receiver);
		return list;
	}

	@Override
	public void insert(SqlSession sqlsession,NoteDto noteDto) {
		
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.insert(noteDto);
	}

	@Override
	public NoteDto content_view(SqlSession sqlsession,int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		return dao.find_by_id(Id);
	}

	@Override
	public void delete(SqlSession sqlsession,int Id) {
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		dao.delete_by_id(Id);
	}

}

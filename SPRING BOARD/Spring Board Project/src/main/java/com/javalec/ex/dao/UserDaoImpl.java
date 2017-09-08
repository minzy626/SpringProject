package com.javalec.ex.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.ex.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.javalec.ex.dao.mapper.UserDao";
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void register(UserDto dto) {
		// TODO Auto-generated method stub
		session.insert(namespace+".register", dto);
	}

	@Override
	public UserDto find_by_id(UserDto dto) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".find_by_id", dto);
	}

	@Override
	public UserDto find_by_string_id(String bId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".find_by_string_id", bId);
	}

	@Override
	public UserDto find_by_nick(UserDto dto) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".find_by_nick", dto);
	}

	@Override
	public void update_pass_by_id(UserDto dto) {
		// TODO Auto-generated method stub
		session.update(namespace+".update_pass_by_id", dto);
	}

	@Override
	public void user_modify_pass(UserDto dto) {
		// TODO Auto-generated method stub
		session.update(namespace+".user_modify_pass", dto);
	}

	@Override
	public void user_modify(UserDto dto) {
		// TODO Auto-generated method stub
		session.update(namespace+".user_modify", dto);
	}

	@Override
	public void drop_by_id(UserDto dto) {
		// TODO Auto-generated method stub
		session.delete(namespace+".drop_by_id", dto);
	}

	@Override
	public List<String> find_ip_ban_list() {

		return session.selectList(namespace+".find_ip_ban_list");
	}

	@Override
	public void insert_ip_ban(String ip) {
		session.insert(namespace+".insert_ip_ban",ip);
	}

	@Override
	public void insert_dropuser(UserDto dto) {
		session.insert(namespace+".insert_dropuser", dto);
	}
	
	@Override
	public String select_dropuser(UserDto dto) {
		return session.selectOne(namespace+".select_dropuser", dto);
	}
}

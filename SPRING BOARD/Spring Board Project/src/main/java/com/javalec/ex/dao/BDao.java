package com.javalec.ex.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.ui.Model;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.util.Constant;

public class BDao {
	JdbcTemplate template;
	public BDao() {
		template = Constant.template;
	}
	
	public ArrayList<BDto> list()
	{
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public BDto contentView(String bId)
	{
		upHit(bId);
		String query = "select * from mvc_board where bId = " + bId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public BDto reply_view(final String bId)
	{
		String query = "select * from mvc_board where bId = " + bId;
		return template.queryForObject(query,new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void reply(final String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent) {
		// TODO Auto-generated method stub
		
		replyShape(bGroup, bStep);
		
		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (last_insert_id(), ?, ?, ?, ?, ?, ?)";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
		
	}
	
	private void replyShape(final String strGroup, final String strStep) {
		// TODO Auto-generated method stub
		
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, strGroup);
				ps.setString(2, strStep);
			}
		});
	}
	
	public void modify(final String bId,final String bName,final String bTitle,final String bContent)
	{
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent=? where bId=?";
		template.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4,Integer.parseInt(bId));
			}
		});
	}
	
	public void delete(final String bId)
	{
		String query = "delete from mvc_board where bId = ?";
		template.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));

			}
		});
	}
	
	public void write(final String bName,final String bTitle, final String bContent)
	{
		String query = "insert into mvc_board (bId,bName,bTitle,bContent,bHit,bGroup,bStep,bIndent) values (last_insert_id(),?,?,?,0,last_insert_id()+1,0,0)";
		template.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				
			}
		});
	}
	
	public void upHit(final String bId) {
		String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
		template.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
	
}

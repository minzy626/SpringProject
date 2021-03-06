package com.javalec.spring_project.dao;//실제 데이터페이스에 접근


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.javalec.spring_project.dto.BDto;

public class BDao {

	DataSource dataSource;
	
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mysql");
		}catch(NamingException e){
			e.printStackTrace();
		}
		
	}
		
	
	public ArrayList<BDto> list() {//모든 게시물 가져오기
		ArrayList<BDto>dtos=new ArrayList<BDto>();
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection =dataSource.getConnection();
			String query ="select bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent from mbv_board order by bGroup desc,bStep asc";
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int bId =resultSet.getInt("bId");
				String bName =resultSet.getString("bName");
				String bTitle =resultSet.getString("bTitle");
				String bContent =resultSet.getString("bContent");
				Timestamp bDate =resultSet.getTimestamp("bDate");
				int bHit =resultSet.getInt("bHit");
				int bGroup =resultSet.getInt("bGroup");
				int bStep =resultSet.getInt("bStep");
				int bIndent =resultSet.getInt("bIndent");
				
				BDto dto =new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
				dtos.add(dto);
			}
				
		}catch(Exception e){
			e.printStackTrace();	
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e2) {		
			}
		}
		return dtos;
		}
	public void write(String bName,String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query ="insert into mbv_board (bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent) values (?,?,?,now(),1,1,1,1)";
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			
			int rn =preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null)connection.close();
			}catch(Exception e2) {
				
			}
		}
	}
	public BDto contentView(String stId) {
		BDto dto = null;
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			
			String query ="select * from mbv_board where bid= ?";
			
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setInt(1,Integer.parseInt(stId));
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate =resultSet.getTimestamp("bDate");
				int bHit =resultSet.getInt("bHit");
				int bGroup =resultSet.getInt("bGroup");
				int bStep =resultSet.getInt("bStep");
				int bIndent =resultSet.getInt("bIndent");
				
				dto =new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e2) {		
			}
		}
				
		 return dto;
	}
	public void modify(String bId,String bName,String bTitle,String bContent) {
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query ="update mbv_board set bName =?,bTitle=?,bContent=? where bId=?";
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId));
			
			int rn = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e2) {		
			}
		}		
	}
	

	public void delete(String stId) {
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query ="delete from mbv_board where bId=?";
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setInt(1,Integer.parseInt(stId));			
			int rn = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e2) {		
			}
		}
	}
	
	
}

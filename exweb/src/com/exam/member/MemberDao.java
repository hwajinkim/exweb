package com.exam.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	{
		//사용하는 JDBC 드라이버 클래스를 메모리에 로드 (애플리케이션 실행시 최초 1회만 필요)		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	String url = "jdbc:mysql://localhost:3306/com";
	String user = "com";
	String password = "com01";

	public ArrayList<MemberVo> selectList() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		String selectSql = "SELECT mem_id,mem_pass,mem_name,mem_point FROM member";
		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(selectSql); 
				ResultSet rs = pstmt.executeQuery();	//실행 결과 데이터가 있는 SQL(select)문은 executeQuery() 메서드로 실행
		) {
			//executeQuery() 메서드는  SQL문 실행으로 조회된 데이터들을 가리키고 있는 ResultSet을 반환
			//처음에는 ResultSet은 첫번째 레코드(row) 이전을 가리키고 있고, next()를 실행할 때 마다 다음 레코드를 가르키도록 이동
			while (rs.next()) {//다음 레코드(row)가 존재하는 동안
				MemberVo vo = new MemberVo();
				vo.setMemId(rs.getString("mem_id"));
				vo.setMemPass(rs.getString("mem_pass"));
				vo.setMemName(rs.getString("mem_name"));
				vo.setMemPoint(rs.getInt("mem_point"));
				list.add(vo);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public MemberVo select(String id) {
		MemberVo vo = null;
		
		String selectSql = "SELECT mem_id,mem_pass,mem_name,mem_point FROM member where mem_id = ?";		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(selectSql); 
		) {
			pstmt.setString(1, id);
			try(ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {//다음 레코드(row)가 존재하는 동안
					vo = new MemberVo();
					vo.setMemId(rs.getString("mem_id"));
					vo.setMemPass(rs.getString("mem_pass"));
					vo.setMemName(rs.getString("mem_name"));
					vo.setMemPoint(rs.getInt("mem_point"));
				} 
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	
	public int insert(MemberVo vo) {
		int num = 0;	
		String insertSql = "insert into member (mem_id,mem_pass,mem_name,mem_point) "
				+ " values (?, ?, ?, ?)";
		
		try(
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(insertSql); 
		) {
			
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemPass());
			pstmt.setString(3, vo.getMemName());
			pstmt.setInt(4, vo.getMemPoint());

			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int update(MemberVo vo) {
		int num = 0;	
		String updateSql = "update member set mem_name=?,mem_point=? where mem_id = ? ";
		try(
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(updateSql); 
		) {
			
			pstmt.setString(1, vo.getMemName());
			pstmt.setInt(2, vo.getMemPoint());
			pstmt.setString(3, vo.getMemId());

			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}	
	
	public int delete(String memId) {
		int num=0;	
		
		String delSql = "delete from member where mem_id = ?";
		
		try(
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(delSql); 
		) {
			pstmt.setString(1, memId);
			
			num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	
}

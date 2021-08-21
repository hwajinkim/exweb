package com.exam.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BbsDao {
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

	public ArrayList<BbsVo> selectList() {
		ArrayList<BbsVo> list = new ArrayList<BbsVo>();
		
		String selectSql = "SELECT bbs_no,bbs_title,bbs_writer,bbs_reg_date FROM bbs";
		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(selectSql); 
				ResultSet rs = pstmt.executeQuery();	//실행 결과 데이터가 있는 SQL(select)문은 executeQuery() 메서드로 실행
		) {
			while (rs.next()) {//다음 레코드(row)가 존재하는 동안
				BbsVo vo = new BbsVo();
				vo.setBbsNo(rs.getInt("bbs_no"));
				vo.setBbsTitle(rs.getString("bbs_title"));
				vo.setBbsWriter(rs.getString("bbs_writer"));
				vo.setBbsRegDate(rs.getTimestamp("bbs_reg_date"));
				list.add(vo);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public BbsVo select(int id) {
		BbsVo vo = null;
		
		String selectSql = "SELECT bbs_no,bbs_title,bbs_content,bbs_writer,bbs_reg_date FROM bbs where bbs_no = ?";		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(selectSql); 
		) {
			pstmt.setInt(1, id);
			try(ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {//다음 레코드(row)가 존재하는 동안
					vo = new BbsVo();
					vo.setBbsNo(rs.getInt("bbs_no"));
					vo.setBbsTitle(rs.getString("bbs_title"));
					vo.setBbsContent(rs.getString("bbs_content"));
					vo.setBbsWriter(rs.getString("bbs_writer"));
					vo.setBbsRegDate(rs.getTimestamp("bbs_reg_date"));
				} 
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	
	public int insert(BbsVo vo) {
		int num = 0;	
		String insertSql = "insert into bbs (bbs_title, bbs_content,bbs_writer) values (?, ?, ?)";
		
		try(
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(insertSql); 
		) {
			
			pstmt.setString(1, vo.getBbsTitle());
			pstmt.setString(2, vo.getBbsContent());
			pstmt.setString(3, vo.getBbsWriter());

			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int update(BbsVo vo) {
		int num = 0;	
		String updateSql = "update bbs set bbs_title=?, bbs_content=? where bbs_no = ? ";
		try(
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(updateSql); 
		) {
			
			pstmt.setString(1, vo.getBbsTitle());
			pstmt.setString(2, vo.getBbsContent());
			pstmt.setInt(3, vo.getBbsNo());

			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}	
	
	public int delete(int no) {
		int num=0;	
		
		String delSql = "delete from bbs where bbs_no = ?";
		
		try(
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(delSql); 
		) {
			pstmt.setInt(1, no);
			
			num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	
}

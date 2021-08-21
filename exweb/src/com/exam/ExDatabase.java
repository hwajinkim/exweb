package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExDatabase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//사용하는 JDBC 드라이버 클래스를 메모리에 로드 (애플리케이션 실행시 최초 1회만 필요)
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/com";
		String user = "com";
		String password = "com01";

		boolean flag = true;
		while(flag) {	
			System.out.println("1.회원추가 2.회원목록조회 3.회원삭제 4.종료");
			String menu = sc.nextLine();

			switch (menu) {
			case "1":{
				String insertSql = "insert into member (mem_id,mem_pass,mem_name,mem_point) "
						+ " values (?, ?, ?, ?)";
				
				try(
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(insertSql); 
				) {
					System.out.println("회원 아이디 : ");
					String memId = sc.nextLine();
					System.out.println("회원 비밀번호 : ");
					String memPass = sc.nextLine();
					System.out.println("회원 이름 : ");
					String memName = sc.nextLine();
					System.out.println("회원 포인트 : ");
					int memPoint = Integer.parseInt(sc.nextLine());
					
					pstmt.setString(1, memId);
					pstmt.setString(2, memPass);
					pstmt.setString(3, memName);
					pstmt.setInt(4, memPoint);
		
					int num = pstmt.executeUpdate();	//실행 결과 데이터가 없는 SQL(insert,update,delete)문은 executeUpdate() 메서드로 실행
					System.out.println(num + "명의 회원 저장");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				break;
			case "2":{
				String selectSql = "SELECT mem_id,mem_pass,mem_name,mem_point FROM member";
				
				try(
						Connection conn = DriverManager.getConnection(url,user,password);
						PreparedStatement pstmt = conn.prepareStatement(selectSql); 
						ResultSet rs = pstmt.executeQuery();	//실행 결과 데이터가 있는 SQL(select)문은 executeQuery() 메서드로 실행
					) {
						
						//executeQuery() 메서드는  SQL문 실행으로 조회된 데이터들을 가리키고 있는 ResultSet을 반환
						//처음에는 ResultSet은 첫번째 레코드(row) 이전을 가리키고 있고, next()를 실행할 때 마다 다음 레코드를 가르키도록 이동
						while (rs.next()) {//다음 레코드(row)가 존재하는 동안
							String memId = rs.getString("mem_id");
							String memPass = rs.getString("mem_pass");
							String memName = rs.getString("mem_name");
							int memPoint = rs.getInt("mem_point");
							System.out.println(memId+" : "+memPass+" : "+memName+" : "+memPoint);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				break;
				
			case "3":{
				System.out.println("삭제할 회원의 아이디 : ");
				String memId = sc.nextLine();
				String delSql = "delete from member where mem_id = ?";
				
				try(
					Connection conn = DriverManager.getConnection(url,user,password);
					PreparedStatement pstmt = conn.prepareStatement(delSql); 
				) {
					pstmt.setString(1, memId);
					
					int num = pstmt.executeUpdate();	//실행 결과 데이터가 없는 SQL(insert,update,delete)문은 executeUpdate() 메서드로 실행
					if(num>0) {
						System.out.println(num + "명의 회원 삭제");						
					}else {
						System.out.println(memId + " 회원을 찾을 수 없습니다.");						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				break;
			case "4":
				flag = false;
				break;
			default:
				System.out.println(menu + " : 알 수 없는 메뉴입니다.");
				break;
			}
		}
	}
}

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
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
%>    
<%
	request.setCharacterEncoding("UTF-8");
	
	String memId = request.getParameter("memId");
	String memPass = request.getParameter("memPass");
	String memName = request.getParameter("memName");
	int memPoint = Integer.parseInt(request.getParameter("memPoint"));
	
	String insertSql = "insert into member (mem_id,mem_pass,mem_name,mem_point) "
			+ " values (?, ?, ?, ?)";
	
	try(
		Connection conn = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = conn.prepareStatement(insertSql); 
	) {
		
		pstmt.setString(1, memId);
		pstmt.setString(2, memPass);
		pstmt.setString(3, memName);
		pstmt.setInt(4, memPoint);
	
		int num = pstmt.executeUpdate();	//실행 결과 데이터가 없는 SQL(insert,update,delete)문은 executeUpdate() 메서드로 실행
		System.out.println(num + "명의 회원 저장");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	//요청을 보낸 브라우저에게 "/exweb/member/list.do" 주소로 이동하라는 명령을 담은 응답을 전송
	response.sendRedirect(request.getContextPath()+"/member/MemList.jsp");
%>   

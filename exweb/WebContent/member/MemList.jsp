<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
//서블릿의 service() 메서드 외부에 존재하는 자바 코드
//현재 JSP 파일이 처음 실행될 때 한 번만 실행되는 자바 코드
{
	//초기화 블럭 : 객체 생성(new) 한 후 처음 1번만 실행되는 부분
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h1>회원목록</h1>
<%-- 	<p><a href='<%out.println(request.getContextPath());%>/member/addform.do'>회원추가</a></p> --%>
	<p><a href='<%=request.getContextPath() %>/member/MemAddForm.jsp'>회원추가</a></p>
	<%
	String selectSql = "SELECT mem_id,mem_pass,mem_name,mem_point FROM member";
	
	try(
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(selectSql); 
			ResultSet rs = pstmt.executeQuery();	//실행 결과 데이터가 있는 SQL(select)문은 executeQuery() 메서드로 실행
		) {
			
			while (rs.next()) {//다음 레코드(row)가 존재하는 동안
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				int memPoint = rs.getInt("mem_point");
	%>
	<%=memId %> : <%=memPass %> : <%=memName %> : <%=memPoint %>
	<a href='<%=request.getContextPath()%>/member/MemDel.jsp?memId=<%=memId%>'><button>삭제</button></a><br/>
	<%
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	%>
</body>
</html>
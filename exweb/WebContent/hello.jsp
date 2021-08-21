<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP!</h1>
	<%
		//자바 명령문
		System.out.println("JSP 테스트입니다.");//서버 컴퓨터의 콘솔에 출력
		out.println("JSP 테스트입니다.");//요청을 보낸 웹브라우저에 출력
		int a = 123;
	%>
	<h2><%=a %></h2>
	
</body>
</html>
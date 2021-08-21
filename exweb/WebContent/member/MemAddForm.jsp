<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h1>회원추가</h1>
	<form action='<%=request.getContextPath()%>/member/MemAdd.jsp' method='post'>
	회원 아이디: <input type='text' name='memId'/><br/>
	회원 비밀번호: <input type='password' name='memPass'/><br/>
	회원 이름: <input type='text' name='memName'/><br/>
	회원 포인트: <input type='text' name='memPoint'/><br/>
	<input type='submit'/>
	</form>  
</body>
</html>
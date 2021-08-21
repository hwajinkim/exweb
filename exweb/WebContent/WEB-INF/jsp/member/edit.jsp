<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h1>회원상제정보</h1>
	<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>
	
	회원 아이디: <input type='text' name='memId' value="${memberVo.memId}"readonly="readonly"/><br/>
<!-- 	회원 비밀번호: <input type='password' name='memPass'/><br/> -->
	회원 이름: <input type='text' name='memName'value="${memberVo.memName}"/><br/>
	회원 포인트: <input type='text' name='memPoint'value="${memberVo.memPoint}"/><br/>
	<input type='submit'/>
	</form>  
	<a href='${pageContext.request.contextPath}/member/del.do?memId=${memberVo.memId}'><button>삭제</button></a>
</body>
</html>
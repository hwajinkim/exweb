<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시글 상세정보</h1>
	<form action='${pageContext.request.contextPath}/bbs/edit.do' method='post'>
	
	<input type='hidden' name='bbsNo' value="${bbsVo.bbsNo}" /><br/>
	제목 : <input type='text' name='bbsTitle' value="${bbsVo.bbsTitle}"/><br/>
	내용 : <textarea rows="10" cols="25"name='bbsContent'>${bbsVo.bbsContent}</textarea><br/>
	작성자 : <input type='text' name='bbsWriter'value="${bbsVo.bbsWriter}" disabled="disabled"/><br/>
	<input type='submit'/>
	</form>  
	<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><button>삭제</button></a>
</body>
</html>
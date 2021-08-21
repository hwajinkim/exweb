<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시글목록</h1>
	<p><a href='${pageContext.request.contextPath}/bbs/add.do'>게시글쓰기</a></p>
	<table border="1">
	<thead>
		<tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
	</thead>
	<tbody>
	<c:forEach var="vo" items="${bbsList}">
		<tr>
		<td>${vo.bbsNo}</td>
		<td><a href="${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}">${vo.bbsTitle}</a></td> 
		<td>${vo.bbsWriter}</td>
		<td><fmt:formatDate value="${vo.bbsRegDate}" pattern="yyyy년MM월dd일 HH시mm분ss초"/> </td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
</body>
</html>
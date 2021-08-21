<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h1>회원목록</h1>
<%-- 	<p><a href='<%=request.getContextPath()%>/member/addform.do'>회원추가</a></p> --%>
	<p><a href='${pageContext.request.contextPath}/member/add.do'>회원추가</a></p>
	<!-- 	// 요청객체에"memberList"라는 이름으로 요청객체에 저장되어 있는 데이터를 꺼내오기 -->
	<%-- 	<%=request.getAttribute("memberList") %> ==${requestScope.memberList}==${memberList}   --%>
	<c:forEach var="vo" items="${memberList}">
		<%-- 	객체 a의 속성(변수) b값을 가져오기 위해서, ${a.getB()} 대신 ${a.b} 표현 가능--%>
		<a href="${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}">${vo.memId}</a> : ${vo.memName}
		<br/>
	</c:forEach>
	
</body>
</html>
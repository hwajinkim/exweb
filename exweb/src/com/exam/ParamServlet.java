package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param.do")
public class ParamServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인자로 전달받은 요청 객체(HttpServletRequest)에는 
		//클라이언트(웹 브라우저)가 보낸 요청에 대한 모든 정보가 저장되어 있다.
		
		System.out.println(req.getRequestURI()); //요청 주소의 경로부분
		System.out.println(req.getRequestURL()); //요청 주소의 전체
		String method = req.getMethod();  //요청방식(HTTP COMMAND/METHOD) : GET, POST, PUT, DELETE ...
		String agent = req.getHeader("User-Agent");
		if(agent.contains("Chrome")) agent = "Chrome";
		else if(agent.contains("Firefox")) agent = "Firefox";
		else if(agent.contains("Trident")) agent = "Internet Explorer";
		else agent = "알 수 없는 브라우저";
		
		//GET 방식으로 전송된 파라미터 인코딩 설정은 톰캣 설정 파일에서 설정 가능 
		//POST 방식으로 전송된 한글 파라미터 값을 정상적으로 해석하기 위해서 문자인코딩 지정 
		req.setCharacterEncoding("UTF-8");
		String paramX = req.getParameter("x"); //파라미터 x의 값을 가져오기
		String paramY = req.getParameter("y"); //파라미터 y의 값을 가져오기

		resp.setContentType("text/html"); //응답 내용의 형태를 MIME 타입으로 지정
		resp.setCharacterEncoding("UTF-8"); //응답 내용을 UTF-8로 인코딩하여 전송 (resp.getWriter()보다 전에 실행 필요)
		PrintWriter out = resp.getWriter(); //응답 객체에 출력할 수 있는 라이터(출력 스트림) 가져오기
		

		out.println("<!DOCTYPE html>                    "); 
		out.println("<html>                             "); 
		out.println("<head>                             "); 
		out.println("<meta charset='UTF-8'>             "); 
		out.println("<title>Insert title here</title>   "); 
		out.println("</head>                            "); 
		out.println("<body>                             "); 
		out.println("	<h1>Param Servlet!</h1>            "); 
		out.println("	<h2>요청방식 : " + method + "</h2>            "); 
		out.println("	<h2>당신이 사용하는 브라우저  : " + agent + "</h2>            "); 
		out.println("	<h2>파라미터 x  : " + paramX + "</h2>            "); 
		out.println("	<h2>파라미터 y  : " + paramY + "</h2>            "); 
		out.println("</body>                            "); 
		out.println(" </html>                           "); 
	}
}
	
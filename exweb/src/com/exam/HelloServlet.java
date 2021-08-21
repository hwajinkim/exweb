package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//특정 요청 주소와 서블릿을 연결하는 2가지 방법
//1. @WebServlet("요청주소") 를 서블릿 클래스에 적용
//2. web.xml 파일에 설정을 등록
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet{
	
	//이 서블릿과 연결된 주소로 요청이 올 때마다 service() 메서드가 한 번씩 실행됨
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet!");
		
		resp.setContentType("text/html"); //응답 내용의 형태를 MIME 타입으로 지정
		resp.setCharacterEncoding("UTF-8"); //응답 내용을 UTF-8로 인코딩하여 전송 (resp.getWriter()보다 전에 실행 필요)
		PrintWriter out = resp.getWriter(); //응답 객체에 출력할 수 있는 라이터(출력 스트림) 가져오기
		//응답객체에 출력한 내용은 요청을 보낸 브라우저에게 응답으로 전송되어 브라우저 화면에 출력된다.
		
		out.println("<!DOCTYPE html>                    "); 
		out.println("<html>                             "); 
		out.println("<head>                             "); 
		out.println("<meta charset='UTF-8'>             "); 
		out.println("<title>Insert title here</title>   "); 
		out.println("</head>                            "); 
		out.println("<body>                    +         "); 
		out.println("	<h1>Hello Servlet!</h1>            "); 
		out.println("	<h1>HTML 출력 테스트</h1>            "); 
		out.println("</body>                            "); 
		out.println(" </html>                           "); 
	}
}
	
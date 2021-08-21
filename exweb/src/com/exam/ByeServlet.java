package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//특정 요청 주소와 서블릿을 연결하는 2가지 방법
//1. @WebServlet("요청주소") 를 서블릿 클래스에 적용 (근래에 지원 시작)
//2. web.xml 파일에 설정을 등록 
public class ByeServlet extends HttpServlet{
	
	//이 서블릿과 연결된 주소로 요청이 올 때마다 service() 메서드가 한 번씩 실행됨
	@Override
	protected void service(HttpServletRequest rep, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter(); //응답 객체에 출력할 수 있는 라이터(출력 스트림) 가져오기
		out.println("Bye Servlet!!!");//응답 객체에 Bye Servlet!!!를 출력
		//응답객체에 출력한 내용은 요청을 보낸 브라우저에게 응답으로 전송되어 브라우저 화면에 출력된다.
	}
}
	
package com.exam;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은  Servlet 인터페이스를 구현해야하는데,
//일반적으로 Servlet 인터페이스를 구현해 놓은  HttpServlet 클래스를 상속하여,
//필요한 메서드만 추가 또는 변경(Override)하여 구현한다.

@WebServlet("/life.do")
public class LifeServlet extends HttpServlet {
	//이 서블릿 객체가 처음 생성된 후 1번만 실행
	
	@Override
	public void init() throws ServletException {
		//앞으로 서블릿이 수행하는 작업에 필요한 초기환 작업 수행
		System.out.println("LifeServlet : init() 실행!");
	}
	
	//이 서블릿에 해당되는 주소로 요청이 올 때마다 1번씩 실행
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//요청을 해석하여 처리하고 응답을 전성하는 작업 수행
		System.out.println("LifeServlet : service() 실행!");
	}
	
	//이 서블릿 객체가 소멸되기 직전에 1번만 실행
	@Override
	public void destroy() {
		//서블릿에서 사용하고 있던 자원을 정리하고 반납하는 작업 수행
		System.out.println("LifeServlet : destroy() 실행!");
	}
}

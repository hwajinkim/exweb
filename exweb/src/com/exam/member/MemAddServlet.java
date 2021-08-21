package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/exweb/member/add.do?memId=회원아이디&memPass=비밀번호&memName=이름&memPoint=표인트
@WebServlet("/member/add.do")
public class MemAddServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDao();
	
	//service() 메서드는 요청 방식(GET,POST,PUT,DELETE,...)에 상관없이 요청이 오면 실행되는 메서드
	// do요청방식() 메서드 : 특정 요청방식으로 요청이 왔을 때에만 실행되는 메서드
	//GET 방식으로 요청이 오면 doGet() 메서드가 실행, POST 방식으로 요청이 오면 doPost() 메서드가 실행
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	/exweb/WebContent/WEB-INF/jsp/member/addForm.jsp 파일로 이동(실행)
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/member/addForm.jsp "); //지정한 경로로 요청을 위임할 수 있는 디스패쳐 가져오기
//		dispatcher.forward(req, resp);//요청객체와 응답객체를 전달하면서 지정한 경로로 이동
		req.getRequestDispatcher("/WEB-INF/jsp/member/add.jsp").forward(req, resp);
		//요청객체와 응답객체를 전달하면서 "/WEB-INF/jsp/member/addForm.jsp" 파일로 이동(실행)
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		MemberVo vo = new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
		vo.setMemName(req.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint"))); 
		
		int num = memberDao.insert(vo);
		
		System.out.println(num + "명의 회원 저장");
		//요청을 보낸 브라우저에게 "/exweb/member/list.do" 주소로 이동하라는 명령을 담은 응답을 전송
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
		
	}

	
}
	
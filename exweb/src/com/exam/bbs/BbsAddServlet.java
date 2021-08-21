package com.exam.bbs;

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
@WebServlet("/bbs/add.do")
public class BbsAddServlet extends HttpServlet{
	private BbsDao bbsDao = new BbsDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/add.jsp").forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		BbsVo vo = new BbsVo();
		vo.setBbsTitle(req.getParameter("bbsTitle"));
		vo.setBbsContent(req.getParameter("bbsContent"));
		vo.setBbsWriter(req.getParameter("bbsWriter"));
		
		int num = bbsDao.insert(vo);
		
		System.out.println(num + "개의 글 저장");
		//요청을 보낸 브라우저에게 "/exweb/member/list.do" 주소로 이동하라는 명령을 담은 응답을 전송
		resp.sendRedirect(req.getContextPath()+"/bbs/list.do");
		
	}

	
}
	
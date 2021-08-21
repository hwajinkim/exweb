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

@WebServlet("/member/del.do")
public class MemDelServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//req.setCharacterEncoding("UTF-8");
		String memId = req.getParameter("memId");	
		
		int num = memberDao.delete(memId);
		
		System.out.println(num + "명의 회원 삭제");						
		//요청을 보낸 브라우저에게 "/exweb/member/list.do" 주소로 이동하라는 명령을 담은 응답을 전송
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
	}
}
	
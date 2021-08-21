package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDao();

	//service() 메서드는 요청 방식(GET,POST,PUT,DELETE,...)에 상관없이 요청이 오면 실행되는 메서드
	//특정 요청방식으로 요청이 왔을 때에만 실행되는 메서드 : do 요청방식() 메서드
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<MemberVo> list = memberDao.selectList();
		
		//요청객체에 데이터를 key-value 쌍으로 자유롭게 저장 가능
		req.setAttribute("memberList", list);
		//변수 list에 들어있는 데이터를 "memberList"라는 이름으로 요청객체에 저장
		
		req.getRequestDispatcher("/WEB-INF/jsp/member/list.jsp").forward(req, resp);
	
	}
}
	
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

@WebServlet("/bbs/del.do")
public class BbsDelServlet extends HttpServlet{
	private BbsDao bbsDao = new BbsDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("bbsNo");	
		int no = Integer.parseInt(id);
		
		int num = bbsDao.delete(no);
		
		System.out.println(num + "개의 글 삭제");						

		resp.sendRedirect(req.getContextPath()+"/bbs/list.do");
	}
}
	
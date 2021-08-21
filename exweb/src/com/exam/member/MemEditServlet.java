package com.exam.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/edit.do")
public class MemEditServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("memId");
		MemberVo vo = memberDao.select(id);		
		req.setAttribute("memberVo", vo);		
		req.getRequestDispatcher("/WEB-INF/jsp/member/edit.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		MemberVo vo = new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemName(req.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
		
		int num = memberDao.update(vo);
		
		resp.sendRedirect(req.getContextPath()+ "/member/list.do");

	}
	
}

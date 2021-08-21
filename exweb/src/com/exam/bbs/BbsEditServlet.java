package com.exam.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bbs/edit.do")
public class BbsEditServlet extends HttpServlet{
	private BbsDao bbsDao = new BbsDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("bbsNo");
		int no = Integer.parseInt(id);
		BbsVo vo = bbsDao.select(no);		
		req.setAttribute("bbsVo", vo);		
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/edit.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		BbsVo vo = new BbsVo();
		vo.setBbsNo(Integer.parseInt(req.getParameter("bbsNo")));
		vo.setBbsTitle(req.getParameter("bbsTitle"));
		vo.setBbsContent(req.getParameter("bbsContent"));
		
		int num = bbsDao.update(vo);
		
		resp.sendRedirect(req.getContextPath()+ "/bbs/list.do");

	}
	
}

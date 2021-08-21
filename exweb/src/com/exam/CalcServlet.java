package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/exweb/calc.do?x=2&op=plus&y=3 이렇게 요청을 보내면,
//브라우저 화면에 2 + 3 = 5 와 같은 계산 결과가 출력
//연산 종류를 나타내는 op 펴라미터 값은 plus, minus, mul, div 로 + - * - 사칙연산을 표현
@WebServlet("/calc.do")
public class CalcServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//POST 방식으로 전송된 한글 파라미터 값을 정상적으로 해석하기 위해서 문자인코딩 지정 
		req.setCharacterEncoding("UTF-8");
		
		String paramX = req.getParameter("x"); //파라미터 x의 값을 가져오기
		String paramY = req.getParameter("y"); //파라미터 y의 값을 가져오기
		String paramOp = req.getParameter("op"); //파라미터 y의 값을 가져오기
		double numX = Double.parseDouble(paramX);//실수 문자열 paramX를 실수 numX로 변환
		double numY = Double.parseDouble(paramY);//실수 문자열 paramY를 실수 numY로 변환



		resp.setContentType("text/html"); //응답 내용의 형태를 MIME 타입으로 지정
		resp.setCharacterEncoding("UTF-8"); //응답 내용을 UTF-8로 인코딩하여 전송 (resp.getWriter()보다 전에 실행 필요)
		PrintWriter out = resp.getWriter(); //응답 객체에 출력할 수 있는 라이터(출력 스트림) 가져오기
		

		out.println("<!DOCTYPE html>                    "); 
		out.println("<html>                             "); 
		out.println("<head>                             "); 
		out.println("<meta charset='UTF-8'>             "); 
		out.println("<title>Insert title here</title>   "); 
		out.println("</head>                            "); 
		out.println("<body>                             "); 
		out.println("	<h1>계산결과</h1>            "); 
		switch (paramOp) {
		case "plus":
			out.println("	<h2>" + paramX + "+" + paramY + "="+ (numX+numY) +"</h2>            "); 
			break;
			
		case "minus":
			out.println("	<h2>" + paramX + "-" + paramY + "="+ (numX-numY) +"</h2>            "); 
			break;
			
		case "mul":
			out.println("	<h2>" + paramX + "*" + paramY + "="+ (numX*numY) +"</h2>            "); 
			break;
			
		case "div":
			out.println("	<h2>" + paramX + "/" + paramY + "="+ (numX/numY) +"</h2>            "); 
			break;
			
		default:
			out.println("	<h2> 알 수 없는 연산자 : "+ paramOp +"</h2>            "); 

			break;
		}
		
		out.println("</body>                            "); 
		out.println(" </html>                           "); 
	}
}
	
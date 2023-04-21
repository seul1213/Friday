package com.exame.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calc.do")
public class CalServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String xval = req.getParameter("x");
		String yval = req.getParameter("y");
		String op=req.getParameter("op");
		
		Double xnum =Double.parseDouble(xval); 
		Double ynum =Double.parseDouble(yval);
		 
		//op 파라미터값에 맞는 사칙연산을 수행
		//문자열 값을 동등비교하는 경우,==연산자가 아닌 .equals() 메서드 사용
		//"문자열1"=="문자열2"(x) 
		//"문자열1".equals("문자열")(o)
		 
			 
		
		
		
		
//		 Double result =xnum+ ynum; 
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		out.println("<!DOCTYPE html>        ");
		out.println("<html>                 ");
		out.println("<head>                 ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>HELLO</title>   ");
		out.println("</head>                ");
		out.println("<body>                 ");
//		if(op.equals("plu"))
//	      out.println("<h1> " + xval+ "+" + yval +"="+(xnum+ynum)+ " </h1>"); 
//		else if(op.equals("min"))
//		      out.println("<h1> " + xval+ "-" + yval +"="+(xnum-ynum)+ " </h1>"); 
//		else if(op.equals("mul"))
//		      out.println("<h1> " + xval+ "*" + yval +"="+(xnum*ynum)+ " </h1>"); 
//		
//		else
//		if(ynum!=0)
//		      out.println("<h1> " + xval+ "/" + yval +"="+(xnum/ynum)+ " </h1>"); 
		out.println("</body>                ");
		out.println("</html>                ");
	
		Double result =0.0;
		String operator="";
		switch(op){
		case "plu": 
		result =xnum + ynum;
		operator="+";
		break;
		case "min": 
		result =xnum - ynum;
		operator="-";
		break;
		case "mul": 
		result =xnum * ynum;
		operator="*";
		break;
		case "div": 
		operator="/";
		result =xnum / ynum;
		break;}
		out.println("<h1> " + xnum+ operator + ynum +"="+result+ " </h1>"); 
		}
	}



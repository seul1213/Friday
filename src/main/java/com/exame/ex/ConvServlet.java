package com.exame.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dollar")
public class ConvServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String numval = req.getParameter("num");
		String unitval = req.getParameter("unit");
		
		
		double fromMoney=Double.parseDouble(numval); 
		
		 
		
		
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

//	      out.println("<h1> " + xval+ "+" + yval +"="+(xnum+ynum)+ " </h1>"); 

		out.println("</body>                ");
		out.println("</html>                ");
	
		double result =0;
		String fromUnit="";
		String toUnit="";
		switch(unitval){
		case "won": 
			result= fromMoney / 1287;//원->달러
			fromUnit="원";
			toUnit="달러";
		break;
		case "dol": 
			result=fromMoney *1287;//달러->원
			fromUnit="달러";
			toUnit="원";
		break;
		}
		out.println("<h1> " + fromMoney + fromUnit  +"="+ result+toUnit+ " </h1>"); 
		}
	}



package com.exame.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.runtime.ProtectedFunctionMapper;

public class ByeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ByeServlet 실행!");
		
		PrintWriter out = resp.getWriter();
		out.println("Bye Bye");
		
	
		
	}

}
//1.웹브라우저에서 http://localhost:8000/exwebd/by.do로 접속하면,
//웹브라우저 화면에 "Bye Bye" 라고 출력되도록 ByeSevlet 클래스로 변경하세요

//2.웹브라우저에 http://localhost:8000/exwebd/by.do로 접속하면,
//웹브라우저 화면에 "Welcome" 이라고 출력되도록 HiServlet 클래스를 새로 추가 하세요
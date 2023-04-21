package com.exame.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/add.do")
public class MemAddServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDaoJdbc();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");필터로 이동(23.04.21수업)
		MemberVo vo=new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
		vo.setMemName(req.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
		
//		String memId = req.getParameter("memId");
//		String memPass = req.getParameter("memPass");
//		String memName = req.getParameter("memName");
//		int memPoint =Integer.parseInt(req.getParameter("memPoint")) ;
		
		
		int n = memberDao.insertMember(vo);
		
		System.out.println(n+"명의 회원 추가");
		
		
		//finally{ 사용시 선언부분을 try밖으로 그 후 예외처리하기,null체크하고 호출(자바6버전까지)
		//pstmt.colse(); 명령문 객체가 사용하던 자원 반납
		//conn.colse(); 데이터베이스와 연결종료}	
		
		//0407 회원목록 출력
		//MemListServlet 실행!
		//forward: 요청객체와 응답객체를 전달하면서, 지정한 주소의 서블릿을 실행
		//		현재 서블릿에서든 더 이상 응답을 출력하지 않는다
		//req.getRequestDispatcher("/member/list.do").forward(req, resp);
		//inClud:요청객체와 응답객체를 전달하면서, 지정한 주소의 서블릿을 실행
		//		현재 서블릿의 출력 내용 중간에 지정한 서블릿의 출력 내용을 포함,
		//req.getRequestDispatcher("/member/list.do").include(req, resp);
		//redirect :지정한 주소로 이동하라는 명령을 담은 응답을 웹브라우저에게 전송
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
				
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		out.println("<!DOCTYPE html>        ");
//		out.println("<html>                 ");
//		out.println("<head>                 ");
//		out.println("<meta charset=\"UTF-8\"> ");//''나 \\사용가능
//		out.println("<title>회원관리</title>   ");
//		out.println("</head>                ");
//		out.println("<body>                 ");
//		out.println("<h1>"+ n +"명의 회원 추가 성공 </h1>");	
//		out.println("<a href=" + req.getContextPath()+"/member/list.do>" + "회원목록으로 이동");
//		out.println("</body>                ");
//		out.println("</html>                ");
	}


	
	
	
	
	
}

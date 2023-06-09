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

//웹브라우저에서 
//http://localhost:8000/exweb/member/del.do?memId=삭제할회원아이디
//로 요청을보내면,지정한 회원 정보를 데이터베이스에서 삭제하고
//"몇명의 회원 삭제 성공" 메시지와 "회원목록으로 이동"링크를 화면에 출력
//회원삭데 SQl문:DELETE FROM member  WHERE mem_id= '';

@WebServlet("/member/del.do")
public class MemDelServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDaoJdbc();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		String memId = req.getParameter("memId");
//		String memPass = req.getParameter("memPass");
//		String memName = req.getParameter("memName");
//		int memPoint =Integer.parseInt(req.getParameter("memPoint")) ;
		
		
		int n = memberDao.deleteMember(memId);
		
		System.out.println(n+"명의 회원 삭제");
		
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		/* System.out.println("ParamServlet"); */
//		out.println("<!DOCTYPE html>        ");
//		out.println("<html>                 ");
//		out.println("<head>                 ");
//		out.println("<meta charset=\"UTF-8\"> ");//''나 \\사용가능
//		out.println("<title>회원관리</title>   ");
//		out.println("</head>                ");
//		out.println("<body>                 ");
//		out.println("<h1>"+ n +"명의 회원 삭제 성공 </h1>");	
//		out.println("<a href=" + req.getContextPath()+"/member/list.do>" + "회원목록으로 이동");
//		out.println("</body>                ");
//		out.println("</html>                ");
	}


	
	
	
	
	
}

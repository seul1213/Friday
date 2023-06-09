package com.exame.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원목록 화면에 "회원추가" 링크를 추가하고,
//그 링크를 클릭하면, 회원정보를 입력하는 폼 화면으로 이동하도록
//MemberListServlet 클래스를 변경하세요


//회원정보 추가 후에 "회원목록으로 이동" 링크를 추가하고
//그 링크를 클릭하면, 회원목록를 입력하는 폼 화면으로 이동하도록
//MemberListServlet 클래스를 변경하세요

//회원목록의 각 회원정보 옆에 "삭제" 링크르르 출력하고,
//링크를 클릭하면 해당 회원이 삭제되도록
//MemberListServlet 클래스를 변경하세요
@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDaoBatis();
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {			
		List<MemberVo> list = memberDao.selectMemberList();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		/* System.out.println("ParamServlet"); */
		out.println("<!DOCTYPE html>        ");
		out.println("<html>                 ");
		out.println("<head>                 ");
		out.println("<meta charset=\"UTF-8\"> ");//''나 \\사용가능
		out.println("<title>회원관리</title>   ");
		out.println("</head>                ");
		out.println("<body>                 ");
		out.println("<h1>회원목록</h1>               ");
		out.println("<a href=" + req.getContextPath() + "/member/addform.do>"+"회원목록</a>");		
		for (MemberVo vo : list) {
//			System.out.println(mem_id + ":" + MEM_PASS + ":" + MEM_NAME + ":" + MEM_POINT );		
			out.println("<p>" + vo.getMemId() + ":" + vo.getMemPass() + ":" + vo.getMemName() + ":" + vo.getMemPoint() );	
			out.println("<a href=" + req.getContextPath() + "/member/del.do?memId=" + vo.getMemId() + "><button type='button'>삭제</button></a>");
			out.println("</p>");
		}

		out.println("</body>                ");
		out.println("</html>                ");
	}


}

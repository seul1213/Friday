package com.exame.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿의 생명주기(Life Cycle):
//서블릿 객체의 생성부터 소멸까지, 특정 시점에 자동으로 실행되는 메서드들


	@WebServlet("/Life.do")
	public class LifeServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		//서블릿 객체가 처음 생성된 후 최초 1번만 실행
		//일반적으로 서블릿이 요청을 처리할 때 필요한 자원들을 준비하는 작업을 수행
		System.out.println("LifeServlet  init...");
	}
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//요청이 올 때마다 한번씩 반복 실행 무조건 실행하고 싶을때
//		System.out.println("LifeServlet  service....");	
//	}
	
	//HttpServlet의 service() 메서드 요청방식에 따라서
	//do요청방식() 메서드를 실행하도록 구현되어 있다.
	//특정 요청방식으오 요청이 온 경우에만 수행하고 싶은 작업이 있는 경우에
	//do요청방식() 메서드를 사용하여 구현가능
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET 방식으로 요청이 올 때마다 한번씩 반복 실행
		System.out.println("LifeServlet  doGet...");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post 방식으로 요청이 올 때마다 한번씩 반복 실행
		System.out.println("LifeServlet  doPost...");
	}
	
	@Override
	public void destroy() {
		//톰캣을 끌때 오랫동안 사용을 안해서 메모리에 공간이 없을때
		//서블릿 객체가 소멸되기 직전에 마지막으로 1번만 실행
		//일반적으로 서블릿이 사용하던 자원들을 정리하고 반납하는 작업을 수행
		System.out.println("LifeServlet  destroy...");
	}
	
}
